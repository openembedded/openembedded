#!/bin/sh
#
# umount /mnt, which is where the initrd ends up mounted
# if the directory /initrd is not present, if this fails
# then the /initrd is mounted and we want to remount that
# ro - this works round the shutdown -r hang problem
umount /mnt 2>/dev/null || {
	# need the device for a remount
	. /etc/default/functions
	ffspart=Flashdisk
	ffsdev="$(mtblockdev $ffspart)"
	if test -n "$ffsdev" -a -b "$ffsdev"
	then
		mount -o remount,ro "$ffsdev" /initrd
	else
		echo "Flashdisk: $ffsdev: flash device not found" >&2
	fi
}
