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



SRC_URI[md5sum] = "e27a20ac9bc9100f48effdfca8e8c595"
SRC_URI[sha256sum] = "53258864f9fc951c26b491bbc958ebccf4b1cc287cd71209e86e5aff67d0f12e"
