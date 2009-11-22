#@TYPE: Machine configuration
#@NAME: nios2
#@DESCRIPTION: generic machine configuration for nios2 (non-mmu) platforms

# Set default for common nios2-based machines
MACHINE_FEATURES ?= "kernel26 usbhost pci"
SHARED_LIBRARIES = "no"

TARGET_LDFLAGS_append = " -Wl,-elf2flt"

# Select an appropriate default kernel
PREFERRED_PROVIDER_virtual/kernel ?= "linux-nios2"
PREFERRED_VERSION_linux-nios2 ?= "2.6.28"

# Select the nios2-specific toolchain parts
PREFERRED_VERSION_binutils = "nios2-2.15"
PREFERRED_VERSION_binutils-cross = "nios2-2.15"
PREFERRED_VERSION_linux-libc-headers = "nios2-2.6.28"
PREFERRED_VERSION_elf2flt-cross = "nios2-git"
PREFERRED_VERSION_gcc-cross = "nios2-3.4.6"
PREFERRED_VERSION_gcc-cross-initial = "nios2-3.4.6"
PREFERRED_VERSION_gcc-cross-intermediate = "nios2-3.4.6"
PREFERRED_VERSION_uclibc = "nios2-0.9.27"
PREFERRED_VERSION_uclibc-initial = "nios2-0.9.27"

# Set default for 16MB machines - can be overridden for more or less flash.
ROOT_FLASH_SIZE ?= "12"

# Allow for rootfs loaded direct from internal hard disk
IMAGE_FSTYPES ?= "jffs2 tar.gz"

# Set default
EXTRA_IMAGECMD_jffs2 = "--pad --eraseblock=0x20000 -n"

#-------------------------------------------------------------------------------
# Board defaults
#-------------------------------------------------------------------------------
# These values are board specific but they seem to be common to a large number
# of boards so are reasonable defaults.
SERIAL_CONSOLE = "115200 ttyS0"
KERNEL_CONSOLE = "ttyS0,115200n8"
USE_VT = "0"
