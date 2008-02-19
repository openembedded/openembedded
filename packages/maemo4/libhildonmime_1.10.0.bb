require libhildonmime.inc

DEPENDS += "osso-gnome-vfs2"

PR = "r0"

SRC_URI = "http://repository.maemo.org/pool/maemo4.0/free/source/libh/${PN}/${PN}_${PV}-1.tar.gz"

EXTRA_OECONF += "--with-compile-warnings=no"
