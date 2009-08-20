require u-boot.inc
PR ="r29"

FILESPATHPKG =. "u-boot-git:"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "
SRCREV_davinci-sffsdr = "4b50cd12a3b3c644153c4cf393f4a4c12289e5aa"
SRCREV_akita = "9bf86baaa3b35b25baa2d664e2f7f6cafad689ee"
SRCREV_spitz = "9bf86baaa3b35b25baa2d664e2f7f6cafad689ee"
SRCREV_c7x0 = "9bf86baaa3b35b25baa2d664e2f7f6cafad689ee"
SRCREV_afeb9260 = "6b8edfde22acc574b5532e9f086e6a7287a9bc78"
SRCREV_afeb9260-180 = "6b8edfde22acc574b5532e9f086e6a7287a9bc78"
SRC_URI_append_afeb9260 = " file://AFEB9260-network-fix.patch;patch=1"
SRC_URI_append_afeb9260-180 = " file://AFEB9260-network-fix.patch;patch=1"

SRC_URI_beagleboard = "git://gitorious.org/u-boot-omap3/mainline.git;branch=omap3-dev;protocol=git \
                 file://fw-env.patch;patch=1 \
                 file://dss2.patch;patch=1 \
                 file://new-pinmux.patch;patch=1 \
"
SRCREV_beagleboard = "d363f9cb0918a1b6b92e2e20d01543d0c4f53274"
PV_beagleboard = "2009.05+${PR}+gitr${SRCREV}"

SRC_URI_omap3evm = "git://gitorious.org/u-boot-omap3/mainline.git;branch=omap3-dev;protocol=git"
SRCREV_omap3evm = "2dea1db2a3b7c12ed70bbf8ee50755089c5e5170"
PV_omap3evm = "2009.03+${PR}+gitr${SRCREV}"

SRC_URI_omapzoom = "git://www.sakoman.net/git/u-boot-omap3.git;branch=omap3-dev;protocol=git"
SRCREV_omapzoom = "d691b424f1f5bf7eea3a4131dfc578d272e8f335"
PV_omapzoom = "2009.01+${PR}+gitr${SRCREV}"

SRCREV_omapzoom2 = "3672cd5c3b53d219d33345eebad4e25ad5bf6d52"
PV_omapzoom2 = "2009.05+${PR}+gitr${SRCREV}"

SRC_URI_overo = "git://gitorious.org/u-boot-omap3/mainline.git;branch=omap3-dev;protocol=git \
                 file://fw-env.patch;patch=1 \
                 file://dss2.patch;patch=1 \
"
SRCREV_overo = "2dea1db2a3b7c12ed70bbf8ee50755089c5e5170"
PV_overo = "2009.03+${PR}+gitr${SRCREV}"

SRC_URI_dm6446-evm = "git://arago-project.org/git/people/sandeep/u-boot-davinci.git;protocol=git"
SRCREV_dm6446-evm = "fa6ec6e75eeec4fa1543cc4452e11707758540a2"
PV_dm6446-evm = "2009.05+2009.06-rc0+${PR}+gitr${SRCREV}"

SRC_URI_dm6467-evm = "git://arago-project.org/git/people/sandeep/u-boot-davinci.git;protocol=git"
SRCREV_dm6467-evm = "fa6ec6e75eeec4fa1543cc4452e11707758540a2"
PV_dm6467-evm = "2009.05+2009.06-rc0+${PR}+gitr${SRCREV}"

SRC_URI_dm355-evm = "git://arago-project.org/git/people/sandeep/u-boot-davinci.git;protocol=git"
SRCREV_dm355-evm = "fa6ec6e75eeec4fa1543cc4452e11707758540a2"
PV_dm355-evm = "2009.05+2009.06-rc0+${PR}+gitr${SRCREV}"

SRC_URI_dm365-evm = "git://arago-project.org/git/people/sandeep/u-boot-davinci.git;protocol=git"
SRCREV_dm365-evm = "fa6ec6e75eeec4fa1543cc4452e11707758540a2"
PV_dm365-evm = "2009.05+2009.06-rc0+${PR}+gitr${SRCREV}"

SRC_URI_dm355-leopard = "git://www.denx.de/git/u-boot-arm.git;protocol=git;branch=next \
                        file://leopardboard-support.patch;patch=1 \
"
SRCREV_dm355-leopard = "86d5c98d3d97d631b1d3a5f5e6a17e87c99b42cf"
PV_dm355-leopard = "2009.05+2009.06-rc2+gitr${SRCREV}"

SRC_URI_neuros-osd2 = "git://github.com/neuros/u-boot.git;protocol=git;branch=neuros"
SRCREV_neuros-osd2 = "8de979d346624c0e4cfe2e5c0f08ce20ca4b5d14"

SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git"
SRCREV_sequoa = "cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "
SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git;tag=cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093 "

SRC_URI_mini2440 = "git://repo.or.cz/u-boot-openmoko/mini2440.git;protocol=git;branch=dev-mini2440-stable"
SRCREV_mini2440 = "3516c35fb777ca959e5cadf2156a792ca10e1cff"

SRC_URI_micro2440 = "git://repo.or.cz/u-boot-openmoko/mini2440.git;protocol=git;branch=dev-mini2440-stable"
SRCREV_micro2440 = "3516c35fb777ca959e5cadf2156a792ca10e1cff"

SRC_URI_neuros-osd2 += "file://Makefile-fix.patch;patch=1"
SRC_URI_append_akita = "file://pdaXrom-u-boot.patch;patch=1 \
                        file://uboot-eabi-fix-HACK2.patch;patch=1 \
                        file://akita-standard-partitioning.patch;patch=1 \
                       "
SRC_URI_append_spitz = "file://pdaXrom-u-boot.patch;patch=1 \
                        file://uboot-eabi-fix-HACK2.patch;patch=1 \
                        file://spitz-standard-partitioning.patch;patch=1 \
                       "
SRC_URI_append_c7x0 = "file://pdaXrom-u-boot.patch;patch=1 \
                       file://uboot-eabi-fix-HACK2.patch;patch=1 \
                       file://corgi-standard-partitioning.patch;patch=1 \
                       "
S = "${WORKDIR}/git"


do_configure_prepend_akita() {
        sed -i s:ROOT_FLASH_SIZE:${ROOT_FLASH_SIZE}:g ${S}/include/configs/akita.h
}

do_configure_prepend_spitz() {
        sed -i s:ROOT_FLASH_SIZE:${ROOT_FLASH_SIZE}:g ${S}/include/configs/akita.h
}

do_configure_prepend_c7x0() {
        sed -i s:ROOT_FLASH_SIZE:${ROOT_FLASH_SIZE}:g ${S}/include/configs/corgi.h
}

do_deploy_prepend_mini2440() {
	cp ${S}/u-boot-nand16k.bin ${S}/u-boot.bin
}

do_deploy_prepend_micro2440() {
	cp ${S}/u-boot-nand16k.bin ${S}/u-boot.bin
}
