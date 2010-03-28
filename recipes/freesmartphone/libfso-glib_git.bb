DESCRIPTION = "GLib-based DBus bindings for freesmartphone.org - Vala implementation"
AUTHOR = "Didier 'Ptitjes"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "vala-native vala-dbus-binding-tool-native dbus-glib glib-2.0 fso-specs"
PV = "0.2.2+gitr${SRCREV}"
PR = "r1"

inherit autotools_stage pkgconfig vala

PARALLEL_MAKE = ""

SRC_URI = "${FREESMARTPHONE_GIT}/libfso-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

FILES_${PN}-dev += "${datadir}/gir-1.0/*.gir"
