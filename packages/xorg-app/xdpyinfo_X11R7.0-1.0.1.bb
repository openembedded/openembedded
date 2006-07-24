include xorg-app-common.inc

DESCRIPTION = "X display information utility"
LICENSE = "MIT"

DEPENDS += " libxtst libxext libx11 libxxf86vm libxxf86dga libxxf86misc libxi libxrender libxinerama libdmx libxp"

EXTRA_OECONF = "--disable-xkb"
