#
# checkroot.sh	Check to root filesystem.
#
# Version:	@(#)checkroot.sh  2.84  25-Jan-2002  miquels@cistron.nl
#

. /etc/default/rcS

#
# Set SULOGIN in /etc/default/rcS to yes if you want a sulogin to be spawned
# from this script *before anything else* with a timeout, like SCO does.
#
test "$SULOGIN" = yes && sulogin -t 30 $CONSOLE

#
#	If the root filesystem was not marked as read-only in /etc/fstab,
#	remount the rootfs rw but do not try to change mtab because it
#	is on a ro fs until the remount succeeded. Then clean up old mtabs
#	and finally write the new mtab.
#	This part is only needed if the rootfs was mounted ro.
#
ROOTFSDEV="/dev/root"
if grep -q "^$ROOTFSDEV .* rw" /proc/mounts; then
	echo "Root filesystem already read-write, not remounting"
else
	rootmode=rw

	echo "Remounting root file system..."
	mount -n -o remount,noatime,$rootmode /
	if test "$rootmode" = rw
	then
		if test ! -L /etc/mtab
		then
			rm -f /etc/mtab~ /etc/nologin
			: > /etc/mtab
		fi
		mount -f -o remount /
		mount -f /proc
		test "$devfs" && grep -q '^devfs /dev' /proc/mounts && mount -f "$devfs"
	fi
fi

: exit 0
