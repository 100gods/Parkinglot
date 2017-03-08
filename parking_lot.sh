#!/bin/bash
mvn clean install 
java -jar ./target/Parkinglot-0.0.1-SNAPSHOT.jar $1