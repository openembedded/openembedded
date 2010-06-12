DESCRIPTION = "canutils (PTX flavour)"
AUTHOR = "Luotao Fu"
HOMEPAGE = "http://www.pengutronix.de"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libsocketcan"
RCONFLICTS_${PN} = "socketcan-utils-test"
INC_PR = "r1"

SRC_URI = "git://git.pengutronix.de/git/tools/canutils.git;protocol=git;tag=${TAG} \
        "

S = "${WORKDIR}/git"

inherit autotools
