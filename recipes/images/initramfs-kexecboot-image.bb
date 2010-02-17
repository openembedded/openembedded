# Initramfs image providing kexecboot
# a linux as bootloader implementation

#export IMAGE_BASENAME = "initramfs-kexecboot-image"

DEPENDS = "lzma-native"

IMAGE_FSTYPES = "cpio.gz cpio.lzma"

# avoid circular dependencies
EXTRA_IMAGEDEPENDS = ""

IMAGE_INSTALL = "kexecboot"

IMAGE_LINGUAS = ""
IMAGE_LOGIN_MANAGER = ""
IMAGE_INIT_MANAGER = ""
IMAGE_INITSCRIPTS = ""
IMAGE_DEV_MANAGER = ""

FEED_DEPLOYDIR_BASE_URI = ""
ONLINE_PACKAGE_MANAGEMENT = "none"

inherit image
