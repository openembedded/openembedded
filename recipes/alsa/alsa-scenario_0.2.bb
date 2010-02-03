DESCRIPTION = "ALSA Scenario Library"
HOMEPAGE = "http://opensource.wolfsonmicro.com/node/22"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "alsa-lib ncurses"

PR = "r0"
PE = "1"

SRC_URI = "http://sources.slimlogic.co.uk/libscenario/scenario-lib-0.2.0.tar.bz2"

S = "${WORKDIR}/scenario-lib-0.2.0"

inherit autotools
