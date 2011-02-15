DESCRIPTION = "libgisi / gisicomm is a library implementing the Nokia ISI protocol"
SECTION = "libs/network"
AUTHOR = "Sebastian Reichel, Michael Lauer, Klaus Kurzmann"
LICENSE = "GPLv2"
DEPENDS = "glib-2.0"
SRC_URI = "${FREESMARTPHONE_GIT}/libgisi.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

SRCREV = "5d908e328920dc3c510e425491de51faed43161b"
PV = "0.0.0+gitr${SRCPV}"

inherit vala autotools

PACKAGES =+ "${PN}-tools"
FILES_${PN}-tools = "${sbindir}/sendisi"
