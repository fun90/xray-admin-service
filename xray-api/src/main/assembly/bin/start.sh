#!/bin/bash
work_path=$(dirname $0)
cd ${work_path}
cd ..

nohup java -jar ./xray-api.jar > /dev/null 2>&1 &