DESCRIPTION = "Tools for ethernet bridging."
HOMEPAGE = "http://bridge.sourceforge.net/"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "sysfsutils"
RRECOMMENDS = "kernel-module-bridge"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/bridge/bridge-utils-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--with-linux-headers=${STAGING_INCDIR}"
