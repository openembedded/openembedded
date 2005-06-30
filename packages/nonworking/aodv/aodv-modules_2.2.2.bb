DESCRIPTION = "AODV is a routing protocol for ad hoc networks designed with mobile wireless devices in mind."
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"

SRC_URI = "http://www.antd.nist.gov/wctg/aodv_kernel/kernel-aodv_v${PV}.tgz \
	   file://fix-makefile.patch;patch=1"
S = "${WORKDIR}/kernel-aodv_v${PV}"

inherit module

