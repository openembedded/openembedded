SECTION = "kernel"

UNSLUNG_VARIANT = "able"

include unslung-standard-kernel_2.3r25.bb

SRC_URI += "file://usbnet.patch;patch=1 \
	    file://missing-usb-ioctls.patch;patch=1"
