DESCRIPTION = "GLib-based DBus bindings for freesmartphone.org - Vala implementation"
AUTHOR = "Didier 'Ptitjes"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "vala-native vala-dbus-binding-tool-native dbus-glib glib-2.0 fso-specs"
# remove the x on next version bump
PV = "0.2.1+gitr${SRCREV}"
PR = "r0"

inherit autotools_stage pkgconfig vala

SRC_URI = "git://git.freesmartphone.org/libfso-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

EXTRA_OECONF = "\
  SPECS_PATH=${STAGING_DATADIR}/fso-specs/ \
"

FILES_${PN}-dev += "${datadir}/gir-1.0/*.gir"
