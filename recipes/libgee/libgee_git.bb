DESCRIPTION = "libgee is a collection library providing GObject-based interfaces \
and classes for commonly used data structures."
HOMEPAGE = "http://live.gnome.org/Libgee"
SECTION = "libs"
DEPENDS = "glib-2.0 vala-native"
DEPENDS_virtclass-native = "glib-2.0-native"
LICENSE = "LGPL"
SRCREV = "9a3d48187d87b0ed151a339a9b05f6f4eefb0922"
PV = "0.5.0+gitr${SRCPV}"
PE = "1"

SRC_URI = "\
  git://git.gnome.org/libgee;protocol=git;branch=master \
"
S = "${WORKDIR}/git"

inherit autotools vala

# only because of do_stage_append in vala.bbclass
do_stage() {

}

BBCLASSEXTEND = "native"
