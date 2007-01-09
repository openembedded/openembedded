LICENSE = "GPL"

DEPENDS = "glib-2.0 zlib"

SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}-1.tar.gz"

inherit autotools pkgconfig


do_configure() {
	gnu-configize
	libtoolize --force
	oe_runconf
}

do_stage() {
        autotools_stage_all
}


