DESCRIPTION = "GLib-based DBus bindings for freesmartphone.org - Vala implementation"
AUTHOR = "Didier 'Ptitjes"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "vala-native vala-dbus-binding-tool-native dbus-glib glib-2.0 fso-specs"
SRCREV = "f1a0b3fe2ed6e15d83ad4880b4eb7aece00f9d57"
PV = "0.2.2+gitr${SRCREV}"
PR = "r3"

inherit autotools_stage pkgconfig vala

PARALLEL_MAKE = ""

SRC_URI = "${FREESMARTPHONE_GIT}/libfso-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

FILES_${PN}-dev += "${datadir}/gir-1.0/*.gir"
