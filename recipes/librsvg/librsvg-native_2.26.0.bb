DESCRIPTION = "Library for rendering SVG files"
SECTION = "x11/utils"
DEPENDS = "cairo-native pango-native gdk-pixbuf-csource-native"
LICENSE = "LGPL"
PR = "r1"

inherit native autotools_stage

SRC_URI = "${GNOME_MIRROR}/librsvg/2.26/librsvg-${PV}.tar.bz2"

EXTRA_OECONF = "--disable-mozilla-plugin"
