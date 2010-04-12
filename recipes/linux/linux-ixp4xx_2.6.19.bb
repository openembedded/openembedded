require linux.inc
require linux-ixp4xx.inc

KERNEL_RELEASE = "2.6.19"

PV = "${KERNEL_RELEASE}+svnr${SRCPV}"
PR = "r0"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${KERNEL_RELEASE}.tar.bz2 \
	   svn://svn.nslu2-linux.org/svnroot/kernel/trunk/patches;module=${KERNEL_RELEASE};proto=http \
	   file://defconfig-${KERNEL_RELEASE}"

S = "${WORKDIR}/linux-${KERNEL_RELEASE}"

do_prepatch() {
        mv ${WORKDIR}/${KERNEL_RELEASE} ${S}/patches && cd ${S} && quilt push -av
        mv patches patches.ixp4xx
        mv .pc .pc.old
        mv ${WORKDIR}/defconfig-${KERNEL_RELEASE} ${WORKDIR}/defconfig
}

addtask prepatch after do_unpack before do_patch

SRC_URI[md5sum] = "443c265b57e87eadc0c677c3acc37e20"
SRC_URI[sha256sum] = "c2fd6bcd2b7c1b3d37d64e4d1825703792a75474830a3db7d2dc603a8d392d58"
