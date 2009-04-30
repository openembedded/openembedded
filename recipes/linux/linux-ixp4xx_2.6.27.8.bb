require linux.inc
require linux-ixp4xx.inc

DEFAULT_PREFERENCE = "-1"

VANILLA_VERSION = "2.6.27"
KERNEL_RELEASE = "2.6.27.8"

# If you use a rc, you will need to use this:
#PV = "${VANILLA_VERSION}+${KERNEL_RELEASE}+svnr${SRCPV}"

PV = "${KERNEL_RELEASE}+svnr${SRCPV}"
PR = "r2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${VANILLA_VERSION}.tar.bz2 \
	   ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${KERNEL_RELEASE}.bz2;patch=1 \
	   svn://svn.nslu2-linux.org/svnroot/kernel/trunk/patches;module=${VANILLA_VERSION};proto=http \
	   file://fix-install.patch;patch=1 \
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
