DESCRIPTION = "iptables network filtering tools"
HOMEPAGE = "http://www.netfilter.org/"
SECTION = "console/utils"
LICENSE = "GPL"

SRC_URI = "http://netfilter.org/projects/iptables/files/iptables-${PV}.tar.bz2"
S = "${WORKDIR}/iptables-${PV}"

INC_PR = "r6"

PARALLEL_MAKE = ""

export COPT_FLAGS = "${CFLAGS}"
export KERNEL_DIR = "${STAGING_INCDIR}"

inherit autotools

#do_compile () {
#	oe_runmake DESTDIR=${D} NO_SHARED_LIBS=1
#}

#do_install () {
#	oe_runmake DESTDIR=${D} install NO_SHARED_LIBS=1
#}

PACKAGES =+ "${PN}-utils"
FILES_${PN}-utils = "${sbindir}/iptables-save ${sbindir}/iptables-restore"
FILES_${PN}-doc += "${mandir}"
FILES_${PN}-dbg += "${libexecdir}/xtables/.debug/*"

RRECOMMENDS = "\
  kernel-module-ip-tables \
  kernel-module-iptable-nat \
  kernel-module-iptable-filter \
  kernel-module-ipt-masquerade \
"
