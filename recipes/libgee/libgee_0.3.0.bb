DESCRIPTION = "libgee is a collection library providing GObject-based interfaces \
and classes for commonly used data structures."
HOMEPAGE = "http://live.gnome.org/Libgee"
SECTION = "libs"
DEPENDS = "glib-2.0"
LICENSE = "LGPL"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/libgee/0.3/libgee-${PV}.tar.bz2 \
           file://no-tests.patch;patch=1"

inherit autotools_stage pkgconfig vala
