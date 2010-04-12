SECTION = "x11/utils"
DESCRIPTION = "Inkscape is an SVG-based graphics editor featuring alpha \
blending, node editing, SVG to PNG export, and more. Its goal is for features \
similar to Illustrator, CorelDraw, Visio, etc."
DEPENDS = "intltool-native gtk+ libart-lgpl libxml2 libsigc++-1.2 popt"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/inkscape/inkscape-${PV}.tar.bz2"
S = "${WORKDIR}/inkscape-${PV}"

inherit autotools gettext

EXTRA_OECONF = "--disable-mmx"

SRC_URI[md5sum] = "3542a646c6742686557b2f0e52c5f6dc"
SRC_URI[sha256sum] = "9436f3c01dc69a1e7781633cd85936a40b3a84325e01930188bbae45e13fdbdc"
