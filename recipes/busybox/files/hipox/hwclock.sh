#!/bin/sh
# hwclock.sh Set system clock to hardware clock, according to the UTC
#               setting in /etc/default/rcS (see also rcS(5)).
#               (hipox machine version)
#
# WARNING:      If your hardware clock is not in UTC/GMT, this script
#               must know the local time zone. This information is
#               stored in /etc/localtime. This might be a problem if
#               your /etc/localtime is a symlink to something in
#               /usr/share/zoneinfo AND /usr isn't in the root
#               partition! The workaround is to define TZ either
#               in /etc/default/rcS, or in the proper place below.

[ ! -x /sbin/hwclock ] && exit 0

. /etc/default/rcS

[ "$UTC" = yes ] && UTC=--utc || UTC=--localtime

case "$1" in
        start)
                if [ "$VERBOSE" != no ]
                then
                        echo "System time was `date`."
                        echo "Setting the System Clock using the Hardware Clock as reference..."
                fi

		if [ "$HWCLOCKACCESS" != no ]
		then
			if [ -z "$TZ" ]
			then
	                   hwclock -s $UTC;# --hctosys
			else
			   TZ="$TZ" hwclock -s $UTC;# --hctosys
			fi
		fi

                if [ "$VERBOSE" != no ]
                then
                        echo "System Clock set. System local time is now `date`."
                fi
                ;;
        stop|restart|reload|force-reload)
		#
		# At hipox machine we do not update the Hardware Clock
		# with the System Clock time to avoid needless increase
		# of the RTC epoch counter.
		#
                exit 0
                ;;
	show)
		if [ "$HWCLOCKACCESS" != no ]
		then
			hwclock -r $UTC;# --show
		fi
		;;
        *)
                echo "Usage: hwclock.sh {start|stop|show|reload|restart}" >&2
		echo "       start sets kernel (system) clock from hardware (RTC) clock" >&2
		echo "       stop and reload set hardware (RTC) clock from kernel (system) clock" >&2
                exit 1
                ;;
esac
