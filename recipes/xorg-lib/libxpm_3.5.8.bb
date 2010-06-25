require xorg-lib-common.inc
DESCRIPTION = "X11 Pixmap library"
LICENSE = "X-BSD"
DEPENDS += "libxext libsm libxt"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "38e58e72d476a74298a59052fde185a3"
SRC_URI[archive.sha256sum] = "02a77aaa32e6e335e1ee04aeb9ad1008045d98274d64ed33bc5fc6c3a3542c4c"

PACKAGES =+ "sxpm cxpm"

FILES_cxpm = "${bindir}/cxpm"
FILES_sxpm = "${bindir}/sxpm"

XORG_PN = "libXpm"
