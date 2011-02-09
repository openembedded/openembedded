DESCRIPTION = "libgisi / gisicomm is a library implementing the Nokia ISI protocol"
SECTION = "libs/network"
AUTHOR = "Sebastian Reichel, Michael Lauer, Klaus Kurzmann"
LICENSE = "GPLv2"
DEPENDS = "glib-2.0"
SRC_URI = "${FREESMARTPHONE_GIT}/libgisi.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

SRCREV = "75a7ed8b3776e5b515c9d03a20dc45bc233a61bc"
PV = "0.0.0+gitr${SRCPV}"

inherit vala autotools
