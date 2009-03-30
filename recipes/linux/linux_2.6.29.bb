require linux.inc

S = "${WORKDIR}/linux-2.6.29"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_tosa = "1"
DEFAULT_PREFERENCE_vortex86sx = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.29.tar.bz2 \
           file://defconfig"

SRC_URI_append_tosa = " \
	file://0001-pxa-make-second-argument-of-clk_add_alias-a-name-in.patch;patch=1 \
	file://0002-spi-pxa2xx-spi-set-default-cs_control-to-null_cs_co.patch;patch=1 \
	"

