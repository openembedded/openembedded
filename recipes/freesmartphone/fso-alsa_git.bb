require cornucopia.inc

DESCRIPTION = "Mickey's DBus introspection and calling Program V2"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/multimedia"
LICENSE = "GPLv2"
DEPENDS = "fsodeviced glib-2.0 dbus dbus-glib"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "1.0.0+gitr${SRCPV}"
PR = "${INC_PR}.0"
PE = "1"

S = "${WORKDIR}/git/tools/${PN}"
