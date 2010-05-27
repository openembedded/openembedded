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

SRC_URI[md5sum] = "18b370f6ff89546df66fe64a2efd676a"
SRC_URI[sha256sum] = "d76d0e8267e781e4ed4a93c9f51b7ae1257bfb2fadb8d8f5b64414b5340b1239"
