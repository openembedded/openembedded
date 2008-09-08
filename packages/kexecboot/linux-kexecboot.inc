require packages/linux/linux.inc

SRC_URI = "file://defconfig"

DONT_CHECK_KERNELSIZE = ""
INITRAMFS_IMAGE = "initramfs-kexecboot-image"

# uncomment the following lines if you use u-boot as bootloader
#KERNEL_IMAGETYPE_c7x0="uImage"
#KERNEL_IMAGETYPE_akita="uImage"
#KERNEL_IMAGETYPE_spitz="uImage"

PACKAGES = ""
PROVIDES = ""

DOSRC = "http://www.do13.de/openzaurus/patches"
JLSRC = "http://www.cs.wisc.edu/~lenz/zaurus/files"
BASRC = "http://www.orca.cx/zaurus/patches"
CHSRC = "http://oz.drigon.com/patches"
TKSRC = "http://www.informatik.hu-berlin.de/~tkunze/zaurus/patches"

COMPATIBLE_HOST = "(arm|i.86).*-linux"
COMPATIBLE_MACHINE = '(collie|poodle|c7x0|akita|spitz|tosa|hx2000|qemuarm|qemux86|bootcdx86|htcuniversal|zylonite)'

KERNEL_IMAGE_BASE_NAME = "${KERNEL_IMAGETYPE}-kexecboot-${PV}-${PR}-${MACHINE}"
KERNEL_IMAGE_SYMLINK_NAME = "${KERNEL_IMAGETYPE}-kexecboot-${MACHINE}"

do_compile[depends] += "${INITRAMFS_IMAGE}:do_rootfs"

do_stage() {
}

do_install() {
}

python do_package() {
}
