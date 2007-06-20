DESCRIPTION = "Display and change memory content for testing purpose"
HOMEPAGE = "http://www.pengutronix.de/software/memedit/downloads/"
LICENSE = "GPLv2"
SECTION = "devel"
DEPENDS = "readline"

PR = "r0"

SRC_URI = "http://www.pengutronix.de/software/memedit/downloads/memedit-${PV}.tar.gz"

inherit autotools
