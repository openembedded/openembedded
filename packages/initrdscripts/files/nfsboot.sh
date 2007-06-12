#!/bin/sh

echo "Starting initramfs boot..."
mkdir /proc
mount -t proc proc /proc
ifconfig eth0 192.168.20.230
mkdir /mnt
mount -t nfs 192.168.20.210:/home/nfs/Angstrom-opie-image-test-h4000 /mnt
cd /mnt
exec switch_root -c /dev/console /mnt /sbin/init
