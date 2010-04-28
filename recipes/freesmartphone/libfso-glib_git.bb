DESCRIPTION = "GLib-based DBus bindings for freesmartphone.org - Vala implementation"
AUTHOR = "Didier 'Ptitjes"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "vala-dbus-binding-tool-native dbus-glib glib-2.0 fso-specs"
SRCREV = "a8ef303b0f700487d4c5f67da555b3d68818ccdc"
PV = "0.2.2+gitr${SRCPV}"
PE = "1"
PR = "r4"

inherit autotools vala

SRC_URI = "${FREESMARTPHONE_GIT}/libfso-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"
