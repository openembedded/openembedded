require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_alix = "1"
DEFAULT_PREFERENCE_avr32 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.22.tar.bz2 \
           file://defconfig \
	   "

SRC_URI_append_avr32 = "http://avr32linux.org/twiki/pub/Main/LinuxPatches/linux-2.6.22.atmel.3.patch.bz2;patch=1"
