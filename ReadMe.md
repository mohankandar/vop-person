# What is this repository for?

This repository serves as the root reactor project for the VOP Person Service. It aggregates the modules necessary to
build and run the VOP Person Service, which adheres to various service patterns defined by the VOP Platform. The reactor
POM manages dependencies, configurations, and other shared resources across the included modules.

For detailed information regarding recommended development patterns for service applications and the purpose and usage
of capabilities provided by the VOP Framework, see the [vop-person README.md].

For information on framework release notes, -- TODO

# Prerequisites

The vop-person-reactor requires JDK 8 or higher and Maven 3.6 or higher.

# Project Breakdown & Links

1. [vop-person-reactor](link): This is the root reactor project (you are in that repo now). It aggregates the modules
   that comprise the VOP Person Service.

2. [vop-person](vop-person/README.md): The primary module within this reactor, responsible for the actual implementation
   and configuration of the VOP Person Service.

# How to include VOP Person Service in your project

See the [vop-person README].
