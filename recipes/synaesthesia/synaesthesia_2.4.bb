DESCRIPTION = "Synaesthesia is a program that gives a graphical accompanyment to music."
SECTION = "x11/multimedia"
HOMEPAGE = "http://www.logarithmic.net/pfh/synaesthesia"
LICENSE = "GPL"
DEPENDS = "libx11"
# optional
# DEPENDS += "libsdl-x11 directfb"

SRC_URI = "http://www.logarithmic.net/pfh-files/synaesthesia/synaesthesia-${PV}.tar.gz"

inherit autotools


