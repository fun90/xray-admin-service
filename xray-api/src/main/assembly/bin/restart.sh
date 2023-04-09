#!/bin/bash

PID=$(ps -ef | grep xray-api | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
echo xray-api is already stopped
else
echo xray-api is stoping, kill -9 $PID
kill -9 $PID
fi

echo xray-api is starting

work_path=$(dirname $0)
cd ${work_path}
cd ..
nohup java -server -jar ./xray-api.jar > /dev/null 2>&1 &