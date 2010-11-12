DESCRIPTION = "PF_RING is a new type of network socket that dramatically improves the packet capture speed, this package contains PF_RING kernel module"
SECTION = "optional"
HOMEPAGE = "http://www.ntop.org/PF_RING.html"
LICENSE = "GPL"
PV = "4.4.0+svnr${SRCPV}"

S = "${WORKDIR}/kernel"

SRCREV = "4384"
SRC_URI = "svn://svn.ntop.org/svn/ntop/trunk/PF_RING;module=kernel;proto=https"

inherit module

MAKE_TARGETS = "modules"
MODULE_MAKE_FLAGS += "-C ${STAGING_KERNEL_DIR} M=${S}"

do_install_append() {
	install -d ${D}${includedir}/linux
	install -m 0644 linux/pf_ring.h ${D}${includedir}/linux
}
