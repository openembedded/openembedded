#!/bin/sh

/sbin/devio ">>/dev/mtdblock5" "fb#255" 2>/dev/null
/usr/sbin/DO_Reboot 2>/dev/null
