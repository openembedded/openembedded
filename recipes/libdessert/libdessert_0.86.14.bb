DESCRIPTION = "DES-SERT (DES Simple and Extensible Routing-Framework for Testbeds)"
HOMEPAGE = "http://www.des-testbed.net/DES-SERT"
SECTION = "devel"
LICENSE = "GPL"
PR = "r2"

DEPENDS = "net-snmp libpcap libcli"

SRC_URI = "http://www.des-testbed.net/sites/default/files/${PN}${PV}.tar.gz \
	   file://0001-big-fat-autotools-patch.patch;patch=1 \
	  "

S = "${WORKDIR}/${PN}0.86-${PV}"

inherit autotools
