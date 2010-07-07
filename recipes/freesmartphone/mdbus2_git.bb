require cornucopia.inc

DESCRIPTION = "Mickey's DBus introspection and calling Program V2"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
LICENSE = "GPLv2"
DEPENDS = "glib-2.0 dbus dbus-glib"
SRCREV = "c9629132869ab84c70ff58be458e138bcb0e9c58"
PV = "2.0.0+gitr${SRCPV}"
PR = "${INC_PR}.0"
PE = "1"

S = "${WORKDIR}/git/tools/${PN}"
