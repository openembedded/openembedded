require xorg-app-common.inc

DESCRIPTION = "X display information utility"
LICENSE = "MIT"
DEPENDS += "libxtst libxext libxxf86vm libxxf86dga libxxf86misc libxi libxrender libxinerama libdmx libxp libxau"
PE = "1"

SRC_URI += "file://disable-xkb.patch;patch=1"

EXTRA_OECONF = "--disable-xkb"

SRC_URI[archive.md5sum] = "d1d516610316138105cd07064b257c5c"
SRC_URI[archive.sha256sum] = "780d8dfe65653f42ee26d35928ab7f72f5f27ab08eda692fe4baad05126a0631"
