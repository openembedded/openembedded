DESCRIPTION = "iptables network filtering tools"
HOMEPAGE = "http://www.netfilter.org/"
SECTION = "console/utils"
LICENSE = "GPL"

SRC_URI = "http://netfilter.org/projects/iptables/files/iptables-${PV}.tar.bz2"
S = "${WORKDIR}/iptables-${PV}"

INC_PR = "r6"

PARALLEL_MAKE = ""

CFLAGS += "-Du32=__u32"
RPROVIDES_${PN} += "iptables-utils"
FILES_${PN}-dbg += "${libexecdir}/xtables/.debug"
FILES_${PN}-doc += "${mandir}"

RRECOMMENDS = "\
  kernel-module-ip-tables \
  kernel-module-iptable-nat \
  kernel-module-iptable-filter \
  kernel-module-ipt-masquerade \
"
