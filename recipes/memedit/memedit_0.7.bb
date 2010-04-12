DESCRIPTION = "Display and change memory content for testing purpose"
HOMEPAGE = "http://www.pengutronix.de/software/memedit/downloads/"
LICENSE = "GPLv2"
SECTION = "devel"
DEPENDS = "readline"

PR = "r0"

SRC_URI = "http://www.pengutronix.de/software/memedit/downloads/memedit-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "3d0f372fb213e09b8d04826f3a0bc2eb"
SRC_URI[sha256sum] = "9bb7412a03a76da4219215d2f92addf71305ab3fcc7d9315bb6f9c41fbe851fd"
