#!/bin/sh

echo "Starting initrd boot..."
mkdir /proc
mount -t proc proc /proc

modprobe mtdram total_size=25088 erase_size=256
sleep 1

ID=`grep "mtdram test device" /proc/mtd | cut -d: -f1| cut -b4-`

cat /initrd.jffs2 >/dev/mtdblock$ID

mkdir /mnt
mount -t jffs2 /dev/mtdblock$ID /mnt

cd /mnt
exec switch_root -c /dev/console /mnt /sbin/init
