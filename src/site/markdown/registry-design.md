#	Introduction

The PDS4 effort will overhaul the PDS data architecture (e.g., data model, data structures, data dictionary, etc) and deploy a software system (online data services, distributed data catalog, etc) that fully embraces the PDS federation as an integrated system while leveraging modern information technology.

This service provides functionality for tracking, auditing, locating, and maintaining artifacts within the system. These artifacts can range from data files and label files, schemas, dictionary definitions for objects and elements, services, etc.

##	Document Scope and Purpose 

This document addresses the use cases, requirements and software design of the Registry service within the PDS4 data system. This document is intended for the reviewer of the service as well as the developer and tester of the service.

The information in this document is largely inherited from the original legacy design detailed in the [SRD/SDD developed in 2013](artifacts/registry/pds4_registry_legacy_design_20130901.docx).

##	Controlling Documents

1. Planetary Data System (PDS) Level 1, 2 and 3 Requirements, March 26, 2010.
2. PDS4 Project Plan, July 17, 2013.
3. PDS4 System Architecture Specification, Version 1.3, September 1, 2013.
4. PDS4 Operations Concept, September 1, 2013.
5. Planetary Data System (PDS) General System Software Requirements Document (SRD), Version 1.1, September 1, 2013.

##	Applicable Documents

6. CCSDS Registry Reference Model, CCSDS 314.0-W-3, Draft White Book, December 28, 2010.
7. PDS4 Information Model Specification, PDS4 Information Model Specification Team.
8. Planetary Data System Security Service Software Requirements and Design Document (SRD/SDD), Version 1.1, September 1, 2013.
9. Planetary Data System Search Service Software Requirements and Design Document (SRD/SDD), Version 1.1, September 1, 2013.
10. Registry Services, May 31, 2009.

## Document Maintenance

The component design will evolve over time and this document should reflect that evolution. This document is limited to design content because the specification content will be captured in separate documentation (e.g., Installation Guide, Operation Guide, etc.). This document is under configuration control in Github.

---
 
# Component Description

The Registry service provides the track and locate artifact function for the PDS4 system (referred to as the “system” from this point forward). The intent of this service is to facilitate tracking, auditing and maintenance of artifacts within PDS (e.g., data, dictionary definitions, schemas, services, etc.). The following diagram details the context of the Registry service, represented as the Inventory, Dictionary, Document and Service services, within the system:

**TBD updates needed for this diagram**

Figure 1: Registry Service Context Diagram

<img src="images/legacy_architecture_diagram.png" alt="registry context" width="500"/>

Within the system, the Registry service will have a limited set of external interfaces and will mostly interact with other system components. The rationale behind this is to reduce the complexity of the service as its functions are at the core of the system. Other services will build upon the information maintained in any given registry and will expose this registry-based information via external interfaces. This separation of concerns will help the system evolve as any external requirements can be leveraged on other services and thus reducing the impact to this core component. 

As depicted in the diagram above, the Registry service supports several interfaces to other services in the system. In general, these services will interact with the registry to inform the service about a new managed artifact or lookup/update basic information about an existing registered artifact. The registry will maintain three types of registrations:

#### Non-Digital Object Entry
This type of entry will simply capture metadata describing a non-digital object within the system. This type of entry in the existing PDS infrastructure is akin to descriptions captured for missions, instruments, data sets, targets, people, etc.

#### Digital Object Entry
This type of entry tracks back to a physical set of bits. In the current PDS infrastructure, this includes items such as science data products, documents, schemas, etc. 

#### Relationship Entry
This type of entry will serve as a means to tie registered products together. Such support is necessary for example to correlate collections to the set of products contained within. These relationships may span registries and thus the need for coordination amongst registries exists. Example product relationships include associations with an investigation product, an instrument product and a target product. The supported list of relationships can be found in the Information Model [7].

Although the current PDS system does not have an official registry service, there are pieces within the existing architecture that act in the capacity of a registry. One example of this is the current catalog, which maintains data set, mission, instrument, and other descriptions. Yet, another example is the archive directory structure itself, which organizes and associates data and label files for a particular data set or volume. Moreover, nodes generally have a catalog of products that participates in the existing infrastructure through product and/or profile servers. A Registry service instance would not seek to replace the nodes existing catalog but act as the infrastructure component equivalent. The following is an accounting of logical registries that would be available within the system:

#### Inventory
As indicated above this registry instance serves as a means to capture the products within the PDS. Registration of products will occur by crawling local repositories at the nodes. Products will remain within their local repositories and only enough information to locate and audit the product is gathered. This information will include, but not be limited to: access points, checksum, file name, and file size. 

#### Dictionary
This registry captures and stores object, group and element definitions that make up the data dictionary. Management of these definitions occurs in the Information Model [7], which exports this information periodically to this logical instance of the service.

#### Document
With the transition to XML, management of schemas, which govern XML instance files (e.g., product labels), becomes of utmost importance. Schemas must be captured and readily available and this registry will provide this role.

#### Service
This registry captures descriptions about services provided by the system. PDS participants can share their services via this registry to help promote reuse. These descriptions could evolve over time from simple documentation in the form of a web page or document to something along the lines of a WSDL or WADL formatted description. The service registry will not dictate interaction with a given service but rather exist as a means to document and promote existing services.

The service defined in this document will provide the PDS4 system with a single implementation of registry capabilities for use by the other services and applications within the system. This service is tailor-able depending on the type of registry and types of artifacts to be registered with a given instance.

---

# Use Cases

A use case represents a capability of the component and why the user (actor) interacts with the system. It should be at a high enough level so as not to reveal or imply the internal structure of the system. An actor is an object (e.g., person, application, etc.) outside the scope of the component but interacts with the component. This section captures the use cases for the Registry service based on the description of the service from the previous section as well as use cases defined in the CCSDS Registry Reference Model [6]. These use cases will be used in the derivation of requirements for the service. The following diagram details the use cases:

Figure 2: Registry Service Use Cases

<img src="images/legacy_registry_use_cases.png" alt="registry use cases" width="500"/>

The above diagram identifies the following actors (represented as stick figures):

**Data Engineer**
This actor represents a portion of the PDS Technical group that curates the data before and after it enters the PDS system.

**Harvest/Ingest Service**
This actor represents the software within the system that will perform automated registration of artifacts.

**Operator**
This actor represents a portion of the PDS Technical group that is responsible for configuring and monitoring the system.

**Search Service**
This actor represents the software within the system that will query for registered products.

The following sections detail the use cases identified in the above diagram.

## Manage Policy

The Registry service is policy driven with regard to the types of artifacts that it registers, the associated metadata it expects to receive for an artifact and the allowed operations on a type of artifact. This use case pertains to the Operator actor.

1.  Operator authenticates for access to the Registry service interface (include Security service Authenticate User use case [8]).
2.  Operator submits an update to the Registry service policy to add, modify or delete a type of artifact via the Registry service interface.
3.  Registry service accepts (verifies input against constraints) and commits (updates the underlying metadata store) the operation.

## Publish Artifact

Register artifacts with the system for the purpose of tracking, discovery and retrieval. This use case pertains to the Ingest and Harvest services that will perform automated registration of artifacts. It also pertains to the Data Engineer who will perform ad hoc registrations of artifacts within the system.

1.  Ingest/Harvest service authenticates for access to the Registry service API (include Security service Authenticate User use case [8]).
2.  Ingest/Harvest service submits an artifact for registration via the Registry service API.
3.  Registry service validates the metadata submitted for the artifact.
4.  Registry service assigns a version to the artifact based on the PDS identifier.
5.  Registry service records the metadata associated with the artifact in the underlying metadata store.

Alternative: Ad Hoc Registration
At step 1, the Data Engineer initiates the artifact registration.
a.  Data Engineer authenticates for access to the Registry service interface (include Security service Authenticate User use case [8]).
b.  Data Engineer submits an artifact for registration via the Registry service interface.
c.  Return to primary scenario at step 3.

## Update Artifact

Update a registered artifact and its associated metadata. This use case pertains to the Data Engineer who will perform artifact registration updates within the system.

1.  Data Engineer authenticates for access to the Registry service interface (include Security service Authenticate User use case [8]).
2.  Data Engineer submits an updated artifact for registration via the Registry service interface.
3.  Registry service validates the metadata submitted for the artifact.
4.  Registry service records the metadata associated with the artifact in the underlying metadata store.

## Approve Artifact

Approve registered artifacts in order to make them visible to the public. This use case pertains to the Data Engineer who will approve registered artifacts.

1.  Data Engineer authenticates for access to the Registry service interface (include Security service Authenticate User use case [8]).
2.  Data Engineer marks a registered artifact as approved via the Registry service interface.
3.  Registry service records the approval in the underlying metadata store.

## Deprecate Artifact

Deprecate registered artifacts when no longer pertinent. This could be due to the availability of a newer version of the artifact. This use case pertains to the Data Engineer who will deprecate registered artifacts.

1.  Data Engineer authenticates for access to the Registry service interface (include Security service Authenticate User use case [8]).
2.  Data Engineer marks a registered artifact as deprecated via the Registry service interface.
3.  Registry service records the deprecation in the underlying metadata store.

## Undeprecate Artifact

Undeprecate registered artifacts when their pertinence has been restored. This use case pertains to the Data Engineer who will undeprecate registered artifacts.

4.  Data Engineer authenticates for access to the Registry service interface (include Security service Authenticate User use case [8]).
5.  Data Engineer marks a registered artifact as undeprecated via the Registry service interface.
6.  Registry service records the undeprecation in the underlying metadata store.

## Delete Artifact

Delete registered artifacts from the registry. This will normally be utilized during testing but could be utilized during operations if a registration was made my mistake. Privilege for this capability should be limited. This use case pertains to the Data Engineer actor who will delete registered artifacts.

1.  Data Engineer authenticates for access to the Registry service interface (include Security service Authenticate User use case [8]).
2.  Data Engineer marks a registered artifact as deleted via the Registry service interface.
3.  Registry service deletes the metadata associated with the artifact in the underlying metadata store.

Alternative: Operation Not Allowed
At step 3, the Registry service does not allow the operation per policy.
a.  Registry service checks policy for allowed operations.
b.  Registry service does not allow deletion of the artifact per policy.

## Query Artifact

Discover registered artifacts from the registry by submitting queries against the registered metadata attributes. This use case pertains to the Data Engineer and Search service actors.

1.  Search service submits a query for artifact(s) via the Registry service API.
2.  Registry service accepts the query and returns metadata for one or more artifacts from the underlying metadata store matching the criteria.

---

# Requirements

The architecture definition phase of the PDS4 project resulted in the decomposition of the system into several elements [3]. The Registry service derives from the Catalog/Data Management element, which was derived from requirements 2.2.2 and 2.6 of the PDS Level 1, 2, and 3 Requirements document [1]. The following level 3 requirements are relevant to this service:

2.2.2   PDS will track the status of data deliveries from data providers through the PDS to the deep archive
2.6.2   PDS will design and implement a catalog system for managing information about the holdings of the PDS
2.6.3   PDS will integrate the catalog with the system for tracking data throughout the PDS 
2.8.2   PDS will maintain a distributed catalog system which describes the holdings of the archive
2.8.3   PDS will provide standard protocols for locating, moving, and utilizing data, metadata and computing resources across the distributed archive, among PDS nodes, to and from missions, and to and from the deep archive

In addition to the level 4 and 5 requirements specified below, the Registry service must also comply with the general service-based requirements found in the General System SRD document [5].

## Level 4 Requirements

The level four requirements in PDS represent subsystem or component requirements at a high level. The following requirements pertain to the Registry service:

**L4.REG.1** - The system shall maintain distributed registries of artifacts. (2.6.2, 2.8.2)

Ideally, each PDS Node that maintains a repository of data will have a corresponding registry.

**L4.REG.2** - The system shall federate the registries. (2.8.2)

To federate is to form a single centralized unit from a number of entities, within which each keeps some internal autonomy.

**L4.REG.3** - The system shall register artifacts of a data delivery into an instance of the registry. (2.2.2, 2.6.2)

A data delivery consists of artifacts including but not limited to data, document and software.

**L4.REG.4** - The system shall allow for management of the metadata associated with registered artifacts. (2.6.2)

## Level 5 Requirements

Level 5 Requirements are detailed in [Github Issues](https://github.com/NASA-PDS/registry/issues?q=is%3Aissue+label%3Arequirement+)


