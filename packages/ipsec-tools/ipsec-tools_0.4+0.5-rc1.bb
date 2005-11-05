include ipsec-tools.inc

BV = "${@bb.data.getVar('PV', d, 1).split('+')[1]}"
SRC_URI = "${SOURCEFORGE_MIRROR}/ipsec-tools/ipsec-tools-${BV}.tar.bz2 \
	   file://cross.patch;patch=1"
S = "${WORKDIR}/ipsec-tools-${BV}"
