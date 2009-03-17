DESCRIPTION = "Tools for ethernet bridging."
HOMEPAGE = "http://bridge.sourceforge.net/"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "sysfsutils"
RRECOMMENDS = "kernel-module-bridge"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/bridge/bridge-utils-${PV}.tar.gz"
S = "${WORKDIR}/bridge-utils-${PV}"

inherit autotools

EXTRA_OECONF = "--with-linux-headers=${STAGING_INCDIR}"
