require linux.inc

PR = "r10"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_ion = "1"
DEFAULT_PREFERENCE_simone = "1"
DEFAULT_PREFERENCE_eee701 = "1"
DEFAULT_PREFERENCE_at91sam9g45ek = "1"
DEFAULT_PREFERENCE_sh7785lcr = "1"
DEFAULT_PREFERENCE_ben-nanonote = "-1"
DEFAULT_PREFERENCE_jornada6xx = "-1"
DEFAULT_PREFERENCE_jornada7xx = "-1"
DEFAULT_PREFERENCE_tb5200l = "1"
DEFAULT_PREFERENCE_ts72xx = "-1"
DEFAULT_PREFERENCE_bluepro = "1"
DEFAULT_PREFERENCE_topas910 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.9.bz2;apply=yes;name=stablepatch \
           file://defconfig"

SRC_URI[kernel.md5sum] = "260551284ac224c3a43c4adac7df4879"
SRC_URI[kernel.sha256sum] = "5099786d80b8407d98a619df00209c2353517f22d804fdd9533b362adcb4504e"
SRC_URI[stablepatch.md5sum] = "7f615dd3b4a3b19fb86e479996a2deb5"
SRC_URI[stablepatch.sha256sum] = "8aeb15c31fb09c769f004c8dc51e29aa26be8e84d70db418af70ecefc463459a"

SRC_URI_append_at91sam9g45ek = " \
	file://at91/linux-2.6.32-001-configurable-nand-partitions.patch \
	file://at91/linux-2.6.32-002-sam9g20-proper-reset.patch \
	"


# part of 2.6.24.7 patchset from Sim.One project
# other patches needs work
SRC_URI_append_simone = " \
			file://ep93xx/edb9301-fix-machine-id.patch \
			file://ep93xx/simone-board-def.patch \
			file://ep93xx/ep93xx-regs.patch \
			file://ep93xx/ep93xx-i2c.patch \
			file://ep93xx/ep93xx-touchscreen.patch \
			file://ep93xx/ep93xx-spi.patch \
			file://ep93xx/ep93xx-cpuinfo.patch "

FILES_kernel-image_simone = ""

SRC_URI_append_ts72xx = " \
                        file://0001-ts72xx_base.patch \
                        file://0002-ts72xx_force_machine-id.patch \
                        file://0003-ep93xx_cpuinfo.patch \
                        file://0004-ts72xx_sbcinfo.patch \
                        file://0005-ep93xx_eth.patch \
                        file://0006-ts72xx_ts_ser1.patch \
                        file://0007-ts72xx_rs485.patch \
                        file://0008-ts72xx_ts_eth100.patch \
                        file://0009-ts7200_cf_ide.patch \
                        file://0010-ts72xx_pata.patch \
                        file://0011-ep93xx_pm.patch \
                        file://0012-ts72xx_gpio_i2c.patch \
                        file://0013-ts72xx_dio_keypad.patch \
                        file://0014-ep93xx_spi.patch \
                        file://0015-ep93xx_cpufreq.patch \
                        file://0016-ts7200_nor_flash.patch \
                        "

SRC_URI_append_eee701 = " \
	file://intelfb.patch "

SRC_URI_append_topas910 = " \
	http://github.com/matgnt/linux-2.6/commit/7b8a71c15b44715e3dc08bfa0f9e420b0a567f8b.patch;patch=1;name=topaspatch \
	"

SRC_URI[topaspatch.md5sum] = "5ebdfa95e5f2d96d77d0efaa50b52d62"
SRC_URI[topaspatch.sha256sum] = "6bac75b6e9a84def788190402bb6c203da6b0d56877ed192864806d2dc378225"
