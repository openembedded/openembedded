UNSLUNG_VARIANT = "able"

include unslung-standard-ramdisk_2.3r25.bb

# Add overlays and patches to the standard ramdisk here
SRC_URI += "file://mount_usbdevfs.patch;patch=1"

