# What is this repository for?

This repository contains the implementation of the VOP Person Service, which is a part of the VOP Platform. The service is designed to manage person-related data and operations, adhering to the service patterns defined by the VOP Platform. The repository includes all necessary dependencies, plugins, and configurations required to build, test, and deploy the VOP Person Service.

For detailed information regarding development patterns, usage, and capabilities provided by the VOP Person Service, refer to the [vop-person README.md].

For information on framework release notes, -- TODO

# Prerequisites

The `vop-person` requires JDK 8 or higher and Maven 3.6 or higher.

# Project Breakdown & Links

1. **vop-person-reactor**: The root reactor project that aggregates the modules necessary for the VOP Person Service.
2. **vop-person**: The main module for the VOP Person Service, including service implementation and configurations.

# Dependencies

This module includes several dependencies to support various functionalities:

- **vop-framework-libraries**: Common libraries provided by the VOP framework.
- **vop-framework-autoconfigure**: Auto-configuration utilities for the VOP framework.
- **Spring Boot Starters**: Various Spring Boot starters like `spring-boot-starter-tomcat`, `spring-boot-starter-aop`, etc., for essential functionalities.
- **Spring Cloud**: Dependencies like `spring-cloud-starter-bootstrap` and `spring-cloud-starter-sleuth` for cloud configuration and distributed tracing.
- **Jackson**: For JSON processing in JAX-RS services.
- **Logstash Logback Encoder**: For formatting log messages in Logstash format.
- **JUnit & Spring Boot Test**: For testing the application, including JUnit 4 and 5 compatibility and JSON-based assertions.

# Build & Test Plugins

The project uses various Maven plugins to manage the build lifecycle, including:

- **Templating Maven Plugin**: For processing and filtering template files.
- **Build Helper Maven Plugin**: To add generated sources to the build process.
- **Sonar Maven Plugin**: For code quality analysis using SonarQube.

# Maven Profiles

- **inttest**: For integration testing, including running Cucumber tests.
- **org-openapitools-codegen-person**: To generate code from OpenAPI specifications.
- **perftest**: For running performance tests using JMeter.
- **sonar**: For running SonarQube analysis on the project.

# How to include VOP Person Service in your project

See the [vop-person README].
