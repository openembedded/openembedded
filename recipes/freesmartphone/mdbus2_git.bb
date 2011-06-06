require cornucopia.inc

DESCRIPTION = "Mickey's DBus introspection and calling Program V2"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ebb5c50ab7cab4baeffba14977030c07"
DEPENDS = "glib-2.0 dbus dbus-glib"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "2.0.2+gitr${SRCPV}"
PR = "${INC_PR}.0"
PE = "1"

S = "${WORKDIR}/git/tools/${PN}"
