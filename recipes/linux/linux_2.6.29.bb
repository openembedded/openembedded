require linux.inc

PR = "r2"

S = "${WORKDIR}/linux-2.6.29"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_boc01 = "1"
DEFAULT_PREFERENCE_canyonlands = "1"
DEFAULT_PREFERENCE_tosa = "1"
DEFAULT_PREFERENCE_vortex86sx = "1"
DEFAULT_PREFERENCE_atngw100 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.29.tar.bz2 \
           file://defconfig"

SRC_URI_append_boc01 = "\
	file://boc01.dts \
	file://001-090114-sqn11x0-usb-hack.patch;patch=1 \
	file://004-081205-usb.patch;patch=1 \
	file://005-090226-isl12024.patch;patch=1 \
	file://007-081217-lm73.patch;patch=1 \
	file://008-081208-spi.patch;patch=1 \
	file://011-090115-gpio.patch;patch=1 \
	file://012-090219-capsense.patch;patch=1 \
	file://013-090306-lcd.patch;patch=1 \
	"

SRC_URI_append_canyonlands = " \
        file://0001-powerpc-4xx-Add-PPC4xx-PCIe-MSI-support.patch;patch=1 \
        "

SRC_URI_append_tosa = " \
        file://0001-pxa-make-second-argument-of-clk_add_alias-a-name-in.patch;patch=1 \
        file://0002-spi-pxa2xx-spi-set-default-cs_control-to-null_cs_co.patch;patch=1 \
        "
