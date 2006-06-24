# Kernel for IXP4xx
#
# Increment PR_CONFIG for changes to the ixp4xx-kernel specific
# defconfig (do *NOT* increment anything in here for changes
# to other kernel configs!)
PR_CONFIG = "1"
#
# Increment the number below (i.e. the digits after PR) when
# making changes within this file or for changes to the patches
# applied to the kernel.
PR = "r2.${PR_CONFIG}"

include ixp4xx-kernel.inc

SRC_URI += "http://svn.nslu2-linux.org/svnroot/kernel/trunk/patches/2.6.17/defconfig"

# IXP4XX_PATCHES - full list of patches to apply
IXP4XX_PATCHES  = ""

SVN_SRC = "http://svn.nslu2-linux.org/svnroot/kernel/trunk/patches/2.6.17"

# IXP4XX_PATCHES += "file://06-remove-extraversion.patch;patch=1"
IXP4XX_PATCHES += "${SVN_SRC}/01-nas100d-leds.patch;patch=1"
IXP4XX_PATCHES += "${SVN_SRC}/02-nas100d-mac-addr.patch;patch=1"
IXP4XX_PATCHES += "${SVN_SRC}/03-nslu2-leds.patch;patch=1"
IXP4XX_PATCHES += "${SVN_SRC}/04-nslu2-mac-addr.patch;patch=1"
IXP4XX_PATCHES += "${SVN_SRC}/05-timer-ixp4xx.patch;patch=1"
IXP4XX_PATCHES += "${SVN_SRC}/06-timer-nslu2.patch;patch=1"
IXP4XX_PATCHES += "${SVN_SRC}/07-copypage-xscale.patch;patch=1"
IXP4XX_PATCHES += "${SVN_SRC}/15-jffs2-endian-config.patch;patch=1"
IXP4XX_PATCHES += "${SVN_SRC}/20-nas100d-cmdline-fixup.patch;patch=1"
IXP4XX_PATCHES += "${SVN_SRC}/20-nslu2-cmdline-fixup.patch;patch=1"
IXP4XX_PATCHES += "${SVN_SRC}/50-leds-arm-cpu-activity.patch;patch=1"
IXP4XX_PATCHES += "${SVN_SRC}/75-dsmg600.patch;patch=1"
IXP4XX_PATCHES += "${SVN_SRC}/76-dsmg600-pwrbtn.patch;patch=1"
