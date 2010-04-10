DESCRIPTION = "libusb-0 compatibility library using libusb-1"
HOMEPAGE = "http://libusb.sf.net"
SECTION = "libs"
LICENSE = "LGPLv2.1"
PROVIDES = "virtual/libusb0"
PE = "1"
PR = "r0"

DEPENDS = "libusb1"

SRC_URI = "${SOURCEFORGE_MIRROR}/libusb/${P}.tar.bz2"
SRC_URI_append_nylon = " file://gcc-3-compatibility.patch;patch=1"

inherit autotools_stage binconfig lib_package

AUTOTOOLS_STAGE_PKGCONFIG = "1"
EXTRA_OECONF = "--disable-build-docs"

SRC_URI[md5sum] = "efcef8350b47bd63bee65d42a796e14b"
SRC_URI[sha256sum] = "476eb0d48981ea05e2f82955d59a3445e32be41c0afeb8a2827b9361bb560560"
