#@TYPE: Machine configuration
#@NAME: ixp4xx
#@DESCRIPTION: genric machine configuration for ixp4xx platforms

# Set default for common ixp4xx-based machines
MACHINE_FEATURES ?= "kernel26 usbhost ext2 vfat redboot apex"

# Select an appropriate default kernel
PREFERRED_PROVIDER_virtual/kernel ?= "linux-ixp4xx"
PREFERRED_VERSION_linux-ixp4xx ?= "2.6.21.7+svnr${SRCREV}"

# Add packages required for basic networking support
MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= "ixp4xx-npe"

# Set default for 16MB machines - can be overridden for more or less flash.
ROOT_FLASH_SIZE ?= "12"

# Allow for rootfs loaded direct from internal hard disk
IMAGE_FSTYPES ?= "jffs2 tar.gz"

# Set default for common ixp4xx-based machines
EXTRA_IMAGECMD_jffs2 = "--pad --eraseblock=0x20000 -n"

require conf/machine/include/tune-xscale.inc
require conf/machine/include/tune-thumb.inc

#-------------------------------------------------------------------------------
# Board defaults
#-------------------------------------------------------------------------------
# These values are board specific but they seem to be common to a large number
# of boards so are reasonable defaults.
SERIAL_CONSOLE = "115200 ttyS0"
KERNEL_CONSOLE = "ttyS0,115200n8"
USE_VT = "0"
