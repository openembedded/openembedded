SECTION = "x11/utils"
DESCRIPTION = "Inkscape is an SVG-based graphics editor featuring alpha \
blending, node editing, SVG to PNG export, and more. Its goal is for features \
similar to Illustrator, CorelDraw, Visio, etc."
DEPENDS = "poppler gsl libgc intltool-native gtk+ gtkmm glibmm libart-lgpl libxslt librsvg libxml2 libsigc++-1.2 popt"
LICENSE = "GPL"

#we know that GC version is 6.5, so we patch out the version check, since gc_open was already detected
SRC_URI = "${SOURCEFORGE_MIRROR}/inkscape/inkscape-${PV}.tar.bz2 \
           file://no-boehm-version-check.patch;patch=1"

S = "${WORKDIR}/inkscape-${PV}"

inherit autotools gettext mime gtk-icon-cache

EXTRA_OECONF = "--disable-mmx"
