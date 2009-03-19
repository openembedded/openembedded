LICENSE = "LGPL"
DESCRIPTION = "Nokia osso-ic library"

DEPENDS = "dbus-glib glib-2.0 libosso"

PR = "r1"

# No sources for that Maemo revision any more.
SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}.tar.gz \
           file://dbus-api-update.patch;patch=1 "

inherit autotools pkgconfig lib_package

do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.ac
}

PARALLEL_MAKE = ""

do_stage() {
        autotools_stage_all
}


