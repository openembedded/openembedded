DESCRIPTION = "libgisi / gisicomm is a library implementing the Nokia ISI protocol"
SECTION = "libs/network"
AUTHOR = "Sebastian Reichel, Michael Lauer, Klaus Kurzmann"
LICENSE = "GPLv2"
DEPENDS = "glib-2.0"
SRC_URI = "${FREESMARTPHONE_GIT}/libgisi.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

SRCREV = "aa9942e136976bfcf32f6f15ebcc28d24163fee6"
PV = "0.0.0+gitr${SRCPV}"

inherit vala autotools

PACKAGES =+ "${PN}-tools"
FILES_${PN}-tools = "${sbindir}/sendisi"
