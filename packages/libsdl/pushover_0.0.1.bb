DESCRIPTION = "Pushover is a fun puzzle game originally published by Ocean in 1992. In this game you control an ant that can walk along platforms that are connected with ladders. On those platforms are dominos that need to fall according to some rules."
LICENSE = "GPLv3"
DEPENDS = "lua5.1 libsdl-x11 libsdl-mixer libsdl-ttf"

SRC_URI = "${SOURCEFORGE_MIRROR}/pushover/pushover-${PV}.tar.gz"

inherit autotools

