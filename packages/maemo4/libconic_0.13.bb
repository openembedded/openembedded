DESCRIPTION = "Internet connection library"
LICENSE = "LGPL"
DEPENDS = "dbus gconf osso-ic-oss"

PR = "r1"

SRC_URI = "http://repository.maemo.org/pool/maemo4.0/free/source/libc/${PN}/${PN}_${PV}-0.8.tar.gz"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}


