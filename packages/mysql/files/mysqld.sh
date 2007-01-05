# MySQL init script

. /etc/default/rcS

case "$1" in
	start)
		/usr/bin/mysqld_safe &
		;;
	stop)
		if test -f /var/run/mysqld.pid ; then
			PID=`cat /var/run/mysqld.pid`
			kill $PID
		fi
		;;
	*)
		echo "Usage: /etc/init.d/mysqld {start|stop}"
		;;
esac

exit 0
