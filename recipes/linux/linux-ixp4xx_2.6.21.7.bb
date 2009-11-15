require linux.inc
require linux-ixp4xx.inc

VANILLA_VERSION = "2.6.21"
KERNEL_RELEASE = "2.6.21.7"

PV = "${KERNEL_RELEASE}+svnr${SRCPV}"
PR = "r0"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${VANILLA_VERSION}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${KERNEL_RELEASE}.bz2;patch=1 \
	   svn://svn.nslu2-linux.org/svnroot/kernel/trunk/patches;module=${VANILLA_VERSION};proto=http \
	   file://defconfig-${KERNEL_RELEASE}"

S = "${WORKDIR}/linux-${VANILLA_VERSION}"

do_prepatch() {
        mv ${WORKDIR}/${VANILLA_VERSION} ${S}/patches && cd ${S} && quilt push -av
        mv patches patches.ixp4xx
        mv .pc .pc.old
        mv ${WORKDIR}/defconfig-${KERNEL_RELEASE} ${WORKDIR}/defconfig
}

addtask prepatch after do_unpack before do_patch
