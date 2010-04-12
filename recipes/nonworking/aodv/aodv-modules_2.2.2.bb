DESCRIPTION = "AODV is a routing protocol for ad hoc networks designed with mobile wireless devices in mind."
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://www.antd.nist.gov/wctg/aodv_kernel/kernel-aodv_v${PV}.tgz \
	   file://fix-makefile.patch;patch=1"
S = "${WORKDIR}/kernel-aodv_v${PV}"

inherit module


SRC_URI[md5sum] = "4bbc2dfccb94a5317c1c1cff7b78f440"
SRC_URI[sha256sum] = "a1ebf8c0e88b1a5b969283ef99f772475626e10ef958562dd0e8d519bdbf6288"
