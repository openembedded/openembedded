require linux.inc
require linux-ixp4xx.inc

VANILLA_VERSION = "2.6.24"
KERNEL_RELEASE = "2.6.24.7"

# If you use a rc, you will need to use this:
#PV = "${VANILLA_VERSION}+${KERNEL_RELEASE}+svnr${SRCPV}"

PV = "${KERNEL_RELEASE}+svnr${SRCPV}"
PR = "r1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${VANILLA_VERSION}.tar.bz2;name=kernel \
	   ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${KERNEL_RELEASE}.bz2;patch=1;name=stablepatch \
	   svn://svn.nslu2-linux.org/svnroot/kernel/trunk/patches;module=${VANILLA_VERSION};proto=http \
	   file://defconfig-${KERNEL_RELEASE}"

S = "${WORKDIR}/linux-${VANILLA_VERSION}"

# Apply the patches from the nslu2-linux project (after the patches in SRC_URI)
do_postpatch() {
	# Move away OE patches which have been already applied.
	[ -e patches ] && mv ${S}/patches ${S}/patches.oe
	[ -e .pc ]     && mv .pc .pc.oe

	# Move the NSLU2 patches in place for quilt and apply them.
        mv ${WORKDIR}/${VANILLA_VERSION} ${S}/patches && cd ${S} && quilt push -av

	# Store the NSLU2 patches 
        mv ${S}/patches ${S}/patches.ixp4xx
        mv .pc .pc.ixp4xx

 	# And move back the OE patches
	[ -e patches.oe ] && mv ${S}/patches.oe ${S}/patches
	[ -e .pc.oe ]     && mv .pc.oe .pc

	# Copy the defconfig into ${WORKDIR}
        mv ${WORKDIR}/defconfig-${KERNEL_RELEASE} ${WORKDIR}/defconfig
}

addtask postpatch after do_patch before do_configure

SRC_URI[kernel.md5sum] = "3f23ad4b69d0a552042d1ed0f4399857"
SRC_URI[kernel.sha256sum] = "413c64fbbcf81244cb5571be4963644a1e81166a2b0f008a016528363b65c5d3"
SRC_URI[stablepatch.md5sum] = "0c1c5d6d8cd82e18d62406d2f34d1d38"
SRC_URI[stablepatch.sha256sum] = "b6bbb0dea427aa733c37d58a94b819b523c8649d7605f498348de159380c28a1"
