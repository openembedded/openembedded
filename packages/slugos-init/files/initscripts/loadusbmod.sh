#!/bin/sh

# This script is used for loading modules required for usb storage devices
# As this script is run very early in the boot process, insmod is used

echo "Loading usb storage modules"
insmod /lib/modules/2.6.18/kernel/drivers/scsi/scsi_mod.ko
insmod /lib/modules/2.6.18/kernel/drivers/usb/core/usbcore.ko
#Conditional required: NSLU2 has ohci/ehci but others have uhci/ehci
insmod /lib/modules/2.6.18/kernel/drivers/usb/host/ohci-hcd.ko
insmod /lib/modules/2.6.18/kernel/drivers/usb/host/ehci-hcd.ko
insmod /lib/modules/2.6.18/kernel/drivers/usb/storage/usb-storage.ko

echo "Loading ext2/3 support"
insmod /lib/modules/2.6.18/kernel/fs/mbcache.ko
insmod /lib/modules/2.6.18/kernel/fs/jbd/jbd.ko
insmod /lib/modules/2.6.18/kernel/fs/ext2/ext2.ko
insmod /lib/modules/2.6.18/kernel/fs/ext3/ext3.ko

exit 0