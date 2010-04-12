require linux.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9263ek = "-1"

KERNEL_VERSION = "2.6.22-rc1"
KERNEL_RELEASE = "2.6.22-rc1"

PR = "r2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.21.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.22/patch-2.6.22-rc1.bz2;patch=1;name=patch \
           file://defconfig \
	   "

SRC_URI_append_simpad = "\
           file://linux-2.6.21-SIMpad-cs3-simpad.patch;patch=1 \
           file://linux-2.6.21-SIMpad-mq200.patch;patch=1 \
           file://linux-2.6.21-SIMpad-serial-and-gpio_keys.patch;patch=1 \
           file://linux-2.6.21-SIMpad-ucb1x00-switches.patch;patch=1 \
           file://linux-2.6.21-pcmcia-device-to-platform-driver.patch;patch=1 \
           "
SRC_URI_append_kb9202 = " http://maxim.org.za/AT91RM9200/2.6/2.6.22-rc1-at91.patch.gz;patch=1;name=at91patch \
                          file://at91-mmcfix.patch;patch=1"
SRC_URI_append_at91sam9263ek = " http://maxim.org.za/AT91RM9200/2.6/2.6.22-rc1-at91.patch.gz;patch=1;name=at91patch \
                                 file://at91-mmcfix.patch;patch=1"

S = "${WORKDIR}/linux-2.6.21"



SRC_URI[kernel.md5sum] = "1b515f588078dfa7f4bab2634bd17e80"
SRC_URI[kernel.sha256sum] = "f187b12d70e0a48ce81f0472dfe9504fb5f0f966be339ac9d57dd2b991a74942"
SRC_URI[patch.md5sum] = "9bc06492dce31c87f1cdfa2ce5b0cf4c"
SRC_URI[patch.sha256sum] = "dd33f3e9059bed043194ee5200239f26d3ad607ab5c872e7ce92595c1eb5d0e4"
SRC_URI[at91patch.md5sum] = "2453815aba40e9487d24822d769fbab1"
SRC_URI[at91patch.sha256sum] = "95cec79fb6db261760421c1bb9df8a0f4955e0ee90e08cb9930a4c7a2482c1a6"
