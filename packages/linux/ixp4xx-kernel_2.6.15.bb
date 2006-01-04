# Kernel for IXP4xx
#
# Increment PR_CONFIG for changes to the ixp4xx-kernel specific
# defconfig (do *NOT* increment anything in here for changes
# to other kernel configs!)
PR_CONFIG = "0"
#
# Increment the number below (i.e. the digits after PR) when
# making changes within this file or for changes to the patches
# applied to the kernel.
PR = "r0.${PR_CONFIG}"

include ixp4xx-kernel.inc

#	file://60-nas100d-i2c.patch;patch=1 \
#	file://60-nas100d-ide.patch;patch=1 \
#	file://75-nslu2-leds.patch;patch=1 \
#	file://80-nslu2-io.patch;patch=1 \
#	file://92-nslu2-maclist.patch;patch=1 \

# IXP4XX_PATCHES - full list of patches to apply
IXP4XX_PATCHES = "\
	file://00-memory-h-page-shift.patch;patch=1 \
	file://10-mtdpart-redboot-fis-byteswap.patch;patch=1 \
	file://19-jffs2-force-be.patch;patch=1 \
	file://40-rtc-class.patch;patch=1 \
	file://50-nas100d-arch.patch;patch=1 \
	file://60-nslu2-beeper.patch;patch=1 \
	file://85-timer.patch;patch=1 \
	file://91-maclist.patch;patch=1 \
	file://92-nas100d-maclist.patch;patch=1 \
"

# These options get added to the kernel command line, only put things
# specific to the bootstrap of *this* kernel in here - DISTRO specfic
# config must be in CMDLINE_ROOT (see the full definition of CMDLINE
# in ixp4xx-kernel.inc)
CMDLINE_KERNEL_OPTIONS = "x1205.hctosys=1 x1205.probe=0,0x6f pcf8563.hctosys=1"
