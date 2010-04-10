DESCRIPTION = "Pushover is a fun puzzle game originally published by Ocean in 1992. In this game you control an ant that can walk along platforms that are connected with ladders. On those platforms are dominos that need to fall according to some rules."
LICENSE = "GPLv3"
DEPENDS = "lua5.1 libsdl-x11 libsdl-mixer libsdl-ttf"

SRC_URI = "${SOURCEFORGE_MIRROR}/pushover/pushover-${PV}.tar.gz"

inherit autotools


SRC_URI[md5sum] = "aeb0f0927f596623c5a1ea9cc27220e0"
SRC_URI[sha256sum] = "612050d95b78a3c355a0f9630e4c7c2230ce3e9bdaa43f5a1392ad4d62608230"
