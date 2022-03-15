============================
Load Data (Scalable Harvest)
============================

Overview
********

To load PDS4 data into Registry you have to use Harvest software. There are two versions of Harvest:
a simple standalone command-line tool and a scalable Harvest consisting of several server and and
client components. Scalable Harvest can process big data sets in parallel. 
Both versions extract metadata from PDS4 products (labels) and load extracted
metadata into Elasticsearch database. 

This document describes how to use Harvest Client command-line tool to submit jobs to Scalable Harvest Server cluster.


Prerequisites
*************

* Elasticsearch server is running.
* Registry indices are created in Elasticsearch.
* All server components - RabbitMQ, Crawler Server, Harvest Server - are deployed and running on-prem or in the cloud.
* Harvest Client command-line tool is installed.


Scalable Harvest Quick Start
****************************

Scalable Harvest consists of several server components: RabbitMQ, Crawler and Harvest servers.
To load data you have to use Harvest Client command-line tool to submit a job to Harvest server cluster.

Configuration File
==================

Harvest Client requires message broker (RabbitMQ) connection to submit jobs to the Harvest server cluster.
Default configuration file, *<INSTALL_DIR>/conf/harvest-client.cfg*, has the following parameters:

.. code-block:: python

   # Message server type. Currently, only 'RabbitMQ' is supported.
   mq.type = RabbitMQ

   # RabbitMQ host(s). One or more host:port tuples (one tuple per line).
   # rmq.host = host1:5672
   # rmq.host = host2:5672
   # rmq.host = host3:5672

   rmq.host = localhost:5672

   # RabbitMQ user
   rmq.user = harvest

   # RabbitMQ password
   rmq.password = harvest

You can either edit default configuration file, or create another file and pass it to Harvest Client CLI as a parameter.


Submit a Job
============

