require xorg-app-common.inc
DESCRIPTION = "a program to create an index of X font files in a directory"
RDEPENDS_${PN} += "mkfontscale"
PE = "1"
PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "9365ac66d19186eaf030482d312fca06"
SRC_URI[archive.sha256sum] = "a534650cff503619f9101577d816cde283da993bc039273477bd8dfbd01a2d0b"

BBCLASSEXTEND = "native"
