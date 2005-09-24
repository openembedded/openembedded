# Kernel for NSLU2
#
# Increment PR_CONFIG for changes to the nslu2-kernel specific
# defconfig (do *NOT* increment anything in here for changes
# to other kernel configs!)
PR_CONFIG = "0"
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
	file://20-timer.patch;patch=1 \
	file://30-i2c-x1205.patch;patch=1 \
	file://50-nslu2-arch.patch;patch=1 \
	file://50-nslu2-include.patch;patch=1 \
	file://50-nslu2-setup.patch;patch=1 \
	file://55-nslu2-rpbutton.patch;patch=1 \
	file://anonymiser.patch;patch=1 \
"

CMDLINE_KERNEL_OPTIONS = ""
