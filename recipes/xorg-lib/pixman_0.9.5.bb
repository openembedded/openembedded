require xorg-lib-common.inc

DESCRIPTION = "Library for lowlevel pixel operations"
DEPENDS = "virtual/libx11"

SRC_URI += "file://dont-copy-unused-bits-to-alpha-channel.patch;patch=1"

SRC_URI[archive.md5sum] = "f9fea77e46ec7a3a16e925e137f146e7"
SRC_URI[archive.sha256sum] = "a9d4545b5dfc018cdd33fd21bc73c3f1b3c9c207f1bb6843606cc180eb10c6c8"
