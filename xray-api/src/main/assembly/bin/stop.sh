PID=$(ps -ef | grep xray-api | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
echo xray-api is already stopped
else
echo kill -9 $PID
kill -9 $PID
fi
