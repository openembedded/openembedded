DESCRIPTION = "GLib-based DBus bindings for freesmartphone.org - Vala implementation"
AUTHOR = "Didier 'Ptitjes"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "vala-dbus-binding-tool-native dbus-glib glib-2.0 fso-specs"
SRCREV = "9ab41751525d89d834d3d1011a6cde9b16c69a0d"
PV = "2010.07.28.1+gitr${SRCPV}"
PE = "1"
PR = "r1"

inherit autotools vala

SRC_URI = "${FREESMARTPHONE_GIT}/libfso-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

do_configure_prepend() {
       sed -i -e s#FSO_SPECS_DIR="#FSO_SPECS_DIR="${STAGING_DIR_HOST}/#g ${S}/configure.ac
}

