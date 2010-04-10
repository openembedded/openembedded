LICENSE = "GPL"

PR = "r1"

DEPENDS = "glib-2.0 zlib"

SRC_URI = "http://repository.maemo.org/pool/maemo4.0/free/source/libo/${PN}_${PV}-1.tar.gz"

inherit autotools pkgconfig

do_configure() {
	gnu-configize
	libtoolize --force
	oe_runconf
}

do_stage() {
	autotools_stage_all
}



SRC_URI[md5sum] = "4c5b31154943108ba0fecf00c8af9f3c"
SRC_URI[sha256sum] = "687f46d5d5eb5ced18534f3cfcfdd82db6b25679437602f1519cae48d019b55d"
