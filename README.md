# pds-app-registry

This application enables a PDS node to register all its data products for long term preservation and sharing with the rest of the PDS system.

It is composed of 2 services:
 - registry (the database server) : for details see https://github.com/NASA-PDS-Incubator/harvest
 - harvest (tools to get/prepare metadata for the registry) : for details see https://github.com/NASA-PDS-Incubator/registry
 
The purpose of this repository is to integrate together these services and package them conveniently for the users.

## Install

See pds-engineering doc produced by mvn site, to be published

# Update, release


Update the `pom.xml` with versions of services (registry, harvest) validated.

Create a tag and publish it on github:

    git tag 1.0.0
    git push origin --tags
    
Prepare the package:

    mvn compile  ## get the sub-packages
    mvn site     ## prepare the documentation
    mvn package  ## generate the package
    mvn github-release:github-release  ## publish the package on github

    