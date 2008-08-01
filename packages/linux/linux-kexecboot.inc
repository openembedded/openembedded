DESCRIPTION = "2.6 Linux kexec bootloader for Zaurus devices and iPAQ hx2750."
SECTION = "kernel"
LICENSE = "GPL"

DONT_CHECK_KERNELSIZE = ""
INITRAMFS_IMAGE = "initramfs-kexec-image"
inherit kernel
PACKAGES = ""
PROVIDES = ""

DOSRC = "http://www.do13.de/openzaurus/patches"
RPSRC = "http://www.rpsys.net/openzaurus/patches/archive"
JLSRC = "http://www.cs.wisc.edu/~lenz/zaurus/files"
BASRC = "http://www.orca.cx/zaurus/patches"
CHSRC = "http://oz.drigon.com/patches"
TKSRC = "http://www.informatik.hu-berlin.de/~tkunze/zaurus/patches"

COMPATIBLE_HOST = "(arm|i.86).*-linux"
COMPATIBLE_MACHINE = '(collie|poodle|c7x0|akita|spitz|tosa|hx2000|qemuarm|qemux86|bootcdx86|htcuniversal|zylonite)'

KERNEL_IMAGE_BASE_NAME = "${KERNEL_IMAGETYPE}-kexecboot-${PV}-${PR}-${MACHINE}"
KERNEL_IMAGE_SYMLINK_NAME = "${KERNEL_IMAGETYPE}-kexecboot-${MACHINE}"

KERNEL_DEFCONFIG ?= "defconfig-${MACHINE}"

do_compile[depends] += "${INITRAMFS_IMAGE}:do_rootfs"

do_configure() {
	cp '${WORKDIR}/${KERNEL_DEFCONFIG}' '${S}/.config'
	yes '' | oe_runmake oldconfig
}

do_stage() {
}

do_install() {
}

python do_package() {
}
