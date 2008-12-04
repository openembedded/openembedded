#!/bin/sh
#
# start/stop ushare

if ! [ -x /usr/bin/ushare ]; then
	exit 0
fi

CONFIGFILE=/etc/ushare.conf
if [ -r "$CONFIGFILE" ]; then
	. $CONFIGFILE
fi

case "$1" in
	start)
		echo -n "Starting ushare: "
		start-stop-daemon -S -x /usr/bin/ushare -- -D -n `/bin/hostname` $USHARE_OPTIONS -f $CONFIGFILE
		echo "done."
		;;
	stop)
		echo -n "Stopping ushare: "
		start-stop-daemon -K -x /usr/bin/ushare
		echo "done."
		;;
	restart|reload)
		$0 stop
		$0 start
		;;
	*)
		echo "Usage: $0 {start|stop|restart}"
		exit 1
		;;
esac

exit 0

