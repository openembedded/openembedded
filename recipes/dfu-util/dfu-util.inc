DESCRIPTION = "USB Device Firmware Upgrade utility"
SECTION = "devel"
AUTHOR = "Harald Welte <laforge@openmoko.org>"
LICENSE = "GPL"

DEPENDS = "virtual/libusb0 usbpath"

SRC_URI = "http://dfu-util.gnumonks.org/releases/dfu-util-${PV}.tar.gz"

BBCLASSEXTEND = "native"

inherit autotools
