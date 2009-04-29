#initramfs image which mounts the rootfilesystem and kexecs a kernel from there

ONLINE_PACKAGE_MANAGEMENT = "none"
IMAGE_FSTYPES = "cpio.gz"

# Deprecated: device nodes are populated by kexecboot now
# These devices need mmcblk* to be 254 instead of 179
IMAGE_DEVICE_TABLES_hx4700 = "device_table-oldmmc.txt"
IMAGE_DEVICE_TABLES_h2200 = "device_table-oldmmc.txt"

export IMAGE_BASENAME = "initramfs-kexecboot-image"

KEXECBOOT_IMAGEDEPENDS ?= ""

# avoid circular dependencies
EXTRA_IMAGEDEPENDS = "${KEXECBOOT_IMAGEDEPENDS}"

IMAGE_INSTALL = "kexecboot"

IMAGE_LINGUAS = ""
IMAGE_LOGIN_MANAGER = ""
IMAGE_INIT_MANAGER = ""
IMAGE_INITSCRIPTS = ""
IMAGE_DEV_MANAGER = ""

inherit image
