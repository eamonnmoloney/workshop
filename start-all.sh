#!/usr/bin/env bash

cd engine && ./gradlew docker
cd ../customer-service && ./gradlew docker
cd ../advisor-service && ./gradlew docker
cd ../holding-service && ./gradlew docker
cd ../print-service && ./gradlew docker
cd ..
docker-compose up