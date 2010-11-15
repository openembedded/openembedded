SECTION = "x11/utils"
DESCRIPTION = "Inkscape is an SVG-based graphics editor featuring alpha \
blending, node editing, SVG to PNG export, and more. Its goal is for features \
similar to Illustrator, CorelDraw, Visio, etc."
DEPENDS = "poppler gsl libgc intltool-native gtk+ gtkmm glibmm libart-lgpl libxslt librsvg libxml2 libsigc++-1.2 popt boost"
LICENSE = "GPLv2"

PR = "r1"

#we know that GC version is 6.5, so we patch out the version check, since gc_open was already detected
SRC_URI = "${SOURCEFORGE_MIRROR}/inkscape/inkscape-${PV}.tar.bz2 \
           file://no-boehm-version-check.patch"

SRC_URI[md5sum] = "fd8b17a3f06668603807176a77167bb9"
SRC_URI[sha256sum] = "36acd81b96aec333b7e8fced0c9b162d0b1a4e073d56aaaf1bf5f66d8eebe270"

S = "${WORKDIR}/inkscape-${PV}"

inherit autotools gettext mime gtk-icon-cache

EXTRA_OECONF = "--disable-mmx"

