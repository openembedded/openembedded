DESCRIPTION = "GLib-based DBus bindings for freesmartphone.org - Vala implementation"
AUTHOR = "Didier 'Ptitjes"

PV = "0.0.1-gitr${SRCREV}"
PR = "r1"

DEPENDS = "vala-native fso-specs vala-dbus-binding-tool-native dbus-glib glib-2.0 vala"

SRC_URI = "git://git.freesmartphone.org/libfso-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

EXTRA_OECONF = "SPECS_PATH=${STAGING_DATADIR}/fso-specs/"

inherit pkgconfig autotools autotools_stage
