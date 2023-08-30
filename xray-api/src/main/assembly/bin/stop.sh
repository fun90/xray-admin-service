#!/bin/bash

PID=$(ps -ef | grep '\-jar ./xray\-api.jar' | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
echo xray-api is already stopped
else
echo kill -9 $PID
kill -9 $PID
fi
