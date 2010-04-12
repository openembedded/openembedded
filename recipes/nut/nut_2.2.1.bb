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

SRC_URI[md5sum] = "c7ae871961a7dbe12b22d504267dc132"
SRC_URI[sha256sum] = "9aad15d8cdd8694839b54342c8b4c26ddce508f6fb29ff4bee3abbe1555771f4"
