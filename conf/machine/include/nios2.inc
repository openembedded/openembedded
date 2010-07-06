#@TYPE: Machine configuration
#@NAME: nios2
#@DESCRIPTION: generic machine configuration for nios2 with mmu 

# there are some hooks for uclibc in this file
# however uclibc is not working yet

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

# for now we pin gcc, glibc and binutils
# as these are the only versions that have 
# nios2 support.
PREFERRED_VERSION_gcc-cross = "4.1.2"
PREFERRED_VERSION_gcc-cross-initial = "4.1.2"
PREFERRED_VERSION_gcc-cross-intermediate = "4.1.2"
PREFERRED_VERSION_binutils = "2.17.50.0.12"
PREFERRED_VERSION_binutils-cross = "2.17.50.0.12"
PREFERRED_VERSION_glibc = "2.5"
PREFERRED_VERSION_glibc-initial = "2.5"

# uclibc does not work yet
# PREFERRED_VERSION_uclibc = "0.9.30.3"
# PREFERRED_VERSION_uclibc-initial = "0.9.30.3"

# for now busybox 1.13.2 is the only one
# patched and tested for nios2 so pin this
# one too, until the other versions are updated 
# for nios2 too.
PREFERRED_VERSION_busybox_nios2 = "1.13.2"

# there are some issues cross-compiling when 
# using linux-libc-headers-native as we get
# some native inc dirs when compiling crt stuff
# ASSUME_PROVIDED fixes this (but breaks compilation
# on old host systems like red hat 4.
ASSUME_PROVIDED += "linux-libc-headers-native"

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
