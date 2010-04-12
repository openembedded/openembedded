SECTION = "console/utils"
DESCRIPTION = "GPS data converter"
DEPENDS = "expat virtual/libusb0"
HOMEPAGE = "http://www.gpsbabel.org/"
LICENSE = "GPL"

SRC_URI = "http://www.gpsbabel.org/plan9.php?dl=gpsbabel-${PV}.tar.gz \
           file://autotools.patch;patch=1"

inherit autotools pkgconfig

SRC_URI[md5sum] = "1571b31f8f06f722995449dbff01ca49"
SRC_URI[sha256sum] = "08bd5d04fc93fe18ccc580f223cc551bde1d581723fd9f92f91b48ddd8a5a9b6"
