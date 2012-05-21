DESCRIPTION = "Control basic functions in socketcan from userspace"
AUTHOR = "Luotao Fu"
HOMEPAGE = "http://www.pengutronix.de"
SECTION = "libs/network"
PRIORITY = "optional"
LICENSE = "LGPLv2.1"

TAG = "v${PV}"
INC_PR = "r1"

SRC_URI = "git://git.pengutronix.de/git/tools/libsocketcan.git;protocol=git;tag=${TAG} \
	"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
