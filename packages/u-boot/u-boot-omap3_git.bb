require u-boot.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/u-boot-omap3-git/${MACHINE}"

SRCREV = "c492706ba046124333323273f6fc21123360cb50"

PV = "2008.10-rc1+${PR}+git${SRCREV}"
PR ="r1"

SRC_URI = "git://www.sakoman.net/git/u-boot-omap3.git;branch=common;protocol=git \
          "

UBOOT_MACHINE_beagleboard = "omap3_beagle_config"
UBOOT_MACHINE_omap3evm = "omap3_evm_config"
UBOOT_MACHINE_overo = "omap3_overo_config"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
