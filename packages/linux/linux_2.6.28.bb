require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

DEFAULT_PREFERENCE_at91sam9263ek = "28"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.28.tar.bz2 \
           file://defconfig"

SRC_URI_append_at91sam9263ek = " \
           file://linux-2.6.28-at91.patch.bz2;patch=1 \
	   file://linux-2.6.28-exp.patch.bz2;patch=1 "
