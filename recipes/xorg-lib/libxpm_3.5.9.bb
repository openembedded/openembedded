require xorg-lib-common.inc
DESCRIPTION = "X11 Pixmap library"
LICENSE = "X-BSD"
DEPENDS += "libxext libsm libxt"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "2de3a1b9541f4b3a6f9d84b69d25530e"
SRC_URI[archive.sha256sum] = "8add01029cab0598ca86e01a2f7781a636f74b757abe6b50ba61b2a6e2fd621e"

PACKAGES =+ "sxpm cxpm"

FILES_cxpm = "${bindir}/cxpm"
FILES_sxpm = "${bindir}/sxpm"

XORG_PN = "libXpm"
