DESCRIPTION = "Mickey's DBus introspection and calling Program rewritten in vala"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://www.freesmartphone.org"
SECTION = "console/network"
LICENSE = "GPLv2"

DEPENDS = "vala-native glib-2.0 dbus dbus-glib"

PV = "2.0.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/cornucopia.git;protocol=git;branch=master"
S = "${WORKDIR}/git/tools/mdbus2"

inherit autotools


