# Kernel for Iomega NAS 100d
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

include nas100d-kernel.inc

# N1K_PATCHES - full list of patches to apply
N1K_PATCHES = "\
	file://00-memory-h-page-shift.patch;patch=1 \
	file://10-mtdpart-redboot-fis-byteswap.patch;patch=1 \
	file://19-jffs2-force-be.patch;patch=1 \
	file://50-nas100d-arch.patch;patch=1 \
	file://55-nas100d-arch.patch;patch=1 \
	file://60-nas100d-ide.patch;patch=1 \
	file://60-nas100d-i2c.patch;patch=1 \
	file://90-ixp4xx-nslu2.patch;patch=1 \
"

# These options get added to the kernel command line, only put things
# specific to the bootstrap of *this* kernel in here - DISTRO specfic
# config must be in CMDLINE_ROOT (see the full definition of CMDLINE
# in nas100d-kernel.inc)
CMDLINE_KERNEL_OPTIONS = "pcf8563.hctosys=1"
