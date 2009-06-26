# initramfs-kexecboot specific config options

MACHINE_FEATURES_append = " kexecboot "

EXTRA_IMAGEDEPENDS += "linux-kexecboot"

# Include kernel image in kexecboot enabled images
RDEPENDS_kernel-base = "kernel-image" 

# we store kernel images in rootfs and only a minimal initramfs kernel in nand for booting other kernels
DONT_CHECK_KERNELSIZE ?= "1"

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS_append = " kexecboot-cfg"
