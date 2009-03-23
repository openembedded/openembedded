require u-boot.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/u-boot-omap3-git/${MACHINE}"

SRCREV = "08d7fdcce5dde5c2dc968fac5b2facf17cbabb5"

PV = "2008.10+${PR}+gitr${SRCREV}"
PR ="r2"
PE = "1"

SRC_URI = "git://www.sakoman.net/git/u-boot-omap3.git;branch=common;protocol=git \
          "

UBOOT_MACHINE_beagleboard = "omap3_beagle_config"
UBOOT_MACHINE_omap3evm = "omap3_evm_config"
UBOOT_MACHINE_overo = "omap3_overo_config"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
