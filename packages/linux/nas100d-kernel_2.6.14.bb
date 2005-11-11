# Kernel for NAS 100d
#
# Increment PR_CONFIG for changes to the nas100d-kernel specific
# defconfig (do *NOT* increment anything in here for changes
# to other kernel configs!)
PR_CONFIG = "0"
#
# Increment the number below (i.e. the digits after PR) when
# making changes within this file or for changes to the patches
# applied to the kernel.
PR = "r0.${PR_CONFIG}"

N1K_FILES = "\
	arch/arm/mach-ixp4xx/nas100d-pci.c \
	arch/arm/mach-ixp4xx/nas100d-power.c \
	arch/arm/mach-ixp4xx/nas100d-setup.c \
	include/asm-arm/arch-ixp4xx/nas100d.h \
"

N1K_PATCHES = "\
	file://10-ixp4xx-copy-from.patch;patch=1 \
	file://10-ixp4xx-le.patch;patch=1 \
	file://10-mtdpart-redboot-fis-byteswap.patch;patch=1 \
	file://15-ixp4xx-writesb-l-w.patch;patch=1 \
	file://18-ixp4xx-io-h-addr.patch;patch=1 \
	file://28-spinlock-up.patch;patch=1 \
	file://29-ipv4-route-c-spinlock.patch;patch=1 \
	file://50-nas100d-arch.patch;patch=1 \
	file://90-ixp4xx-pci-le.patch;patch=1 \
"

#	file://60-nas100d-ide.patch;patch=1 \

include nas100d-kernel.inc

# These options get added to the kernel command line, only put things
# specific to the bootstrap of *this* kernel in here - DISTRO specfic
# config must be in CMDLINE_ROOT (see the full definition of CMDLINE
# in nas100d-kernel.inc)
# CMDLINE_KERNEL_OPTIONS = "x1205.hctosys=1"
