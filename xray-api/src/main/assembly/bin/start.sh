#!/bin/bash
work_path=$(dirname $0)
cd ${work_path}
cd ..

echo xray-api is starting

nohup java -server -jar ./xray-api.jar > /dev/null 2>&1 &