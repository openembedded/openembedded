DESCRIPTION = "GLib-based DBus bindings for freesmartphone.org - Vala implementation"
AUTHOR = "Didier 'Ptitjes"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "vala-dbus-binding-tool-native dbus-glib glib-2.0 fso-specs"
SRCREV = "dfe7b16539ddcdb3cc7bc4321c067528f3bd350f"
PV = "2010.09.06.1+gitr${SRCPV}"
PE = "1"
PR = "r1"

inherit autotools vala

SRC_URI = "${FREESMARTPHONE_GIT}/libfso-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

do_configure_prepend() {
       sed -i -e s#FSO_SPECS_DIR="#FSO_SPECS_DIR="${STAGING_DIR_HOST}/#g ${S}/configure.ac
}

