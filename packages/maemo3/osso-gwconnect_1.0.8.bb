LICENSE = "LGPL"
DESCRIPTION = "Nokia osso connection library"

DEPENDS = "hildon-1 libosso"

PR = "r1"

SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}.tar.gz"

inherit autotools pkgconfig 


do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.ac
}

do_stage() {
        autotools_stage_all
}


