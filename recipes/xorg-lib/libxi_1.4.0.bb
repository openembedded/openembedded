require xorg-lib-common.inc
DESCRIPTION = "X11 Input extension library"
DEPENDS += "libxext inputproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "4ccdfe866f94c99b9190d16ffcfb3bdc"
SRC_URI[archive.sha256sum] = "42efe95a08c7bd28bc913bf8c34ed026abcc62504307626fc5150ca360b93283"

XORG_PN = "libXi"
