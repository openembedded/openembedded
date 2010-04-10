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

SRC_URI[md5sum] = "dffa08601c822de29b8c3e436a3994bf"
SRC_URI[sha256sum] = "dc1d3525483fa503ad4312c3b6aa3742951c8e7428674de9f43077c26f353122"
