DESCRIPTION = "A kernel with internal initramfs"
PR = "r1"

#inherit kernel
KERNEL_IMAGETYPE ?= "zImage"

# Name of initramfs recipe to build and put result into kernel
KERNEL_INITRAMFS ?= "initramfs-image"

do_compile() {
	cd ${TOPDIR}; DISTRO=${USERDISTRO} MACHINE=${MACHINE} ANGSTROM_MODE=uclibc IMAGE_FSTYPES=cpio.gz DEPLOY_TO=${WORKDIR}/initramfs.bin bitbake ${KERNEL_INITRAMFS} -c deploy_to
	cd ${TOPDIR}; DISTRO=${USERDISTRO} MACHINE=${MACHINE} INITRAMFS_LOC=${WORKDIR}/initramfs.bin DEPLOY_TO=${WORKDIR}/\${KERNEL_IMAGE_BASE_NAME} bitbake virtual/kernel -c builtin_initramfs
}

do_install() {
        install -d ${D}/boot/
	install -m 644 ${WORKDIR}/${KERNEL_IMAGETYPE}* ${D}/boot/${KERNEL_IMAGETYPE}-${@get_pv(d)}
}

def get_version(d):
	import bb
	import os
	dest = bb.data.getVar("WORKDIR", d, 1)
	try:
	    files = os.listdir(dest)
	    files = filter(lambda f:f.startswith("zImage-"), files)
	    ver = files[0][len("zImage-"):]
	    return ver
	except:
	    return "dum-m-y"

def get_pv(d):
	ver = get_version(d)
	verc = ver.split("-")
	return verc[0] + "-" + verc[1]
	
def get_pr(d):
	ver = get_version(d)
	verc = ver.split("-")
	return verc[2]

PACKAGES = "kernel-image"
FILES_kernel-image = "/boot/*"
PKG_kernel-image = "kernel-image-${@get_pv(d)}"
PKGPV_kernel-image = "${@get_pv(d)}"
PKGPR_kernel-image = "${@get_pr(d)}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
