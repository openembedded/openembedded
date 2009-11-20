DESCRIPTION = "Mobile Broadband Service Provider Database"
SECTION = "network"
LICENSE = "CCPD"
PV = "gitr${SRCREV}"
PR = "r0"

SRC_URI = "git://git.gnome.org/mobile-broadband-provider-info;protocol=git"
S = "${WORKDIR}/git"

inherit autotools_stage
