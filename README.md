# This is a sandbox project for implementing different scenarios in Java
# 
# At this moment, it is:
# * a spring boot app
# * that connects to a running H2 service, creates a Person table described by domain model object and inserts some data
# * pessimistically locks the Person table and tries concurrent updates to it
#
# Future:
# * add H2 configuration (Dockerfile)
# * add docker-compose so that it all starts together with one command
# * tests?
