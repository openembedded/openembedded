DESCRIPTION = "Internet connection library"
LICENSE = "LGPL"
DEPENDS = "dbus gconf osso-ic-oss"

PR = "r1"

SRC_URI = "http://repository.maemo.org/pool/maemo4.0/free/source/libc/${PN}/${PN}_${PV}-0.8.tar.gz"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}



SRC_URI[md5sum] = "b4078390c459ae4df3acdabca36f53da"
SRC_URI[sha256sum] = "1ee5bf796367d27987098f73dad866359e188cafe32f1871c12b4469f262c846"
