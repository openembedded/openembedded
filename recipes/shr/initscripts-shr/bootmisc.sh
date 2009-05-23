#
# bootmisc.sh	Miscellaneous things to be done during bootup.
#

. /etc/default/rcS
#
# Put a nologin file in /etc to prevent people from logging in before
# system startup is complete.
#
if test "$DELAYLOGIN" = yes
then
  echo "System bootup in progress - please wait" > /etc/nologin
  cp /etc/nologin /etc/nologin.boot
fi

#
# Update /etc/motd.
#
if test "$EDITMOTD" != no
then
	uname -a > /etc/motd.tmp
	sed 1d /etc/motd >> /etc/motd.tmp
	mv /etc/motd.tmp /etc/motd
fi

#
# Update dynamic library cache
#
#/sbin/ldconfig

# Set the system clock from hardware clock
# If the timestamp is 1 day or more recent than the current time,
# use the timestamp instead.
[ "$UTC" = yes ] || /etc/init.d/hwclock.sh start

if ! test -f /etc/.configured && test -e /etc/timestamp
then
	SYSTEMDATE=`date "+%Y%m%d"`
	TIMESTAMP=`cat /etc/timestamp | awk '{ print substr($0,9,4) substr($0,1,4);}'`
        NEEDUPDATE=`expr \( $TIMESTAMP \> $SYSTEMDATE \)`                                                 
        if [ $NEEDUPDATE -eq 1 ]; then 
		date `cat /etc/timestamp`
		/etc/init.d/hwclock.sh stop
	fi
fi

: exit 0
