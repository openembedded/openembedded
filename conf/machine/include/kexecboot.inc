# kexecboot specific config options

# NOTE: include this file after zaurus-2.6.inc for zaurus machines

MACHINE_FEATURES_append = "kexecboot"

# Include Kernel image in kexecboot enabled images
RDEPENDS_kernel-base = "kernel-image" 

# we store kernel images in rootfs and only a minimal initramfs kernel in mtd1 for booting other kernels
DONT_CHECK_KERNELSIZE ?= "1"

IMAGE_DEVICE_TABLES ?= "files/device_table-minimal.txt"
#add some device nodes for kexecboot
IMAGE_DEVICE_TABLES_append = " files/device_table-kexecboot.txt"
