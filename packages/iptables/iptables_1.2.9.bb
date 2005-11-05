SECTION = "console/network"
DESCRIPTION = "iptables network filtering tools"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.netfilter.org/files/iptables-${PV}.tar.bz2"

S = "${WORKDIR}/iptables-${PV}"

export COPT_FLAGS = "${CFLAGS}"
export KERNEL_DIR = "${STAGING_INCDIR}"

do_compile () {
	unset CFLAGS
	oe_runmake BINDIR=${D}${bindir} LIBDIR=${D}${libdir} MANDIR=${D}/usr/man NO_SHARED_LIBS=1
}

do_install () {
#	oe_runmake PREFIX=${prefix} DESTDIR=${D} install
	oe_runmake BINDIR=${D}${bindir} LIBDIR=${D}${libdir} MANDIR=${D}/usr/man install NO_SHARED_LIBS=1
}
