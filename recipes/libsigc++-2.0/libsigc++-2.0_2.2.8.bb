DESCRIPTION = "A library for loose coupling of C++ method calls"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL LGPL"
DEPENDS = "mm-common"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/libsigc++/2.2/libsigc++-${PV}.tar.gz;name=archive"

SRC_URI[archive.md5sum] = "05c8333e6effe43473e06f723c6afd23"
SRC_URI[archive.sha256sum] = "b77f409ae172e75fb4712b759993049a1555986140ff1aff3020bc6cbbf77cef"

S = "${WORKDIR}/libsigc++-${PV}"

inherit autotools

EXTRA_AUTORECONF = "--exclude=autoheader"

FILES_${PN}-dev += "${libdir}/sigc++-*/"
FILES_${PN}-doc += "${datadir}/devhelp"

BBCLASSEXTEND = "native"
