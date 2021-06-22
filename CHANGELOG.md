# Changelog

## [v0.4.0-SNAPSHOT](https://github.com/NASA-PDS/pds-registry-app/tree/v0.4.0-SNAPSHOT) (2021-06-22)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/v0.3.1...v0.4.0-SNAPSHOT)

**Requirements:**

- As a developer, I want to extend the registry-mgr and harvest using the Java API [\#153](https://github.com/NASA-PDS/pds-registry-app/issues/153)
- As a node operator, I want the the registry schema to update autonomously when new data is ingested. [\#146](https://github.com/NASA-PDS/pds-registry-app/issues/146)
- As a node operator, I want to ingest metadata regarding secondary products that belong to a collection. [\#143](https://github.com/NASA-PDS/pds-registry-app/issues/143)

**Improvements:**

- Initial deployment of API on AWS - ASG/ELB solution [\#122](https://github.com/NASA-PDS/pds-registry-app/issues/122)

**Defects:**

- Unable to ingest secondary products [\#168](https://github.com/NASA-PDS/pds-registry-app/issues/168) [[s.medium](https://github.com/NASA-PDS/pds-registry-app/labels/s.medium)]

**Other closed issues:**

- Deploy latest version of pds-registry-app to pds-gamma [\#167](https://github.com/NASA-PDS/pds-registry-app/issues/167)

## [v0.3.1](https://github.com/NASA-PDS/pds-registry-app/tree/v0.3.1) (2021-05-07)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/v0.3.0...v0.3.1)

**Requirements:**

- The service shall provide a staging capability for artifacts staged for release [\#65](https://github.com/NASA-PDS/pds-registry-app/issues/65)
- The service shall require user authorization for updating registry metadata [\#66](https://github.com/NASA-PDS/pds-registry-app/issues/66)
- The service shall require checksums as metadata for registry artifact to enable system-wide integrity checking [\#68](https://github.com/NASA-PDS/pds-registry-app/issues/68)
- The service shall allow for queries for registered artifacts [\#55](https://github.com/NASA-PDS/pds-registry-app/issues/55)
- The service shall allow deletion of registered artifacts [\#70](https://github.com/NASA-PDS/pds-registry-app/issues/70)
- The service shall allow updates to registered artifacts [\#71](https://github.com/NASA-PDS/pds-registry-app/issues/71)
- The service shall store metadata for a registered artifact in an underlying metadata store [\#72](https://github.com/NASA-PDS/pds-registry-app/issues/72)
- The service shall require a logical identifier and version be provided for all registered artifacts [\#73](https://github.com/NASA-PDS/pds-registry-app/issues/73)
- The service shall assign a global unique identifier to a registered artifact [\#56](https://github.com/NASA-PDS/pds-registry-app/issues/56)
- The service shall accept metadata for a registered artifact in a defined format [\#75](https://github.com/NASA-PDS/pds-registry-app/issues/75)
- The service shall maintain configuration regarding the classes of artifacts to be registered [\#59](https://github.com/NASA-PDS/pds-registry-app/issues/59)
- The service shall provide a means identifying relationships between artifact registrations [\#58](https://github.com/NASA-PDS/pds-registry-app/issues/58)
- The service shall accept artifact registrations. [\#57](https://github.com/NASA-PDS/pds-registry-app/issues/57)

**Improvements:**

- Update Registry App landing page to divert data users to separate landing page for using the PDS API [\#158](https://github.com/NASA-PDS/pds-registry-app/issues/158)

**Other closed issues:**

- Work w/ SAs to define production deployment strategy in AWS [\#159](https://github.com/NASA-PDS/pds-registry-app/issues/159)
- Employ budget alerts and if possible, rate/egress limits on AWS services [\#151](https://github.com/NASA-PDS/pds-registry-app/issues/151)
- Perform trade study and implement revised version of attribute search [\#60](https://github.com/NASA-PDS/pds-registry-app/issues/60)

## [v0.3.0](https://github.com/NASA-PDS/pds-registry-app/tree/v0.3.0) (2021-04-19)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/v0.2.4...v0.3.0)

**Requirements:**

- As a node operator,  I want to be able to tag ingested data with the node it is ingested by. [\#147](https://github.com/NASA-PDS/pds-registry-app/issues/147)
- As a developer, I want to include supplemental file data sizes in the registry [\#145](https://github.com/NASA-PDS/pds-registry-app/issues/145)
- As a node operator, I want to ingest metadata regarding secondary collections that belong to a bundle. [\#144](https://github.com/NASA-PDS/pds-registry-app/issues/144)
- As a node operator, I want actionable, user-friendly error messages for registry schema failures [\#142](https://github.com/NASA-PDS/pds-registry-app/issues/142)
- As a manager, I want a cost model for deploying a registry + API in AWS [\#141](https://github.com/NASA-PDS/pds-registry-app/issues/141)

**Improvements:**

- Verify pds-registry-app doc is up to date, have registry configuration in the harvest conf examples [\#133](https://github.com/NASA-PDS/pds-registry-app/issues/133)
- Develop ElasticSearch client library to be utilized by harvest / registry-mgr [\#131](https://github.com/NASA-PDS/pds-registry-app/issues/131)
- Create a registry docker for developer testing [\#129](https://github.com/NASA-PDS/pds-registry-app/issues/129)
- load data for kibana test [\#127](https://github.com/NASA-PDS/pds-registry-app/issues/127)
- analyze need, propose architecture [\#125](https://github.com/NASA-PDS/pds-registry-app/issues/125)
- Update registry-mgr documentation as stated in \#86 [\#123](https://github.com/NASA-PDS/pds-registry-app/issues/123)
- Develop kibana configuration for EN registry UI [\#120](https://github.com/NASA-PDS/pds-registry-app/issues/120)
- Manage product relationships v2 - collection inventories [\#114](https://github.com/NASA-PDS/pds-registry-app/issues/114)
- Have pds4 properties syntax match the syntax decided for the PDS API [\#113](https://github.com/NASA-PDS/pds-registry-app/issues/113)
- Update Registry API per PDS API v0-beta [\#92](https://github.com/NASA-PDS/pds-registry-app/issues/92)

**Defects:**

- docker build is version locked [\#135](https://github.com/NASA-PDS/pds-registry-app/issues/135) [[s.medium](https://github.com/NASA-PDS/pds-registry-app/labels/s.medium)]
- Make example harvest configuration more explicit [\#112](https://github.com/NASA-PDS/pds-registry-app/issues/112) [[s.high](https://github.com/NASA-PDS/pds-registry-app/labels/s.high)]
- Test data in pds-registry-app-0.2.2-bin.zip is missing data products. [\#110](https://github.com/NASA-PDS/pds-registry-app/issues/110) [[s.high](https://github.com/NASA-PDS/pds-registry-app/labels/s.high)]

**Other closed issues:**

- As a manager, I want to understand the distinct types of data contained within the archive [\#134](https://github.com/NASA-PDS/pds-registry-app/issues/134)
- Install a test registry and kibana [\#121](https://github.com/NASA-PDS/pds-registry-app/issues/121)
- Test registry-app multi-node deployment [\#118](https://github.com/NASA-PDS/pds-registry-app/issues/118)
- Update collection products with parent bundle reference [\#116](https://github.com/NASA-PDS/pds-registry-app/issues/116)
- Parse collection inventories and add parent collection reference to products [\#115](https://github.com/NASA-PDS/pds-registry-app/issues/115)
- Deploy Registries in AWS [\#91](https://github.com/NASA-PDS/pds-registry-app/issues/91)
- Deploy EN Registry in AWS [\#86](https://github.com/NASA-PDS/pds-registry-app/issues/86)
- Registry Integration component [\#81](https://github.com/NASA-PDS/pds-registry-app/issues/81)
- Update pds-registry-app to use new pds-registry-mgr-elastic [\#40](https://github.com/NASA-PDS/pds-registry-app/issues/40)

## [v0.2.4](https://github.com/NASA-PDS/pds-registry-app/tree/v0.2.4) (2021-01-05)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/v0.2.3...v0.2.4)

**Requirements:**

- The service shall require a subset of file system metadata in order to support data metrics generation [\#67](https://github.com/NASA-PDS/pds-registry-app/issues/67)

**Improvements:**

- Prep Registry Demo for Discipline Nodes [\#107](https://github.com/NASA-PDS/pds-registry-app/issues/107)
- Manage PDS4 product relationships [\#27](https://github.com/NASA-PDS/pds-registry-app/issues/27)

**Defects:**

- Test data in pds-registry-app-0.2.2-bin.zip contains invalid PDS4 labels [\#109](https://github.com/NASA-PDS/pds-registry-app/issues/109) [[s.high](https://github.com/NASA-PDS/pds-registry-app/labels/s.high)]

**Other closed issues:**

- Manage relationships between bundles / collections / products [\#76](https://github.com/NASA-PDS/pds-registry-app/issues/76)
- Integrate Registry API into pds-registry-app [\#42](https://github.com/NASA-PDS/pds-registry-app/issues/42)

## [v0.2.3](https://github.com/NASA-PDS/pds-registry-app/tree/v0.2.3) (2020-12-21)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/0.2.3...v0.2.3)

## [0.2.3](https://github.com/NASA-PDS/pds-registry-app/tree/0.2.3) (2020-12-21)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/v0.2.2...0.2.3)

**Improvements:**

- Add the API to the pds-registry-app package, with documentation [\#102](https://github.com/NASA-PDS/pds-registry-app/issues/102)

**Defects:**

- harvest and registry manager in pds-registry-app-0.2.2-bin.zip are missing batch scripts for windows [\#108](https://github.com/NASA-PDS/pds-registry-app/issues/108) [[s.medium](https://github.com/NASA-PDS/pds-registry-app/labels/s.medium)]
- Issues with Registry App Documentation [\#106](https://github.com/NASA-PDS/pds-registry-app/issues/106)

**Other closed issues:**

- Manage relationships described by reference types [\#77](https://github.com/NASA-PDS/pds-registry-app/issues/77)

## [v0.2.2](https://github.com/NASA-PDS/pds-registry-app/tree/v0.2.2) (2020-12-03)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/0.2.1...v0.2.2)

**Improvements:**

- update registry-manager load-data to handle additional use cases [\#103](https://github.com/NASA-PDS/pds-registry-app/issues/103)
- Beta test operational deployment [\#13](https://github.com/NASA-PDS/pds-registry-app/issues/13)

**Defects:**

- Broken link in pds-registry-app docs [\#104](https://github.com/NASA-PDS/pds-registry-app/issues/104)

**Other closed issues:**

- Develop a version 0 API connected to ElasticSearch registry [\#99](https://github.com/NASA-PDS/pds-registry-app/issues/99)
- Research RDF technologies to handle pds4 label cross-references in the registry [\#97](https://github.com/NASA-PDS/pds-registry-app/issues/97)
- Retrofit pds-registry-app CI to use roundup-action [\#94](https://github.com/NASA-PDS/pds-registry-app/issues/94)
- Document performance benchmarks in registry app docs [\#85](https://github.com/NASA-PDS/pds-registry-app/issues/85)
- Develop test plan [\#82](https://github.com/NASA-PDS/pds-registry-app/issues/82)
- Improve Attribute Search Component [\#53](https://github.com/NASA-PDS/pds-registry-app/issues/53)

## [0.2.1](https://github.com/NASA-PDS/pds-registry-app/tree/0.2.1) (2020-10-30)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/0.2.0...0.2.1)

**Other closed issues:**

- Research tech stack modifications due to large number of search fields in registry [\#93](https://github.com/NASA-PDS/pds-registry-app/issues/93)

## [0.2.0](https://github.com/NASA-PDS/pds-registry-app/tree/0.2.0) (2020-10-27)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/0.3.0...0.2.0)

**Other closed issues:**

- Update the release package to integrate the new registry mgr repository [\#98](https://github.com/NASA-PDS/pds-registry-app/issues/98)

## [0.3.0](https://github.com/NASA-PDS/pds-registry-app/tree/0.3.0) (2020-10-27)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/0.1.2...0.3.0)

**Improvements:**

- Have a blob store in Elastic Registry for pds labels [\#44](https://github.com/NASA-PDS/pds-registry-app/issues/44)
- Refactor Registry Manager and Harvest to use ElasticSearch tech stack [\#37](https://github.com/NASA-PDS/pds-registry-app/issues/37)

**Defects:**

- Fix the Json data dictionary format   [\#64](https://github.com/NASA-PDS/pds-registry-app/issues/64)

**Other closed issues:**

- Complete documentation for dynamic schema management [\#95](https://github.com/NASA-PDS/pds-registry-app/issues/95)
- Download large data set for testing [\#84](https://github.com/NASA-PDS/pds-registry-app/issues/84)
- Deploy and install multi-node ES [\#83](https://github.com/NASA-PDS/pds-registry-app/issues/83)
- Update the index schema in ES dynamically when new record are ingested [\#61](https://github.com/NASA-PDS/pds-registry-app/issues/61)
- Validate Elastic Search index configuration for attribute search [\#45](https://github.com/NASA-PDS/pds-registry-app/issues/45)
- Update Registry App documentation per ES refactor [\#43](https://github.com/NASA-PDS/pds-registry-app/issues/43)
- Tag pds-registry-app for last Solr build [\#39](https://github.com/NASA-PDS/pds-registry-app/issues/39)

## [0.1.2](https://github.com/NASA-PDS/pds-registry-app/tree/0.1.2) (2020-08-13)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/v0.1.1...0.1.2)

**Improvements:**

- Complete revised trade study on Solr vs ElasticSearch [\#38](https://github.com/NASA-PDS/pds-registry-app/issues/38)
- Analyse migration cost vs visualization tool benefit if we use elasticSearch/Kibana \(instead of solr/banana\) [\#35](https://github.com/NASA-PDS/pds-registry-app/issues/35)
- Design and document Registry cluster expansion approach [\#30](https://github.com/NASA-PDS/pds-registry-app/issues/30)
- Enhance documentation for PDS4 Attribute Search deployment and customization [\#22](https://github.com/NASA-PDS/pds-registry-app/issues/22)
- Develop ability to deploy Test vs Operations Registry environments [\#15](https://github.com/NASA-PDS/pds-registry-app/issues/15)
- Develop Registry reporting / visualization component [\#11](https://github.com/NASA-PDS/pds-registry-app/issues/11)
- Develop capability for handling multiple product versions [\#10](https://github.com/NASA-PDS/pds-registry-app/issues/10)
- Design and implement Security and Authorization component [\#9](https://github.com/NASA-PDS/pds-registry-app/issues/9)
- Design and implement Multi-Node Deployment capability [\#8](https://github.com/NASA-PDS/pds-registry-app/issues/8)
- Design and Implement capability to handle archive\_status [\#16](https://github.com/NASA-PDS/pds-registry-app/issues/16)

**Other closed issues:**

- Research and document Application Security [\#29](https://github.com/NASA-PDS/pds-registry-app/issues/29)
- Research and document Server Security [\#28](https://github.com/NASA-PDS/pds-registry-app/issues/28)
- Update documentation with different options for sharding and multiple nodes [\#24](https://github.com/NASA-PDS/pds-registry-app/issues/24)

## [v0.1.1](https://github.com/NASA-PDS/pds-registry-app/tree/v0.1.1) (2020-05-22)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/0.1.0...v0.1.1)

**Improvements:**

- Update Schema Generator for handling special cases where ancestor classes are needed [\#20](https://github.com/NASA-PDS/pds-registry-app/issues/20)
- Develop Customization capability for PDS4 Attribute Search [\#7](https://github.com/NASA-PDS/pds-registry-app/issues/7)
- Develop PDS4 Attribute Search capability [\#6](https://github.com/NASA-PDS/pds-registry-app/issues/6)
- update package and documentation after sub-packages updates \(harvest, registry\) [\#1](https://github.com/NASA-PDS/pds-registry-app/issues/1)

**Defects:**

- Unable to build application due to file size limit [\#21](https://github.com/NASA-PDS/pds-registry-app/issues/21)
- registry installation's documentation may be insufficient [\#5](https://github.com/NASA-PDS/pds-registry-app/issues/5)
- pds-app-registry doesn't build on Windows [\#3](https://github.com/NASA-PDS/pds-registry-app/issues/3)
- Harvest does not work with registry manager [\#2](https://github.com/NASA-PDS/pds-registry-app/issues/2)

## [0.1.0](https://github.com/NASA-PDS/pds-registry-app/tree/0.1.0) (2020-03-31)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/nightly...0.1.0)

## [nightly](https://github.com/NASA-PDS/pds-registry-app/tree/nightly) (2020-03-11)

[Full Changelog](https://github.com/NASA-PDS/pds-registry-app/compare/4e42a5bc169a645182bd17f9e5071fd9a1f38dad...nightly)



\* *This Changelog was automatically generated by [github_changelog_generator](https://github.com/github-changelog-generator/github-changelog-generator)*
