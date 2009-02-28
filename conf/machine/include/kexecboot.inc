# kexecboot specific config options

# NOTE: include this file after zaurus-2.6.inc for zaurus machines

MACHINE_FEATURES_append = " kexecboot "

IMAGE_FSTYPES += " tar.gz "
EXTRA_IMAGEDEPENDS += "linux-kexecboot"

# Include Kernel image in kexecboot enabled images
RDEPENDS_kernel-base = "kernel-image" 

# we store kernel images in rootfs and only a minimal initramfs kernel in mtd1 for booting other kernels
DONT_CHECK_KERNELSIZE ?= "1"

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS_append = " kexecboot-cfg"

IMAGE_LOGIN_MANAGER = ""
IMAGE_INIT_MANAGER = ""
IMAGE_INITSCRIPTS = ""
IMAGE_DEV_MANAGER = ""
ONLINE_PACKAGE_MANAGEMENT = "none"
