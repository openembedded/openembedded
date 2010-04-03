DESCRIPTION = "A library for loose coupling of C++ method calls"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL LGPL"
SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/libsigc++/2.2/libsigc++-${PV}.tar.gz;name=archive \
          "

SRC_URI[archive.md5sum] = "755f31aa887d7ef63bc62366f6ecfc42"
SRC_URI[archive.sha256sum] = "acc121b763373e790e474e946322a6cbe501314997ebb9212b283c8623b0b52e"

S = "${WORKDIR}/libsigc++-${PV}"

inherit autotools pkgconfig 

EXTRA_AUTORECONF = "--exclude=autoheader"

FILES_${PN}-dev += "${libdir}/sigc++-*/"
FILES_${PN}-doc += "${datadir}/devhelp"

