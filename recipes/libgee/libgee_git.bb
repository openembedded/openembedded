DESCRIPTION = "libgee is a collection library providing GObject-based interfaces \
and classes for commonly used data structures."
HOMEPAGE = "http://live.gnome.org/Libgee"
SECTION = "libs"
DEPENDS = "glib-2.0"
BBCLASSEXTEND = "native"
DEPENDS_virtclass-native = "glib-2.0-native"
LICENSE = "LGPL"
SRCREV = "3c3af3ecc99bc130643c2b372164e987a5a261a9"
PV = "0.5.1+gitr${SRCPV}"
PE = "1"

SRC_URI = "\
  git://git.gnome.org/libgee;protocol=git;branch=master \
"
S = "${WORKDIR}/git"

inherit autotools vala
