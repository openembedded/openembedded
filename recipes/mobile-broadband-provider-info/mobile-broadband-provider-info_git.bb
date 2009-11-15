DESCRIPTION = "Mobile Broadband Service Provider Database"
SECTION = "network"
LICENSE = "CCPD"
PV = "1.0.0+gitr${SRCPV}"
PE = "1"
PR = "r0"

SRC_URI = "git://git.gnome.org/mobile-broadband-provider-info;protocol=git"
S = "${WORKDIR}/git"

inherit autotools_stage
