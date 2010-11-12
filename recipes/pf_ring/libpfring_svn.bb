DESCRIPTION = "PF_RING is a new type of network socket that dramatically improves the packet capture speed, this package contains userspace library for interaction with kernel PF_RING module"
SECTION = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://www.ntop.org/PF_RING.html"
DEPENDS += "pf-ring"
PV = "4.4.0+svnr${SRCPV}"

S = "${WORKDIR}/lib"

SRCREV = "4384"
SRC_URI = " \
	svn://svn.ntop.org/svn/ntop/trunk/PF_RING/userland;module=lib;proto=https \
	file://libpfring-makefile-fixes.patch;striplevel=0 \
	"

CFLAGS += "-fPIC"
LDFLAGS += "-shared"

do_install() {
	oe_runmake DESTDIR=${D} install
}

RRECOMMENDS_${PN} = "pf-ring"
