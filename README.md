# pds-registry-app

![🤪 Unstable integration & delivery](https://github.com/NASA-PDS/pds-registry-app/workflows/%F0%9F%A4%AA%20Unstable%20integration%20&%20delivery/badge.svg) ![😌 Stable integration & delivery](https://github.com/NASA-PDS/pds-registry-app/workflows/%F0%9F%98%8C%20Stable%20integration%20&%20delivery/badge.svg)

This application enables a PDS node to register all its data products for long term preservation and sharing with the rest of the PDS system.

It is composed of 2 services:
 - registry manager (the database manager) : for details see https://github.com/NASA-PDS/pds-registry-mgr-elastic
 - harvest (tools to get/prepare metadata for the registry) : for details see https://github.com/NASA-PDS/harvest
 
The purpose of this repository is to integrate together these services and package them conveniently for the users.

## Install

See pds-engineering doc produced by mvn site, to be published

# Update, release


Update the `pom.xml` with the version of the package (e.g. 1.0.0) and versions of services (registry, harvest) validated.

Create a tag and publish it on github:

    git tag 1.0.0
    git push origin --tags
    
Prepare the package:

    mvn compile  ## get the sub-packages
    mvn linkcheck:linkcheck  ## check the link in the maven site and create a report, this requires jdk1.8 to work, later version fail.
    mvn site     ## prepare the documentation
    mvn package  ## generate the package
    mvn github-release:github-release  ## publish the package on github  # TO BE DONE REPLACE WITH CONMAN or GITHUB ACTION

    
# Docker

## Build

### Local git version

```
docker build --build-arg version_reg_app=$(git rev-parse HEAD) \
             --file Dockerfile.local \
             --tag pds_registry_app:$(git rev-parse HEAD) \
             .
```

## Run

### Elastic Search

1. prepare `mkdir /tmp/es`
1. fetch `docker pull elasticsearch:7.10.1`
1. run  
    ```
    docker run --detach \
               --env "discovery.type=single-node" \
               --name es \
               --network pds \
               --publish 9200:9200 \
               --publish 9300:9300 \
               --rm \
               --volume /tmp/es:/usr/share/elasticsearch/data \
               elasticsearch:7.10.1
    ```

### Install test data

```
docker run --network pds --rm pds_registry_app:$(git rev-parse HEAD) \
    registry-manager create-registry -es http://es:9200 \
                                     -schema /var/local/registry/elastic/registry.json 
```

```
docker run --network pds --rm pds_registry_app:$(git rev-parse HEAD) \         harvest -c /var/local/harvest/conf/examples/registry.xml \
                 -o /var/local/harvest/output
```
