#!/bin/bash

mvn clean && mvn install  && sudo docker build -t eli/grao-api:0.0.1 . && sudo docker-compose up