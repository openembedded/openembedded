SECTION = "libs"
DESCRIPTION = "Simple C Expat Wrapper."
DEPENDS = "expat"
LICENSE = "LGPL"
SRC_URI = "http://savannah.nongnu.org/download/scew/scew-${PV}.tar.gz \
	   file://m4.patch;patch=1"
PR = "r1"

inherit autotools pkgconfig

SRC_URI[md5sum] = "e9a69f7014cad332cc78667b07eebbce"
SRC_URI[sha256sum] = "0e966359b9e1de31bf375b2a982b7f63cc6dd0c253bda480d1913c668791972a"
