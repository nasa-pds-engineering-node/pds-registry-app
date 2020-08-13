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
    party apps compatible with ES, e.g. Kibana, Graphana. Solr has some,
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

<table style="width:97%;">
<colgroup>
<col style="width: 48%" />
<col style="width: 48%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Solr</strong></th>
<th><strong>Elasticsearch (ES)</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><p><strong>Blob Store API</strong>.</p>
<p>File upload / download. Version management.</p></td>
<td>ES supports binary fields, but we'll have to implement upload / download, version management, md5 hash calculation, etc.</td>
</tr>
<tr class="even">
<td><p><strong>Post Tool.</strong> </p>
<p>Command line tool for uploading various types of content to Solr.</p>
<p>Supported formats: XML, JSON, CSV, PDF, Word, etc.</p></td>
<td>Not available. Have to use bulk API to insert documents. Only JSON format is supported.</td>
</tr>
<tr class="odd">
<td><strong>XML documents</strong> (Harvest solr_doc.xml)</td>
<td>JSON format only.</td>
</tr>
<tr class="even">
<td><strong>Search Protocol</strong> (custom request handlers / plugins)</td>
<td>ES supports REST handler plugins, but unlike very simple Solr API, ES plugin API is very complex and undocumented.</td>
</tr>
<tr class="odd">
<td><strong>Java API</strong> (SolrJ)</td>
<td>Completely different APIs: Transport Client (deprecated), High Level REST Client (recommended).</td>
</tr>
</tbody>
</table>

License
=======

<table style="width:97%;">
<colgroup>
<col style="width: 23%" />
<col style="width: 73%" />
</colgroup>
<thead>
<tr class="header">
<th><strong>Solr</strong></th>
<th><strong>Elasticsearch (ES)</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td><strong>Apache 2.0</strong></td>
<td><p><strong>Apache 2.0</strong>: Basic / Limited features</p>
<p><strong>Commercial</strong>: Security, Monitoring, Elastic App Search (server, GUI, relevance model tuning).</p></td>
</tr>
</tbody>
</table>

Java API
========

<table style="width:96%;">
<colgroup>
<col style="width: 23%" />
<col style="width: 36%" />
<col style="width: 36%" />
</colgroup>
<thead>
<tr class="header">
<th></th>
<th><strong>Solr</strong></th>
<th><strong>Elasticsearch (ES)</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Java Libraries</td>
<td>SolrJ</td>
<td><p>Transport Client - has been used for years, but deprecated in the latest ES version.</p>
<p>High Level REST Client - new recommended API. Similar to Transport Client.</p></td>
</tr>
<tr class="even">
<td>Dependencies</td>
<td>12 jars</td>
<td>40+ jars</td>
</tr>
<tr class="odd">
<td>Documentation</td>
<td>Very limited</td>
<td>Very good.</td>
</tr>
<tr class="even">
<td>Query Builder</td>
<td>No. As a workaround can use Lucene Query Builder.</td>
<td>Yes</td>
</tr>
</tbody>
</table>

Customization / Plugins
=======================

<table style="width:96%;">
<colgroup>
<col style="width: 23%" />
<col style="width: 36%" />
<col style="width: 36%" />
</colgroup>
<thead>
<tr class="header">
<th></th>
<th><strong>Solr</strong></th>
<th><strong>Elasticsearch (ES)</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Summary</td>
<td><p>Very simple plugin API. Simple customization and configuration (few XML files).</p>
<p>Official Solr documentation is bad, but there are few books and online resources describing plugin development.</p>
<p>There are existing PDS plugins.</p></td>
<td><p>Very complex undocumented plugin API.</p>
<p>Plugins have to be rebuild for every new version of ES.</p>
<p>No one on the team has any experience with it.</p></td>
</tr>
<tr class="even">
<td>Customizations</td>
<td><p>Request processing:</p>
<ul class="incremental">
<li><p>Request handlers (search, query parsers)</p></li>
<li><p>Highlighting</p></li>
<li><p>Update Requests </p></li>
<li><p>Query Response writers</p></li>
<li><p>Similarity (scoring)</p></li>
<li><p>Cache Regenerator</p></li>
</ul>
<p>Fields:</p>
<ul class="incremental">
<li><p>Analyzer</p></li>
<li><p>Tokenizer and TokenFilter</p></li>
<li><p>FieldType</p></li>
</ul>
<p>Internals:</p>
<ul class="incremental">
<li><p>SolrCache</p></li>
<li><p>SolrEventListener</p></li>
<li><p>UpdateHandler</p></li>
</ul></td>
<td><ul class="incremental">
<li><p>Custom settings plugin</p></li>
<li><p>REST handler (Action plugin)</p></li>
<li><p>Search plugin (Rescore example)</p></li>
<li><p>Script plugin</p></li>
</ul>
It is very likely that other ES features can be also customized, but no more information is available.</td>
</tr>
</tbody>
</table>

Integrated Solutions
====================

<table style="width:96%;">
<colgroup>
<col style="width: 31%" />
<col style="width: 31%" />
<col style="width: 31%" />
</colgroup>
<thead>
<tr class="header">
<th></th>
<th><strong>Solr</strong></th>
<th><strong>Elasticsearch (ES)</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Big Data, Data Science</td>
<td><p><strong>Cloudera + H ortonworks</strong> (Merged in 2019)</p>
<p>Multiple products, commercial and open source. Big Data, Data Science, including Solr, Spark, Hadoop, HBase, Pig, Hive, Kafka, etc.</p>
<p><strong>Datastax</strong> (Solr + Cassandra database) </p></td>
<td><p><strong>Science Data Analytics Platform (SDAP)</strong> - Apache Incubator</p>
<p>SDAP has been developed collaboratively between NASA JPL, FSU, NCAR, and GMU</p></td>
</tr>
<tr class="even">
<td>DevOps (logs, metrics, visualization)</td>
<td>There are no integrated solutions, but Prometheus and Grafana plugins are available.</td>
<td><strong>ELK</strong> - Elasticsearch, Logstash, Kibana.</td>
</tr>
<tr class="odd">
<td>Semantic Web (search), Linked Data</td>
<td>Not available?</td>
<td><p><strong>Science Data Analytics Platform (SDAP)</strong></p>
<p><strong>Apache Jena</strong> - full text search in SPARQL</p></td>
</tr>
</tbody>
</table>

Metrics and Monitoring
======================

| **Solr**                                                                             | **Elasticsearch (ES)**               |
|:-------------------------------------------------------------------------------------|:-------------------------------------|
| Multiple metrics, registries and reporters. Integration with Prometheus and Grafana. | Requires X-Pack, Commercial license? |

Support by Cloud Providers
==========================

<table style="width:96%;">
<colgroup>
<col style="width: 31%" />
<col style="width: 31%" />
<col style="width: 31%" />
</colgroup>
<thead>
<tr class="header">
<th></th>
<th><strong>Solr</strong></th>
<th><strong>Elasticsearch (ES)</strong></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Amazon AWS</td>
<td><ul class="incremental">
<li><p>AMI (Amazon Machine Image - VM)</p></li>
<li><p>Amazon EKS (Kubernetes container)</p></li>
</ul></td>
<td><p>ELK (Elasticsearch, Logstash, Kibana):</p>
<ul class="incremental">
<li><p>SaaS (Managed service)</p></li>
<li><p>AMI (VM)</p></li>
<li><p>Amazon EKS</p></li>
</ul></td>
</tr>
<tr class="even">
<td>Google Cloud Platform (GCP)</td>
<td><ul class="incremental">
<li><p>SaaS (SearchStax)</p></li>
<li><p>VM</p></li>
</ul></td>
<td><ul class="incremental">
<li><p>SaaS</p></li>
<li><p>VM</p></li>
</ul></td>
</tr>
</tbody>
</table>
