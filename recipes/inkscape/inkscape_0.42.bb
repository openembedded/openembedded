DEFAULT_PREFERENCE = "-1"

SECTION = "x11/utils"
DESCRIPTION = "Inkscape is an SVG-based graphics editor featuring alpha \
blending, node editing, SVG to PNG export, and more. Its goal is for features \
similar to Illustrator, CorelDraw, Visio, etc."
DEPENDS = "libgc intltool-native gtk+ gtkmm glibmm libart-lgpl libxslt librsvg libxml2 libsigc++-1.2 popt"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/inkscape/inkscape-${PV}.tar.bz2"
S = "${WORKDIR}/inkscape-${PV}"

inherit autotools gettext

EXTRA_OECONF = "--disable-mmx"

SRC_URI[md5sum] = "4af587b942647bf9e27861e2238844c8"
SRC_URI[sha256sum] = "00f94678fff587288f8e7848466b35c3f894dcc007e7101f467c46d155cddfb8"
