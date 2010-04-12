DESCRIPTION = "libftdi is a library (using libusb) to talk to FTDI's \
FT232BM, FT245BM and FT2232C type chips including the popular bitbang mode."
HOMEPAGE = "http://www.intra2net.com/de/produkte/opensource/ftdi"
LICENSE = "GPL"
DEPENDS = "virtual/libusb0"

SRC_URI = "http://www.intra2net.com/de/produkte/opensource/ftdi/TGZ/libftdi-${PV}.tar.gz \
           file://doxygen-configure.patch;patch=1"
S = "${WORKDIR}/libftdi-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-docs"

do_stage() {
    autotools_stage_all
}

SRC_URI[md5sum] = "6b1bf276ba8d623332083477f91deefd"
SRC_URI[sha256sum] = "1ffb6284de02c75a2cd6709b6148eac0336cd0297742500da12aedd151838295"
