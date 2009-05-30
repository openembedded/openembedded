DESCRIPTION = "ALSA Scenario Library"
HOMEPAGE = "http://opensource.wolfsonmicro.com/node/22"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "alsa-lib ncurses"
PV = "0.1+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/alsa-scenario;branch=mickey;protocol=git"
S = "${WORKDIR}/git"

inherit autotools autotools_stage lib_package
