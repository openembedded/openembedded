#! /bin/sh
#
# umountnfs.sh	Unmount all network filesystems.
#

PATH=/sbin:/bin:/usr/sbin:/usr/bin

echo "Unmounting remote filesystems..."

test -f /etc/fstab && (

#
#	Read through fstab line by line and unount network file systems
#
while read device mountpt fstype options
do
	if test "$fstype" = nfs ||  test "$fstype" = smbfs ||  test "$fstype" = ncpfs || test "$fstype" = cifs
	then
		umount -f $mountpt
	fi
done
) < /etc/fstab

echo "Unmounting other remote filesystems..."

#
# Read the list of mounted file systems and -f umount the
# known network file systems.  -f says umount it even if
# the server is unreachable.  Do not attempt to umount
# the root file system.  Unmount in reverse order from
# that given by /proc/mounts (otherwise it may not work).
#
unmount() {
	local dev mp type opts
	if read dev mp type opts
	then
		# recurse - unmount later items
		unmount
		# skip /, /proc and /dev
		case "$mp" in
		/|/proc)return 0;;
		/dev)	return 0;;
		esac
		# then unmount this, if nfs
		case "$type" in
		nfs|smbfs|ncpfs|cifs) umount -f "$mp";;
		esac
	fi
}

unmount </proc/mounts

: exit 0

