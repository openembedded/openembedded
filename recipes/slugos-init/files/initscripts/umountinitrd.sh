#!/bin/sh
#
# umount /mnt, which is where the initrd ends up mounted
# if the directory /initrd is not present, if this fails
# then the /initrd is mounted and we want to remount that
# ro - this works round the shutdown -r hang problem
. /etc/default/functions

case "$(machine)" in
nslu2)
	ffspart="Flashdisk";;
*)
	ffspart="filesystem";;
esac

while read device directory remainder
do
	case "$directory" in
	/mnt)	echo "InitRD: unmount initrd on /mnt" >&2
		umount /mnt;;
	/initrd)# need the device for a remount
		ffsdev="$(mtblockdev $ffspart)"
		[ -n "$ffsdev" ] || \
		ffsdev="$(mtblockdev rootfs)"
		echo "Remounting $ffsdev read-only on /initrd" >&2
		if test -n "$ffsdev" -a -b "$ffsdev"
		then
			mount -o remount,ro "$ffsdev" /initrd
		else
			echo "$ffspart: $ffsdev: flash device not found" >&2
		fi;;
	esac
done </proc/mounts
