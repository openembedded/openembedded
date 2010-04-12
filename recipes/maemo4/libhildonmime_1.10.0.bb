require libhildonmime.inc

DEPENDS = "gnome-vfs"

PR = "r1"

SRC_URI = "http://repository.maemo.org/pool/maemo4.0/free/source/libh/${PN}/${PN}_${PV}-1.tar.gz"

EXTRA_OECONF += "--with-compile-warnings=no"

SRC_URI[md5sum] = "1ff70dcec31b796602d6fb9bb0c14837"
SRC_URI[sha256sum] = "65d47c8678689d04c3bede17bde3aefffa0ce5527f72b1a0c5356fa0588b784d"
