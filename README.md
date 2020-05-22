# pds-registry-app

![Maven Package](https://github.com/NASA-PDS/pds-registry-app/workflows/Maven%20Package/badge.svg)

This application enables a PDS node to register all its data products for long term preservation and sharing with the rest of the PDS system.

It is composed of 2 services:
 - registry (the database server) : for details see https://github.com/NASA-PDS/harvest
 - harvest (tools to get/prepare metadata for the registry) : for details see https://github.com/NASA-PDS/registry
 
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

    
