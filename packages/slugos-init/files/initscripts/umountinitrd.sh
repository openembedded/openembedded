#!/bin/sh
#
# umount /mnt, which is where the initrd ends up mounted
# if the directory /initrd is not present, if this fails
# then the /initrd is mounted and we want to remount that
# ro - this works round the shutdown -r hang problem
. /etc/default/functions
while read device directory remainder
do
	case "$directory" in
	/mnt)	echo "InitRD: unmount initrd on /mnt" >&2
		umount /mnt;;
	/initrd)# need the device for a remount
		ffspart=Flashdisk
		ffsdev="$(mtblockdev $ffspart)"
		echo "InitRD: remount $ffdev read-only on /initrd" >&2
		if test -n "$ffsdev" -a -b "$ffsdev"
		then
			mount -o remount,ro "$ffsdev" /initrd
		else
			echo "Flashdisk: $ffsdev: flash device not found" >&2
		fi;;
	esac
done </proc/mounts
