LICENSE = "LGPL"
DESCRIPTION = "Nokia osso thumbnail library"

DEPENDS = "gnome-vfs gconf-dbus hildon-1 libosso"

PR = "r0"

SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}-1.tar.gz"

inherit autotools pkgconfig lib_package


do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.ac
}

do_stage() {
        autotools_stage_all
}


