SECTION = "console/utils"
DESCRIPTION = "GPS data converter"
DEPENDS = "expat virtual/libusb0"
HOMEPAGE = "http://www.gpsbabel.org/"
LICENSE = "GPL"

SRC_URI = "http://www.gpsbabel.org/plan9.php?dl=gpsbabel-${PV}.tar.gz \
           file://autotools.patch;patch=1"

inherit autotools pkgconfig
