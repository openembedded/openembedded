#!/bin/sh

usage()
{
	echo "Usage: $0 {start|stop|status|restart|reload}"
}

if [ $# -lt 1 ] ; then usage ; break ; fi
action=$1

case "$action" in

start)
	echo -n "Start Dreamcrypt cam daemon:"
	/usr/bin/wdog /usr/bin/dccamd -
	echo " dccamd."
		;;

stop)
	echo -n "Stopping Dreamcrypt cam daemon: dccamd"
	killall wdog dccamd
	echo "."
	;;

status)
	;;

restart|reload)
	$0 stop
	$0 start
	;;

*)
	usage
	;;

esac

exit 0
