require xorg-lib-common.inc
DESCRIPTION = "X11 Pixmap library"
LICENSE = "X-BSD"
DEPENDS += "libxext libsm libxt"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "cd15ee542d9f515538b4462a6f79d977"
SRC_URI[archive.sha256sum] = "64701ae67ce5b0797307b75d8255bec3a0d371d0c50715ea618f5a68bcc92baa"

PACKAGES =+ "sxpm cxpm"

FILES_cxpm = "${bindir}/cxpm"
FILES_sxpm = "${bindir}/sxpm"

XORG_PN = "libXpm"
