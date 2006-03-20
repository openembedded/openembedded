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
PR = "r0.${PR_CONFIG}"

include ixp4xx-kernel.inc

# RPSRC = "http://www.rpsys.net/openzaurus/patches"

# IXP4XX_PATCHES - full list of patches to apply
IXP4XX_PATCHES  = ""

IXP4XX_PATCHES += "file://patch-2.6.16-rc6-ide1;patch=1"
IXP4XX_PATCHES += "file://leds-class.patch;patch=1"
# IXP4XX_PATCHES += "file://06-remove-extraversion.patch;patch=1"
IXP4XX_PATCHES += "file://10-ixp4xx-fix-irq.patch;patch=1"
IXP4XX_PATCHES += "file://11-mtdpart-redboot-config-byteswap.patch;patch=1"
IXP4XX_PATCHES += "file://15-jffs2-endian-config.patch;patch=1"
IXP4XX_PATCHES += "file://951-ixp4xx-leds-cpu-activity.patch;patch=1"
IXP4XX_PATCHES += "file://40-rtc-class.patch;patch=1"
IXP4XX_PATCHES += "file://45-eeprom-notifier.patch;patch=1"
IXP4XX_PATCHES += "file://48-setup-byteswap-cmdline.patch;patch=1"
IXP4XX_PATCHES += "file://50-i2c-bus-ixp4xx-hwmon.patch;patch=1"
IXP4XX_PATCHES += "file://50-hwmon-ad741x.patch;patch=1"
IXP4XX_PATCHES += "file://65-loft-config.patch;patch=1"
IXP4XX_PATCHES += "file://75-dsmg600.patch;patch=1"
IXP4XX_PATCHES += "file://83-nas100d-memory-fixup.patch;patch=1"
IXP4XX_PATCHES += "file://84-nas100d-cmdline.patch;patch=1"
IXP4XX_PATCHES += "file://85-timer.patch;patch=1"
IXP4XX_PATCHES += "file://91-maclist.patch;patch=1"
IXP4XX_PATCHES += "file://92-nas100d-maclist.patch;patch=1"
IXP4XX_PATCHES += "file://92-nslu2-maclist.patch;patch=1"
IXP4XX_PATCHES += "file://94-nslu2-setup.patch;patch=1"
IXP4XX_PATCHES += "file://94-loft-setup.patch;patch=1"
IXP4XX_PATCHES += "file://96-pata-ixp4xx.patch;patch=1"
IXP4XX_PATCHES += "file://96-nas100d-leds.patch;patch=1"
IXP4XX_PATCHES += "file://96-nslu2-leds.patch;patch=1"
IXP4XX_PATCHES += "file://97-ds101.patch;patch=1"
IXP4XX_PATCHES += "file://97-ds101-buttons.patch;patch=1"
IXP4XX_PATCHES += "file://97-ds101-doc.patch;patch=1"
