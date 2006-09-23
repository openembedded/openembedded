#!/bin/sh

# This script is used for loading modules required for other purposes than
# usb or networking

# A way of finding which embedded board SlugOS is being run on is needed 

echo "Loading misc modules"
modprobe ixp4xx_rng
modprobe i2c_dev

exit 0