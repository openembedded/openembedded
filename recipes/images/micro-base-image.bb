# micro-base-image
#
# Image configuration for the OE Micro Linux Distribuion (micro, micro-uclibc)
#

# Install basic files only
IMAGE_INSTALL = "base-files base-passwd dropbear netbase"
IMAGE_LINGUAS = ""

# Use busybox as login manager
IMAGE_LOGIN_MANAGER = "busybox"

# Include minimum init and init scripts
IMAGE_DEV_MANAGER = "busybox-mdev"
IMAGE_INIT_MANAGER = "sysvinit sysvinit-pidof"
IMAGE_INITSCRIPTS = ""

inherit image

