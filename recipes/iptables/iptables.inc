DESCRIPTION = "iptables network filtering tools"
HOMEPAGE = "http://www.netfilter.org/"
SECTION = "console/utils"
LICENSE = "GPLv2+"

SRC_URI = "http://netfilter.org/projects/iptables/files/iptables-${PV}.tar.bz2;name=iptables-${PV}"
S = "${WORKDIR}/iptables-${PV}"

INC_PR = "r7"

PARALLEL_MAKE = ""

CFLAGS += "-Du32=__u32"
RPROVIDES_${PN} += "iptables-utils"
FILES_${PN}-dbg += "${libexecdir}/xtables/.debug"
FILES_${PN}-doc += "${mandir}"

RRECOMMENDS_${PN} = "\
  kernel-module-ip-tables \
  kernel-module-iptable-nat \
  kernel-module-iptable-filter \
  kernel-module-ipt-masquerade \
"
