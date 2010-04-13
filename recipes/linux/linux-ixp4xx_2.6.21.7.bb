require linux.inc
require linux-ixp4xx.inc

VANILLA_VERSION = "2.6.21"
KERNEL_RELEASE = "2.6.21.7"

PV = "${KERNEL_RELEASE}+svnr${SRCPV}"
PR = "r0"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${VANILLA_VERSION}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${KERNEL_RELEASE}.bz2;patch=1;name=patch \
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

SRC_URI[kernel.md5sum] = "1b515f588078dfa7f4bab2634bd17e80"
SRC_URI[kernel.sha256sum] = "f187b12d70e0a48ce81f0472dfe9504fb5f0f966be339ac9d57dd2b991a74942"
SRC_URI[patch.md5sum] = "b9c8734471a454806c77f040fcf9869b"
SRC_URI[patch.sha256sum] = "5ee24e1c5636bcffed155b1c01d7d09fedb135fa2458c190a0da03a82c8c2f60"
