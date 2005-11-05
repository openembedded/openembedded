SECTION = "unknown"
DESCRIPTION = "Simple C Expat Wrapper."
DEPENDS = "expat"
LICENSE = "LGPL"
SRC_URI = "http://savannah.nongnu.org/download/scew/scew-${PV}.tar.gz \
	   file://m4.patch;patch=1"

inherit autotools pkgconfig
