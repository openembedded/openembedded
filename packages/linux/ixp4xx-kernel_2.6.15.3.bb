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

RPSRC = "http://www.rpsys.net/openzaurus/patches"

# IXP4XX_PATCHES - full list of patches to apply
IXP4XX_PATCHES  = ""

IXP4XX_PATCHES += "file://00-memory-h-page-shift.patch;patch=1"
IXP4XX_PATCHES += "file://10-mtdpart-redboot-fis-byteswap.patch;patch=1"
IXP4XX_PATCHES += "file://11-mtdpart-redboot-config-byteswap.patch;patch=1"
IXP4XX_PATCHES += "file://15-jffs2-endian-config.patch;patch=1"
IXP4XX_PATCHES += "${RPSRC}/led_core-r11.patch;patch=1"
IXP4XX_PATCHES += "${RPSRC}/led_triggers-r9.patch;patch=1"
IXP4XX_PATCHES += "${RPSRC}/led_trig_timer-r4.patch;patch=1"
# IXP4XX_PATCHES += "${RPSRC}/led_trig_sharpsl_pm-r4a.patch;patch=1"
IXP4XX_PATCHES += "${RPSRC}/led_zaurus-r8.patch;patch=1"
IXP4XX_PATCHES += "${RPSRC}/led_locomo-r5.patch;patch=1"
IXP4XX_PATCHES += "${RPSRC}/led_ixp4xx-r0.patch;patch=1"
IXP4XX_PATCHES += "${RPSRC}/led_tosa-r3.patch;patch=1"
IXP4XX_PATCHES += "${RPSRC}/led_ide-r2.patch;patch=1"
IXP4XX_PATCHES += "${RPSRC}/led_nand-r2.patch;patch=1"
IXP4XX_PATCHES += "file://950-leds-timer.patch;patch=1"
IXP4XX_PATCHES += "file://951-ixp4xx-leds-cpu-activity.patch;patch=1"
IXP4XX_PATCHES += "file://40-rtc-class.patch;patch=1"
IXP4XX_PATCHES += "file://45-eeprom-notifier.patch;patch=1"
IXP4XX_PATCHES += "file://48-setup-byteswap-cmdline.patch;patch=1"
IXP4XX_PATCHES += "file://50-nas100d-arch.patch;patch=1"
# IXP4XX_PATCHES += "file://55-rtc-pcf8563.patch;patch=1"
# IXP4XX_PATCHES += "file://60-nas100d-i2c.patch;patch=1"
# IXP4XX_PATCHES += "file://60-nas100d-ide.patch;patch=1"
# IXP4XX_PATCHES += "file://60-nas100d-rtc.patch;patch=1"
IXP4XX_PATCHES += "file://60-ixp4xx-beeper.patch;patch=1"
IXP4XX_PATCHES += "file://65-loft-config.patch;patch=1"
IXP4XX_PATCHES += "file://81-nslu2-power.patch;patch=1"
IXP4XX_PATCHES += "file://82-nas100d-power.patch;patch=1"
IXP4XX_PATCHES += "file://85-timer.patch;patch=1"
IXP4XX_PATCHES += "file://91-maclist.patch;patch=1"
IXP4XX_PATCHES += "file://92-nas100d-maclist.patch;patch=1"
IXP4XX_PATCHES += "file://92-nslu2-maclist.patch;patch=1"
IXP4XX_PATCHES += "file://93-loft-maclist.patch;patch=1"
IXP4XX_PATCHES += "file://94-nas100d-setup.patch;patch=1"
IXP4XX_PATCHES += "file://94-nslu2-setup.patch;patch=1"
IXP4XX_PATCHES += "file://96-loft-leds.patch;patch=1"
IXP4XX_PATCHES += "file://96-nas100d-leds.patch;patch=1"
IXP4XX_PATCHES += "file://96-nslu2-leds.patch;patch=1"
