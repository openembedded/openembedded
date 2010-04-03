DESCRIPTION = "A library for loose coupling of C++ method calls"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL LGPL"
SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/libsigc++/2.2/libsigc++-${PV}.tar.gz \
          "

S = "${WORKDIR}/libsigc++-${PV}"

inherit autotools pkgconfig 

EXTRA_AUTORECONF = "--exclude=autoheader"

FILES_${PN}-dev += "${libdir}/sigc++-*/"


