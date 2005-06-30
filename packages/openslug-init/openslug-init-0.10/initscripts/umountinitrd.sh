#!/bin/sh
#
# umount /mnt, which is where the initrd ends up mounted
# if the directory /initrd is not present
exec umount /mnt 2>/dev/null
