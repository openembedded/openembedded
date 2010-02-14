# initramfs-kexecboot specific config options

MACHINE_FEATURES_append = " kexecboot "

EXTRA_IMAGEDEPENDS += "linux-kexecboot"

# Include kernel in the rootfs (to be launched by kexec)
RDEPENDS_kernel-base = "kernel-image"

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS_append = " kexecboot-cfg"
