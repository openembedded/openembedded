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

SRC_URI[md5sum] = "7c9f9ecfcc36217ac2af3dba7828e284"
SRC_URI[sha256sum] = "4cea899ab0fc3d96a6ba1e5e7e28253636f4ceb3ed3cba88da4cbaa328e42285"
