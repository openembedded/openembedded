# Initramfs image providing kexecboot
# a linux as bootloader implementation
PR = "r3"

ONLINE_PACKAGE_MANAGEMENT = "none"
IMAGE_FSTYPES = "cpio.gz cpio.lzma"
DEPENDS = "lzma-native"

export IMAGE_BASENAME = "initramfs-kexecboot-image"

# avoid circular dependencies
EXTRA_IMAGEDEPENDS = ""

IMAGE_INSTALL = "kexecboot"

IMAGE_LINGUAS = ""
IMAGE_LOGIN_MANAGER = ""
IMAGE_INIT_MANAGER = ""
IMAGE_INITSCRIPTS = ""
IMAGE_DEV_MANAGER = ""

FEED_DEPLOYDIR_BASE_URI = ""

inherit image
