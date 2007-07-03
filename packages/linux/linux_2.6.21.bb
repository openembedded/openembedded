require linux.inc

DEFAULT_PREFERENCE_at91sam9263ek = "-1"

PR = "r4"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig \
	   "

SRC_URI_append_simpad = "\
           file://linux-2.6.21-SIMpad-cs3-simpad.patch;patch=1 \
           file://linux-2.6.21-SIMpad-mq200.patch;patch=1 \
           file://linux-2.6.21-SIMpad-serial-and-gpio_keys.patch;patch=1 \
           file://linux-2.6.21-SIMpad-ucb1x00-switches.patch;patch=1 \
           file://linux-2.6.21-pcmcia-device-to-platform-driver.patch;patch=1 \
           "
SRC_URI_append_kb9202 = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;patch=1 "
SRC_URI_append_at91sam9263ek = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;patch=1 "
SRC_URI_append_sarge-at91 = " http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;patch=1 \
                              file://2.6.21-sarge-kernel.patch;patch=1 \
                              file://2.6.21-sarge-phy.patch;patch=1 \
                              file://2.6.21-sarge-mmc.patch;patch=1"

