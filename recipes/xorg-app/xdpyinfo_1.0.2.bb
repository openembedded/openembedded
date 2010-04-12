require xorg-app-common.inc

DESCRIPTION = "X display information utility"
LICENSE = "MIT"
DEPENDS += "libxtst libxext libxxf86vm libxxf86dga libxxf86misc libxi libxrender libxinerama libdmx libxp libxau"
PR = "r1"
PE = "1"

SRC_URI += "file://disable-xkb.patch;patch=1"

EXTRA_OECONF = "--disable-xkb"

SRC_URI[archive.md5sum] = "c9ee60ae52c97c51d4ca327e53f0cb61"
SRC_URI[archive.sha256sum] = "c9927fc33e8a4422d74b1ebee0d19dd5a16d9ebc435e8f47f0aa546501ccfed3"
