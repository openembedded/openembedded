DESCRIPTION = "Tools for ethernet bridging."
LICENSE = "GPL"
SECTION = "console/network"
SRC_URI = "${SOURCEFORGE_MIRROR}/bridge/bridge-utils-${PV}.tgz \
	   file://failout.patch;patch=1"
S = "${WORKDIR}/bridge-utils-${PV}"

inherit autotools

EXTRA_OECONF = "--with-linux-headers=${STAGING_INCDIR}"
