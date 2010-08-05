SECTION = "x11/libs"
DESCRIPTION = "Matchbox window manager core library"
LICENSE = "GPL"
DEPENDS = "virtual/libx11 libxext expat libxft jpeg libpng zlib libxsettings-client"
PR = "r3"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-jpeg --enable-expat --enable-xsettings"

S = "${WORKDIR}/libmatchbox-${PV}"
