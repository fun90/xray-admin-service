#!/bin/bash
work_path=$(dirname $0)
cd ${work_path}

nohup java -server -jar ./xray-api.jar --spring.config.location=./application.yaml > /dev/null 2>&1 &