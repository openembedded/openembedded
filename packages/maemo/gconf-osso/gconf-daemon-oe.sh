#!/bin/sh
# GConf daemon startup/shutdown script

PROG=/usr/libexec/gconfd-2
SVC="GConf daemon"

case "$1" in
start)  START=TRUE
        ;;
stop)   START=FALSE
        ;;
*)      echo "Usage: $0 {start|stop}"
	exit 1
        ;;
esac

if [ $START = TRUE ]; then
  $LAUNCHWRAPPER start "$SVC" $PROG
else
  $LAUNCHWRAPPER stop"$SVC" $PROG
fi
