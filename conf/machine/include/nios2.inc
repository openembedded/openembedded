#@TYPE: Machine configuration
#@NAME: nios2
#@DESCRIPTION: generic machine configuration for nios2 with mmu 

# there are some hooks for uclibc in this file
# however uclibc is not working yet

TARGET_CC_ARCH = ""
BASE_PACKAGE_ARCH = "nios2"
FEED_ARCH = "nios2"

# LIBC = "uclibc" 
LIBC = "glibc" 
# and for the angstrom folks
ANGSTROMLIBC = "${LIBC}"

# fix up target strings
# TARGET_PREFIX = "nios2-linux-uclibc-"
TARGET_PREFIX = "nios2-linux-"
TARGET_VENDOR_nios2 = ""

# Set default for common nios2-based machines
MACHINE_FEATURES ?= "kernel26"
# Select an appropriate default kernel

PREFERRED_PROVIDER_virtual/kernel ?= "linux-nios2"

# Set default for 16MB machines - can be overridden for more or less flash.
ROOT_FLASH_SIZE ?= "12"

# Allow for rootfs loaded direct from internal hard disk
IMAGE_FSTYPES ?= "jffs2 tar.gz"

# Set default for common ixp4xx-based machines
EXTRA_IMAGECMD_jffs2 = "--pad --eraseblock=0x20000 -n"

#-------------------------------------------------------------------------------
# Board defaults
#-------------------------------------------------------------------------------
# These values are board specific but they seem to be common to a large number
# of boards so are reasonable defaults.
SERIAL_CONSOLE = "115200 ttyS0"
KERNEL_CONSOLE = "ttyS0,115200n8"
USE_VT = "0"
