# Initramfs-kexecboot extra config


# If set here, each image will also build linux-kexecboot.
# Usually the machine-installer recipe already DEPENDS on it
#
EXTRA_IMAGEDEPENDS += "linux-kexecboot"


# Force inclusion of kernel in target images
# (done by default)
#
RDEPENDS_kernel-base = "kernel-image"


# Install /boot/boot.cfg in target images
#
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS_append = " kexecboot-cfg "
