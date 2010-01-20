#!/bin/sh                                

# Mount proc
mount -t proc proc /proc -o rw,noexec,nosuid,nodev
# Mount sys
mount -t sysfs sys /sys -o rw,noexec,nosuid,nodev

# Mount root rw
mount / -o remount,rw

# Prep modules
depmod -A

# Populate /dev
/etc/init.d/udev start

# Mount everything
# mount -a

# Setup a proper /tmp using tmpfs
cat /proc/mounts | grep -q "\s/tmp\s"
[ "x$?" != "x0" ] && mount -t tmpfs tmpfs /tmp

cat /proc/mounts | grep -q "\s/dev/pts\s"
[ "x$?" != "x0" ] && mount -t devpts devpts /dev/pts

# Set the hostname
hostname -F /etc/hostname

# USB gadget configuration
if [ -e /sys/class/usb_gadget/config_num ]; then
	echo 5 > /sys/class/usb_gadget/config_num
fi

# USB network configuration
ifup -f usb0
ifconfig usb0 192.168.0.202

# Dropbear ssh service
/etc/init.d/dropbear start

# Spin relaunching login
while true; do getty 115200 console; done
