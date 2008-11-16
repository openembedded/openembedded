DESCRIPTION = "ALSA Scenario Library"
HOMEPAGE = "http://opensource.wolfsonmicro.com/node/22"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "alsa-lib ncurses"
PV = "0.1+gitr${SRCREV}"
PR = "r0"
PE = "1"

SRC_URI = "git://opensource.wolfsonmicro.com/alsa-scenario;branch=master;protocol=git"
S = "${WORKDIR}/git"

inherit autotools
