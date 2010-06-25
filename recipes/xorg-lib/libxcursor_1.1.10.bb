require xorg-lib-common.inc
DESCRIPTION = "X cursor management library"
LICENSE = "BSD-X"
DEPENDS += "libxrender libxfixes"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "7dcdad1c10daea872cb3355af414b2ca"
SRC_URI[archive.sha256sum] = "b9446df62203f2c3204b6bcc0057dc909d0dc792f0dd97bc491581b08be36cbd"

BBCLASSEXTEND = "native"

XORG_PN = "libXcursor"
