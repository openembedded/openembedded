require xorg-lib-common.inc
DESCRIPTION = "X11 Pixmap library"
LICENSE = "X-BSD"
DEPENDS += "libxext libsm libxt"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "37b7d1826c6a02107269632a93b8791f"
SRC_URI[archive.sha256sum] = "2d5c5242b8417db6aa758e5be387de33385d9960ff21c801af7d6a4730b4fd0d"

PACKAGES =+ "sxpm cxpm"

FILES_cxpm = "${bindir}/cxpm"
FILES_sxpm = "${bindir}/sxpm"

XORG_PN = "libXpm"
