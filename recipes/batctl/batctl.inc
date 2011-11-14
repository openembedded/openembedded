DESCRIPTION = "Control application for B.A.T.M.A.N. routing protocol kernel module for multi-hop ad-hoc mesh networks."
HOMEPAGE = "http://www.open-mesh.net/"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPLv2+"

INC_PR = "r0"

RDEPENDS_${PN} = "kernel-module-batman-adv"

SRC_URI = "http://downloads.open-mesh.net/batman/stable/sources/batctl/batctl-${PV}.tar.gz"

do_compile() {
  oe_runmake
}

do_install() {
  install -d ${D}${bindir}
  install -m 0755 batctl ${D}${bindir}
}
