# Initramfs image providing kexecboot
# a linux as bootloader implementation
PR = "r2"

ONLINE_PACKAGE_MANAGEMENT = "none"
IMAGE_FSTYPES = "cpio.gz cpio.lzma"
DEPENDS = "lzma-native"

# Deprecated: device nodes are populated by kexecboot now
# These devices need mmcblk* to be 254 instead of 179
IMAGE_DEVICE_TABLES_hx4700 = "device_table-oldmmc.txt"
IMAGE_DEVICE_TABLES_h2200 = "device_table-oldmmc.txt"

export IMAGE_BASENAME = "initramfs-kexecboot-image"

# avoid circular dependencies
EXTRA_IMAGEDEPENDS = ""

IMAGE_INSTALL = "kexecboot"

IMAGE_LINGUAS = ""
IMAGE_LOGIN_MANAGER = ""
IMAGE_INIT_MANAGER = ""
IMAGE_INITSCRIPTS = ""
IMAGE_DEV_MANAGER = ""

inherit image
