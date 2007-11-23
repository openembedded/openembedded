#!/bin/sh
# Allow booting from a normal block device.

if [ -e "$ROOT_DEVICE" ]; then
    echo "booting from: $ROOT_DEVICE"
    mount "$ROOT_DEVICE" /mnt
    BOOT_ROOT=/mnt
fi
