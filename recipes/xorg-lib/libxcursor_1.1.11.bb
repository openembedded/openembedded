require xorg-lib-common.inc
DESCRIPTION = "X cursor management library"
LICENSE = "BSD-X"
DEPENDS += "libxrender libxfixes"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "866ed46f7e0d85b8c0003cebbb78a4af"
SRC_URI[archive.sha256sum] = "a06ef74579e2c06f9490e682b8e7ac915cb5280ee47bb071a2b850637a2bf6fe"

BBCLASSEXTEND = "native"

XORG_PN = "libXcursor"
