#!/bin/sh

case $1 in

'start')
/usr/sbin/sltime
;;

'stop')
/usr/sbin/sltime -set
;;

esac
