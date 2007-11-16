DESCRIPTION = "Internet connection library"
LICENSE = "LGPL"
DEPENDS = "dbus-glib gconf"

SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}.tar.gz \
           file://dbus-api-update.patch;patch=1"
inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}


