#!/bin/bash
work_path=$(dirname $0)
cd ${work_path}
cd ..

nohup java -server -jar ./xray-api.jar > /dev/null 2>&1 &