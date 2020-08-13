Elasticsearch vs Solr
=====================

Executive Summary
=================

***Revised 08/2020***

**Selection: ElasticSearch**

**Rationale:**

*Overall, both Solr and Elasticsearch provide similar search
functionality, however, there are some significant benefits to ES that
prove it the champion:*

-   ***Third party apps** - There are significantly more robust third
    party apps compatible with ES, e.g. Kibana, Graphana. Solr has some,
    but they are not maintained very well and most have some issues.*

-   ***AWS Support** - Spinning of ES in AWS is trivial and will save
    significant resources in the long run. Per discussions with IMG,
    trying to do the same with Solr is much more difficult and time
    consuming.*

-   ***Documentation** - Documentation is significantly more detailed
    and robust for ES vs Solr. Will not only improve development, but
    will also simplify custom documentation needed.*

-   ***Overall quality of the product** - ES is just overall a better
    software product. Between the documentation and comprehensive suite
    of tools and services, it is really worth the cost to refactor EN
    software to use ES.*

Solr features used by PDS Registry and Harvest not available in Elasticsearch
=============================================================================

+----------------------------------+----------------------------------+
| **Solr**                         | **Elasticsearch (ES)**           |
+==================================+==================================+
| **Blob Store API**.              | ES supports binary fields, but   |
|                                  | we\'ll have to implement upload  |
| File upload / download. Version  | / download, version management,  |
| management.                      | md5 hash calculation, etc.       |
+----------------------------------+----------------------------------+
| **Post Tool.**                   | Not available. Have to use bulk  |
|                                  | API to insert documents. Only    |
| Command line tool for uploading  | JSON format is supported.        |
| various types of content to      |                                  |
| Solr.                            |                                  |
|                                  |                                  |
| Supported formats: XML, JSON,    |                                  |
| CSV, PDF, Word, etc.             |                                  |
+----------------------------------+----------------------------------+
| **XML documents** (Harvest       | JSON format only.                |
| solr_doc.xml)                    |                                  |
+----------------------------------+----------------------------------+
| **Search Protocol** (custom      | ES supports REST handler         |
| request handlers / plugins)      | plugins, but unlike very simple  |
|                                  | Solr API, ES plugin API is very  |
|                                  | complex and undocumented.        |
+----------------------------------+----------------------------------+
| **Java API** (SolrJ)             | Completely different APIs:       |
|                                  | Transport Client (deprecated),   |
|                                  | High Level REST Client           |
|                                  | (recommended).                   |
+----------------------------------+----------------------------------+

License
=======

+----------------+----------------------------------------------------+
| **Solr**       | **Elasticsearch (ES)**                             |
+================+====================================================+
| **Apache 2.0** | **Apache 2.0**: Basic / Limited features           |
|                |                                                    |
|                | **Commercial**: Security, Monitoring, Elastic App  |
|                | Search (server, GUI, relevance model tuning).      |
+----------------+----------------------------------------------------+

Java API
========

+----------------+-------------------------+-------------------------+
|                | **Solr**                | **Elasticsearch (ES)**  |
+================+=========================+=========================+
| Java Libraries | SolrJ                   | Transport Client - has  |
|                |                         | been used for years,    |
|                |                         | but deprecated in the   |
|                |                         | latest ES version.      |
|                |                         |                         |
|                |                         | High Level REST Client  |
|                |                         | - new recommended API.  |
|                |                         | Similar to Transport    |
|                |                         | Client.                 |
+----------------+-------------------------+-------------------------+
| Dependencies   | 12 jars                 | 40+ jars                |
+----------------+-------------------------+-------------------------+
| Documentation  | Very limited            | Very good.              |
+----------------+-------------------------+-------------------------+
| Query Builder  | No. As a workaround can | Yes                     |
|                | use Lucene Query        |                         |
|                | Builder.                |                         |
+----------------+-------------------------+-------------------------+

Customization / Plugins
=======================

+----------------+-------------------------+-------------------------+
|                | **Solr**                | **Elasticsearch (ES)**  |
+================+=========================+=========================+
| Summary        | Very simple plugin API. | Very complex            |
|                | Simple customization    | undocumented plugin     |
|                | and configuration (few  | API.                    |
|                | XML files).             |                         |
|                |                         | Plugins have to be      |
|                | Official Solr           | rebuild for every new   |
|                | documentation is bad,   | version of ES.          |
|                | but there are few books |                         |
|                | and online resources    | No one on the team has  |
|                | describing plugin       | any experience with it. |
|                | development.            |                         |
|                |                         |                         |
|                | There are existing PDS  |                         |
|                | plugins.                |                         |
+----------------+-------------------------+-------------------------+
| Customizations | Request processing:     | -   Custom settings     |
|                |                         |     plugin              |
|                | -   Request handlers    |                         |
|                |     (search, query      | -   REST handler        |
|                |     parsers)            |     (Action plugin)     |
|                |                         |                         |
|                | -   Highlighting        | -   Search plugin       |
|                |                         |     (Rescore example)   |
|                | -   Update Requests     |                         |
|                |                         | -   Script plugin       |
|                | -   Query Response      |                         |
|                |     writers             | It is very likely that  |
|                |                         | other ES features can   |
|                | -   Similarity          | be also customized, but |
|                |     (scoring)           | no more information is  |
|                |                         | available.              |
|                | -   Cache Regenerator   |                         |
|                |                         |                         |
|                | Fields:                 |                         |
|                |                         |                         |
|                | -   Analyzer            |                         |
|                |                         |                         |
|                | -   Tokenizer and       |                         |
|                |     TokenFilter         |                         |
|                |                         |                         |
|                | -   FieldType           |                         |
|                |                         |                         |
|                | Internals:              |                         |
|                |                         |                         |
|                | -   SolrCache           |                         |
|                |                         |                         |
|                | -   SolrEventListener   |                         |
|                |                         |                         |
|                | -   UpdateHandler       |                         |
+----------------+-------------------------+-------------------------+

Integrated Solutions
====================

+----------------------+----------------------+----------------------+
|                      | **Solr**             | **Elasticsearch      |
|                      |                      | (ES)**               |
+======================+======================+======================+
| Big Data, Data       | **Cloudera +         | **Science Data       |
| Science              | H                    | Analytics Platform   |
|                      | ortonworks** (Merged | (SDAP)** - Apache    |
|                      | in 2019)             | Incubator            |
|                      |                      |                      |
|                      | Multiple products,   | SDAP has been        |
|                      | commercial and open  | developed            |
|                      | source. Big Data,    | collaboratively      |
|                      | Data Science,        | between NASA JPL,    |
|                      | including Solr,      | FSU, NCAR, and GMU   |
|                      | Spark, Hadoop,       |                      |
|                      | HBase, Pig, Hive,    |                      |
|                      | Kafka, etc.          |                      |
|                      |                      |                      |
|                      | **Datastax** (Solr + |                      |
|                      | Cassandra database)  |                      |
+----------------------+----------------------+----------------------+
| DevOps (logs,        | There are no         | **ELK** -            |
| metrics,             | integrated           | Elasticsearch,       |
| visualization)       | solutions, but       | Logstash, Kibana.    |
|                      | Prometheus and       |                      |
|                      | Grafana plugins are  |                      |
|                      | available.           |                      |
+----------------------+----------------------+----------------------+
| Semantic Web         | Not available?       | **Science Data       |
| (search), Linked     |                      | Analytics Platform   |
| Data                 |                      | (SDAP)**             |
|                      |                      |                      |
|                      |                      | **Apache Jena** -    |
|                      |                      | full text search     |
|                      |                      | in SPARQL            |
+----------------------+----------------------+----------------------+

Metrics and Monitoring
======================

  **Solr**                                                                               **Elasticsearch (ES)**
  -------------------------------------------------------------------------------------- --------------------------------------
  Multiple metrics, registries and reporters. Integration with Prometheus and Grafana.   Requires X-Pack, Commercial license?

Support by Cloud Providers
==========================

+----------------------+----------------------+----------------------+
|                      | **Solr**             | **Elasticsearch      |
|                      |                      | (ES)**               |
+======================+======================+======================+
| Amazon AWS           | -   AMI (Amazon      | ELK (Elasticsearch,  |
|                      |     Machine Image -  | Logstash, Kibana):   |
|                      |     VM)              |                      |
|                      |                      | -   SaaS (Managed    |
|                      | -   Amazon EKS       |     service)         |
|                      |     (Kubernetes      |                      |
|                      |     container)       | -   AMI (VM)         |
|                      |                      |                      |
|                      |                      | -   Amazon EKS       |
+----------------------+----------------------+----------------------+
| Google Cloud         | -   SaaS             | -   SaaS             |
| Platform (GCP)       |     (SearchStax)     |                      |
|                      |                      | -   VM               |
|                      | -   VM               |                      |
+----------------------+----------------------+----------------------+
