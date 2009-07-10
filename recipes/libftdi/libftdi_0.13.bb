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
