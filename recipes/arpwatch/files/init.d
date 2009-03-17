#!/bin/sh
# /etc/init.d/arpwatch: v9 2004/08/14 KELEMEN Peter <fuji@debian.org>
# Based on /etc/init.d/skeleton (1.8  03-Mar-1998  miquels@cistron.nl)
# 2001/10/26	fuji@debian.org		Support multiple instances.
# 2001/11/24	fuji@debian.org		Use POSIX-style functions.
# 2001/12/17	fuji@debian.org		Use --pidfile on startup, fix restart.
# 2004/08/10	fuji@debian.org		Source /etc/default/arwpatch .
#					Create datafile if it doesn't exist.
#					Run daemon only if executable.

PATH=/sbin:/bin:/usr/sbin:/usr/bin
NAME=arpwatch
DAEMON=/usr/sbin/$NAME
DESC="Ethernet/FDDI station monitor daemon"
DATADIR=/var/lib/$NAME

test -x $DAEMON || exit 0

### You shouldn't touch anything below unless you know what you are doing.

[ -f /etc/default/arpwatch ] && . /etc/default/arpwatch

# Decide whether we have to deal with multiple interfaces.
CONF=/etc/arpwatch.conf
MULTIPLE=0
if [ -r $CONF ]; then
	grep -c '^[a-z]' $CONF 2>&1 >/dev/null && MULTIPLE=1
fi

# Check whether we have to drop privileges.
if [ -n "$RUNAS" ]; then
	if getent passwd "$RUNAS" >/dev/null; then
		ARGS="-u ${RUNAS} $ARGS"
	else
		RUNAS=""
	fi
fi

start_instance () {
	IFACE=$1
	INSTANCE=${NAME}-${IFACE}
	IFACE_OPTS="-i ${IFACE} -f ${IFACE}.dat $2"
	DATAFILE=$DATADIR/${IFACE}.dat

	echo -n "Starting $DESC: "
	if [ ! -f $DATAFILE ]; then
		echo -n "(creating $DATAFILE) "
		:> $DATAFILE
	fi
	if [ -n "$RUNAS" ]; then
		echo -n "(chown $RUNAS $DATAFILE) "
		chown $RUNAS $DATAFILE
	fi
	start-stop-daemon --start --quiet \
		--pidfile /var/run/${INSTANCE}.pid \
		--exec $DAEMON -- $IFACE_OPTS $ARGS
	echo "${INSTANCE}."
	ps h -C $NAME -o pid,args | \
		awk "/$IFACE/ { print \$1 }" > /var/run/${INSTANCE}.pid
}

stop_instance () {
	IFACE=$1
	INSTANCE=${NAME}-${IFACE}
	[ -f /var/run/${INSTANCE}.pid ] || return 0
	echo -n "Stopping $DESC: "
	start-stop-daemon --stop --quiet --oknodo \
		--pidfile /var/run/${INSTANCE}.pid
	echo "${INSTANCE}."
	rm -f /var/run/${INSTANCE}.pid
}

process_loop_break_line () {
	__IFACE=$1
	shift
	__IOPTS="$@"
}

process_loop () {
	OPERATION=$1
	grep '^[a-z]' $CONF 2>/dev/null | \
	while read LINE
	do
		process_loop_break_line $LINE
		I=$__IFACE
		I_OPTS="$__IOPTS"
		$OPERATION $I "$I_OPTS"
	done
}

start_default () {
	echo -n "Starting $DESC: "
	if [ ! -f $DATADIR/arp.dat ]; then
		echo -n "(creating $DATADIR/arp.dat) "
		:> $DATADIR/arp.dat
	fi
	if [ -n "$RUNAS" ]; then
		echo -n "(chown $RUNAS $DATADIR/arp.dat) "
		chown $RUNAS $DATADIR/arp.dat
	fi
	start-stop-daemon --start --quiet \
		--exec $DAEMON -- $ARGS
	echo "$NAME."
}

stop_default () {
	echo -n "Stopping $DESC: "
	start-stop-daemon --stop --quiet --oknodo \
		--exec $DAEMON
	echo "$NAME."
	rm -f /var/run/$NAME.pid
}

startup () {
	if [ "$MULTIPLE" -gt 0 ]; then
  		process_loop start_instance
	else
		start_default
	fi
}

shutdown () {
	if [ "$MULTIPLE" -gt 0 ]; then
		process_loop stop_instance
	else
		stop_default
	fi
}

case "$1" in
  start)
  	startup
	;;
  stop)
  	shutdown
	;;
  reload)
  	echo "Reload operation not supported -- use restart."
	exit 1
	;;
  restart|force-reload)
	#
	#	If the "reload" option is implemented, move the "force-reload"
	#	option to the "reload" entry above. If not, "force-reload" is
	#	just the same as "restart".
	#
	shutdown
	sleep 1
	startup
	;;
  *)
	N=/etc/init.d/$NAME
	# echo "Usage: $N {start|stop|restart|reload|force-reload}" >&2
	echo "Usage: $N {start|stop|restart|force-reload}" >&2
	exit 1
	;;
esac

exit 0
