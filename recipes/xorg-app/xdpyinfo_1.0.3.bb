require xorg-app-common.inc

DESCRIPTION = "X display information utility"
LICENSE = "MIT"
DEPENDS += "libxtst libxext libxxf86vm libxxf86dga libxxf86misc libxi libxrender libxinerama libdmx libxp libxau"
PE = "1"

SRC_URI += "file://disable-xkb.patch;patch=1"

EXTRA_OECONF = "--disable-xkb"

SRC_URI[archive.md5sum] = "b7cbab6cbcd12bf7ad65dbc12d86e104"
SRC_URI[archive.sha256sum] = "4294768751bd4ffb47e5ebacfc7b5b9f95a1a2f4d221d8af64474382473e1962"
