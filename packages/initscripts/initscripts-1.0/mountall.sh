#
# mountall.sh	Mount all filesystems.
#
# Version:	@(#)mountall.sh  2.83-2  01-Nov-2001  miquels@cistron.nl
#
. /etc/default/rcS
if test -f /etc/default/mountall; then
    . /etc/default/mountall
fi

#
# Mount local filesystems in /etc/fstab. For some reason, people
# might want to mount "proc" several times, and mount -v complains
# about this. So we mount "proc" filesystems without -v.
#
test "$VERBOSE" != no && echo "Mounting local filesystems..."
mount -a $MOUNTALL 2>&1 | logger -s -p user.err

#
# We might have mounted something over /dev, see if /dev/initctl is there.
#
if test ! -p /dev/initctl
then
	rm -f /dev/initctl
	mknod -m 600 /dev/initctl p
fi
kill -USR1 1

#
# Execute swapon command again, in case we want to swap to
# a file on a now mounted filesystem.
#
doswap=yes
case "`uname -r`" in
	2.[0123].*)
		if grep -qs resync /proc/mdstat
		then
			doswap=no
		fi
		;;
esac
if test $doswap = yes
then
	swapon -a 2> /dev/null
fi

# A missing homedirectory for root can cause all sorts of problems.
# This can happen after user formats his /home partition for example

if test -e /etc/passwd
then
	ROOT_HOME="`cat /etc/passwd|grep ^root | awk '{split($0,x,":");printf("%s\n",x[6])}'`"
	
	if test -n "$ROOT_HOME"
	then
		! test -d "$ROOT_HOME" && mkdir -p "$ROOT_HOME"
	fi
fi
: exit 0

