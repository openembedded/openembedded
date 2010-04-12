SECTION = "x11/utils"
DESCRIPTION = "Inkscape is an SVG-based graphics editor featuring alpha \
blending, node editing, SVG to PNG export, and more. Its goal is for features \
similar to Illustrator, CorelDraw, Visio, etc."
DEPENDS = "libgc intltool-native gtk+ gtkmm glibmm libart-lgpl libxslt librsvg libxml2 libsigc++-1.2 popt"
LICENSE = "GPL"

#we know that GC version is 6.5, so we patch out the version check, since gc_open was already detected
SRC_URI = "${SOURCEFORGE_MIRROR}/inkscape/inkscape-${PV}.tar.bz2 \
           file://no-boehm-version-check.patch;patch=1"

S = "${WORKDIR}/inkscape-${PV}"

inherit autotools gettext

EXTRA_OECONF = "--disable-mmx"

SRC_URI[md5sum] = "97c606182f5e177eef70c1e8a55efc1f"
SRC_URI[sha256sum] = "74d6088a6f7521c36b73550baa9dd0381505d66658f0bc01802aa2dfc7430fbc"
