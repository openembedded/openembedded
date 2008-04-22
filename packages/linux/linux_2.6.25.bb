require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"
DEFAULT_PREFERENCE_haleakala = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.25.tar.bz2 \
           file://defconfig"

SRC_URI_append_mpc8313e-rdb = "\
	file://mpc831x-nand.patch;patch=1 \
	file://mpc8313e-rdb-leds.patch;patch=1 \
	file://mpc8313e-rdb-cardbus.patch;patch=1 \
	"

