SECTION = "x11/utils"
DESCRIPTION = "Inkscape is an SVG-based graphics editor featuring alpha \
blending, node editing, SVG to PNG export, and more. Its goal is for features \
similar to Illustrator, CorelDraw, Visio, etc."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
DEPENDS = "intltool-native gtk+ libart-lgpl libxml2 libsigc++-1.2 popt"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/inkscape/inkscape-${PV}.tar.bz2"
S = "${WORKDIR}/inkscape-${PV}"

inherit autotools gettext

EXTRA_OECONF = "--disable-mmx"
