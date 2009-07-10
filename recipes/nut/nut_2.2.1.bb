DESCRIPTION = "Network UPS Tools"
LICENSE = "GPL"
DEPENDS = "virtual/libusb0"
PR = "r1"

inherit autotools

EXTRA_OECONF = "--with-usb"

SRC_URI = "http://www.networkupstools.org/source/2.2/nut-${PV}.tar.gz \
    file://libm.patch;patch=1 \
    "

FILES_${PN} += "${datadir}/"
