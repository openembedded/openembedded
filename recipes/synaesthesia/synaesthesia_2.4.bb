DESCRIPTION = "Synaesthesia is a program that gives a graphical accompanyment to music."
SECTION = "x11/multimedia"
HOMEPAGE = "http://www.logarithmic.net/pfh/synaesthesia"
LICENSE = "GPL"
DEPENDS = "libx11"
# optional
# DEPENDS += "libsdl-x11 directfb"

SRC_URI = "http://www.logarithmic.net/pfh-files/synaesthesia/synaesthesia-${PV}.tar.gz"

inherit autotools



SRC_URI[md5sum] = "784105cbeed3ab209231675f0e029497"
SRC_URI[sha256sum] = "48505975e809ebadf416dc3e35a528ef87f01b117f2f1c5498d728ead8786493"
