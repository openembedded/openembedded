SECTION = "console/utils"
DESCRIPTION = "GPS data converter"
DEPENDS = "expat libusb-compat"
HOMEPAGE = "http://www.gpsbabel.org/"
LICENSE = "GPL"

SRC_URI = "http://www.gpsbabel.org/plan9.php?dl=gpsbabel-${PV}.tar.gz"

inherit autotools pkgconfig
