DESCRIPTION = "libgee is a collection library providing GObject-based interfaces \
and classes for commonly used data structures."
HOMEPAGE = "http://live.gnome.org/Libgee"
SECTION = "libs"
DEPENDS = "glib-2.0"
LICENSE = "LGPL"
DEFAULT_PREFERENCE = -1
PV = "0.1.5+gitr${SRCREV}"
PR = "r0"

inherit autotools autotools_stage pkgconfig vala

SRC_URI = "git://git.gnome.org/cgit/libgee;protocol=http;branch=master \
           file://no-tests.patch;patch=1"
S = "${WORKDIR}/git"
