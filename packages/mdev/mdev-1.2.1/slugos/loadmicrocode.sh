#!/bin/sh

# Manual firmware loading with firmware_class
# Reason: Because I can (or because mdev doesn't support firmware loading)
# Trigger: Creation of the /dev/ixp4xx_ucode device (this is hacky too, unfortunately)

sleep 1

# Cancel NPE-A microcode upload
echo -1 > /sys/class/firmware/ixp4xx_npe.0/loading

sleep 1

# Test for NPE-B presence

if test -f /lib/firmware/NPE-B; then
    # Upload NPE-B microcode
    echo 1 > /sys/class/firmware/ixp4xx_npe.1/loading
    cat /lib/firmware/NPE-B > /sys/class/firmware/ixp4xx_npe.1/data
    echo 0 > /sys/class/firmware/ixp4xx_npe.1/loading
else
    # Cancel NPE-B microcode upload
    echo -1 > /sys/class/firmware/ixp4xx_npe.1/loading
fi

sleep 1

# Cancel NPE-C microcode upload
echo -1 > /sys/class/firmware/ixp4xx_npe.2/loading
