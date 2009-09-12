DESCRIPTION = "libgee is a collection library providing GObject-based interfaces \
and classes for commonly used data structures."
HOMEPAGE = "http://live.gnome.org/Libgee"
SECTION = "libs"
DEPENDS = "glib-2.0"
LICENSE = "LGPL"
PV = "0.3.0+gitr${SRCREV}"

SRC_URI = "\
  git://git.gnome.org/libgee;protocol=git;branch=master \
"
S = "${WORKDIR}/git"

inherit autotools_stage pkgconfig vala

FILES_${PN}-dev += "${datadir}/gir-1.0"
