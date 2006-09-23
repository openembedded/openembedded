#!/bin/sh

# This script is used for loading modules required for networking

# A way of finding which embedded board SlugOS is being run on is needed 

echo "Loading networking modules"

modprobe af_packet #Required for DHCP

modprobe ixp4xx_npe
sleep 1 #Allow Firmware Load

#Conditional required: Not all IXP4xx boards use onboard MAC
modprobe ixp4xx_mac

exit 0