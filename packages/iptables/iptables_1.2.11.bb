DESCRIPTION = "iptables network filtering tools"
HOMEPAGE = "http://www.netfilter.org/"
SECTION = "console/utils"
LICENSE = "GPL"
PR = "r1"

PACKAGES =+ "${PN}-utils"
FILES_${PN}-utils = "${bindir}/iptables-save ${bindir}/iptables-restore"

SRC_URI = "http://www.netfilter.org/files/iptables-${PV}.tar.bz2"

S = "${WORKDIR}/iptables-${PV}"

PARALLEL_MAKE=""

export COPT_FLAGS = "${CFLAGS}"
export KERNEL_DIR = "${STAGING_INCDIR}"

do_compile () {
	unset CFLAGS
	oe_runmake BINDIR=${D}${bindir} LIBDIR=${D}${libdir} MANDIR=${D}${mandir} NO_SHARED_LIBS=1
}

do_install () {
	oe_runmake BINDIR=${D}${bindir} LIBDIR=${D}${libdir} MANDIR=${D}${mandir} install NO_SHARED_LIBS=1
}

FILES_${PN}-doc += "${mandir}"

