require xorg-lib-common.inc
DESCRIPTION = "X Video Motion Compensation extension library"
DEPENDS += "libxext libxv videoproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "bfc7524646f890dfc30dea1d676004a3"
SRC_URI[archive.sha256sum] = "3dda80e9c71fd14a14f93279c6f661703c5c1c43d104a5db0842377bdf0c3392"

XORG_PN = "libXvMC"
