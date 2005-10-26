# Kernel for NSLU2
#
# Increment PR_CONFIG for changes to the nslu2-kernel specific
# defconfig (do *NOT* increment anything in here for changes
# to other kernel configs!)
PR_CONFIG = "2"
#
# Increment the number below (i.e. the digits after PR) when
# making changes within this file or for changes to the patches
# applied to the kernel.
PR = "r1.${PR_CONFIG}"

include nslu2-kernel.inc

# N2K_EXTRA_PATCHES - list of patches to apply (can include
#   patches to the files installed above)
# N2K_PATCHES - full list of patches to apply, defaults to:
#   file://nslu2_2.6.11.patch;patch=1
#   file://usbnet.patch;patch=1
#   file://ixp4xx_copy_from.patch;patch=1
#   ${N2K_EXTRA_PATCHES}
#
# There are no added files no more.
N2K_FILES = ""

N2K_PATCHES = "\
	file://10-ixp4xx-copy-from.patch;patch=1 \
	file://10-mtdpart-redboot-fis-byteswap.patch;patch=1 \
	file://15-ixp4xx-writesb-l-w.patch;patch=1 \
	file://16-ixp4xx-ioremap.patch;patch=1 \
	file://18-ixp4xx-io-h-addr.patch;patch=1 \
	file://20-timer.patch;patch=1 \
	file://25-nslu2-arch-reset.patch;patch=1 \
	file://28-spinlock-up.patch;patch=1 \
	file://29-ipv4-route-c-spinlock.patch;patch=1 \
	file://30-i2c-x1205.patch;patch=1 \
	file://50-nslu2-arch.patch;patch=1 \
	file://50-nslu2-general.patch;patch=1 \
	file://60-nslu2-beeper.patch;patch=1 \
	file://90-ixp4xx-pci-le.patch;patch=1 \
	file://anonymiser.patch;patch=1 \
"

# These options get added to the kernel command line, only put things
# specific to the bootstrap of *this* kernel in here - DISTRO specfic
# config must be in CMDLINE_ROOT (see the full definition of CMDLINE
# in nslu2-kernel.inc)
CMDLINE_KERNEL_OPTIONS = "x1205.hctosys=1"
