#!/bin/sh
PID=`pidof tuxmaild`
if [ $PID ]; then 
	/etc/init.d/tuxmail pause;
fi