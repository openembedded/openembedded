#!/bin/sh

mkdir /proc
mount -t proc proc /proc
mkdir /sys
mount -t sysfs sysfs /sys
mkdir -p /dev/pts
mount -t devpts devpts /dev/pts

modprobe g_ether
ifconfig usb0 192.168.2.202

export PATH=$PATH:/usr/sbin

/usr/sbin/dropbear -E

/bin/sh
