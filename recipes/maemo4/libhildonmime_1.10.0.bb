require libhildonmime.inc

DEPENDS = "gnome-vfs"

PR = "r1"

SRC_URI = "http://repository.maemo.org/pool/maemo4.0/free/source/libh/${PN}/${PN}_${PV}-1.tar.gz"

EXTRA_OECONF += "--with-compile-warnings=no"
