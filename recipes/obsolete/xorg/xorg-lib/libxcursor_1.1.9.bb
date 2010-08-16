require xorg-lib-common.inc
DESCRIPTION = "X cursor management library"
LICENSE = "BSD-X"
DEPENDS += "libxrender libxfixes"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "99b7554037a92b260891091e81815a0a"
SRC_URI[archive.sha256sum] = "1dffb3542271c8ce964066d561474caec5b639d6588b257b21cfb8225a15d2b4"

BBCLASSEXTEND = "native"

XORG_PN = "libXcursor"
