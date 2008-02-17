#!/bin/sh
# Allow booting from a normal block device.

if [ -e "$ROOT_DEVICE" ]; then
    echo "booting from: $ROOT_DEVICE"
    type=""
    if [ -n "$FSTYPE" ]; then
	type="-t $FSTYPE"
    fi
    mount $type "$ROOT_DEVICE" /mnt || fatal "Unable to mount rootfs device"
    BOOT_ROOT=/mnt
fi
