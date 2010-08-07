DESCRIPTION = "libftdi is a library to talk to FTDI chips.\
FT232BM/245BM, FT2232C/D and FT232/245R using libusb,\
including the popular bitbang mode."
HOMEPAGE = "http://www.intra2net.com/en/developer/libftdi/"
LICENSE = "LGPL GPLv2+linking exception"
SECTION = "libs"

DEPENDS = "virtual/libusb0"
DEPENDS_virtclass-native = "virtual/libusb0-native"
SRC_URI = "http://www.intra2net.com/en/developer/libftdi/download/libftdi-${PV}.tar.gz \
	   file://libtool-m4.patch \
	  "

inherit autotools binconfig pkgconfig

BBCLASSEXTEND = "native"

SRC_URI[md5sum] = "916f65fa68d154621fc0cf1f405f2726"
SRC_URI[sha256sum] = "5b6f3c3ee51c6aa24d3b87135e01762cf68821d1c3599d87d349fea4ede74c62"
