DESCRIPTION = "Vala meets the Enlightenment Foundation Libraries"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "vala-native glib-2.0 dbus dbus-glib eina eet evas ecore edje elementary"
PV = "0.0.0.0+gitr${SRCREV}"
PR = "r0"

#don't need examples for building vala programs
EXTRA_OECONF = "--disable-examples --disable-library"

SRC_URI = "${FREESMARTPHONE_GIT}/libeflvala;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools_stage pkgconfig vala

PACKAGES =+ "${PN}-examples"
FILES_${PN}-examples = "${datadir}/libeflvala ${bindir}"