DESCRIPTION = "GLib-based DBus bindings for freesmartphone.org - Vala implementation"
AUTHOR = "Didier 'Ptitjes"

PV = "0.0.1-gitr${SRCREV}"
PR = "r3"

DEPENDS = "fso-specs vala-dbus-binding-tool-native dbus-glib glib-2.0"

SRC_URI = "git://git.freesmartphone.org/libfso-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

EXTRA_OECONF = "SPECS_PATH=${STAGING_DATADIR}/fso-specs/"

inherit pkgconfig autotools autotools_stage vala girepository
