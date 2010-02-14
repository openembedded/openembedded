# initramfs-kexecboot specific config options

# If set here, each image will also build linux-kexecboot.
# Usually the machine-installer recipe already DEPENDS on it
#
# EXTRA_IMAGEDEPENDS += "linux-kexecboot"

MACHINE_FEATURES_append = " kexecboot "
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS_append = " kexecboot-cfg "
