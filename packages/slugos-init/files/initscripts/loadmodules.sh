#!/bin/sh

# This script is used for loading modules required by SlugOS
# Currently, this script only supports the NSLU2

. /etc/default/functions # Load $(machine) function required

echo "Starting Network Processing Engines"
modprobe ixp4xx_npe
sleep 1 # Wait for firmware load

echo "Loading networking modules"

modprobe af_packet # Required for DHCP

# Add nas100d/loft below when mac definition is added to kernel
case "$(machine)" in
    ixdp425|nslu2)
        modprobe ixp4xx_mac
        ;;
esac

# Add conditional DSM-G600 ethernet module load

echo "Loading usb storage modules"
modprobe scsi_mod
modprobe sd_mod
modprobe usbcore

# Add more entries as appropriate
case "$(machine)" in
    nslu2)
        modprobe ohci_hcd
        modprobe ehci_hcd
        ;;
esac

modprobe usb_storage

echo "Loading other modules"
modprobe ixp4xx_rng
modprobe i2c_dev

exit 0
