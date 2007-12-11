LICENSE = "LGPL"
DESCRIPTION = "Nokia osso library"

DEPENDS = "hildon-1 dbus-glib glib-2.0 outo"

PR = "r1"

SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}-1.tar.gz"

inherit autotools pkgconfig lib_package


do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.ac
}

do_stage() {
        autotools_stage_all
}


