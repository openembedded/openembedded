DESCRIPTION = "libftdi is a library to talk to FTDI chips.\
FT232BM/245BM, FT2232C/D and FT232/245R using libusb,\
including the popular bitbang mode."
HOMEPAGE = "http://www.intra2net.com/de/produkte/opensource/ftdi/"
LICENSE = "LGPL"
SECTION = "libs"

DEPENDS = "virtual/libusb0"

SRC_URI = "http://www.intra2net.com/de/produkte/opensource/ftdi/TGZ/libftdi-${PV}.tar.gz \
	   file://autotools.patch;patch=1 \
	  "

inherit autotools binconfig pkgconfig

EXTRA_OECONF += "--disable-rpath"

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "7b4a660fd644980f3d45873d156d021a"
SRC_URI[sha256sum] = "98ceb0a3174564f310c4ff1c021bdca52558bf693003a410cdb95c8388aa11f3"
