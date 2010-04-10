DESCRIPTION = "Library for rendering SVG files"
SECTION = "x11/utils"
DEPENDS = "cairo-native pango-native gdk-pixbuf-csource-native"
LICENSE = "LGPL"
PR = "r1"

inherit native autotools_stage

SRC_URI = "${GNOME_MIRROR}/librsvg/2.26/librsvg-${PV}.tar.bz2"

EXTRA_OECONF = "--disable-mozilla-plugin"

SRC_URI[md5sum] = "65dbd726a514fe8b797d26254b8efc1e"
SRC_URI[sha256sum] = "fdcab5f0d86198d8cbd4ffe5b333076f75e707f6d7e4af5e87a8644ff7533bea"
