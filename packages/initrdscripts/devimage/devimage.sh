#!/bin/sh

mkdir /proc
mount -t proc proc /proc
mkdir /sys
mount -t sysfs sysfs /sys
mkdir -p /dev/pts
mount -t devpts devpts /dev/pts

/usr/sbin/dropbear -E

/bin/sh
