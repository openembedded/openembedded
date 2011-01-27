require xorg-lib-common.inc
DESCRIPTION = "X11 Input extension library"
DEPENDS += "libxext inputproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "e4b6fb1b08a92075469174f0cccde168"
SRC_URI[archive.sha256sum] = "599f1c0930f94c2ae74711b2577a7f354c4a991cc97b5ec5bb655b855c1429a6"

XORG_PN = "libXi"
