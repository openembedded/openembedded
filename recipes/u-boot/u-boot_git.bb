require u-boot.inc
PR = "r75"

FILESPATHPKG =. "u-boot-git:"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "
SRCREV_davinci-sffsdr = "4b50cd12a3b3c644153c4cf393f4a4c12289e5aa"
SRCREV_akita = "9bf86baaa3b35b25baa2d664e2f7f6cafad689ee"
SRCREV_spitz = "9bf86baaa3b35b25baa2d664e2f7f6cafad689ee"
SRCREV_c7x0 = "9bf86baaa3b35b25baa2d664e2f7f6cafad689ee"
SRCREV_afeb9260 = "6b8edfde22acc574b5532e9f086e6a7287a9bc78"
SRCREV_afeb9260-180 = "6b8edfde22acc574b5532e9f086e6a7287a9bc78"
SRCREV_palmpre = "668a6b45915d10d75357f5b93f569bbf49ea2b06"
SRCREV_cm-t35 = "3c014f1586d5bfe30dca7549396915c83f31cd30"
SRCREV_mpc8544ds = "f20393c5e787b3776c179d20f82a86bda124d651"
SRCREV_mpc8641-hpcn = "f20393c5e787b3776c179d20f82a86bda124d651"
SRCREV_p1020rdb = "f20393c5e787b3776c179d20f82a86bda124d651"
SRCREV_p2020rdb = "f20393c5e787b3776c179d20f82a86bda124d651"
SRCREV_p2020ds = "f20393c5e787b3776c179d20f82a86bda124d651"
SRCREV_bug20 = "169a4c804dbaf11facb041b1333d394c6ceb8d68"
SRCREV_nokia900 = "bd2313078114c4b44c4a5ce149af43bcb7fc8854"
SRC_URI_append_afeb9260 = " file://AFEB9260-network-fix.patch"
SRC_URI_append_afeb9260-180 = " file://AFEB9260-network-fix.patch"
SRC_URI_append_cm-t35 = "file://cm-t35/cm-t35.patch"
SRC_URI_append_bug20 = "file://bug-uboot.patch"
SRC_URI_append_bug20 += "file://bug-video-setting.patch"

SRC_URI_beagleboard = "git://www.denx.de/git/u-boot.git;protocol=git \
                       file://0001-OMAP3-Beagle-Pin-Mux-initialization-glitch-fix.patch \
                       file://0002-OMAP-Remove-omapfb.debug-y-from-Beagle-and-Overo-env.patch \
                       file://0003-omap3_beagle-enable-the-use-of-a-plain-text-file-nam.patch \
                       file://0004-OMAP3-BeagleBoard-Enable-pullups-on-i2c2.patch \
                       file://0005-ARMV7-OMAP3-BeagleBoard-add-xM-rev-B-to-ID-table.patch \
                       file://0006-OMAP3-BeagleBoard-add-more-expansionboard-IDs.patch \
                       file://0007-OMAP3-Add-DSS-driver-for-OMAP3.patch \
                       file://0008-BeagleBoard-Added-userbutton-command.patch \
                       file://0009-OMAP3-beagle-pass-expansionboard-name-in-bootargs.patch \
                       file://0010-Enable-DSS-driver-for-Beagle.patch \
                       file://0011-Add-led-command.patch \
                       file://0012-BeagleBoard-Added-LED-driver.patch \
                       file://0013-OMAP3-BeagleBoard-updated-default-configuration.patch \
                       file://0014-Corrected-LED-name-match-finding-avoiding-extraneous.patch \
                       file://0016-BeagleBoard-Load-kernel-via-MMC-ext2-not-fat.patch \
		       file://0017-BeagleBoard-add-xM-rev-C-to-ID-table.patch \
                       file://fw_env.config \
"
SRCREV_beagleboard = "c7977858dcf1f656cbe91ea0dc3cb9139c6a8cc8"
PV_beagleboard = "2011.02+${PR}+gitr${SRCREV}"

SRCREV_calamari = "b80d30546e88c70985094d81297d449b2bc59033"

PV_calamari = "2010.06+${PR}+gitr${SRCREV}"
SRC_URI_calamari = " \
        git://git.denx.de/u-boot-mpc85xx.git;protocol=git \
	    file://fsl-esdhc.patch \
        "

# calamari has different u-boot versions for nor, nand, sdcard and spiflash
# build them all
do_compile_calamari () {
        unset LDFLAGS
        unset CFLAGS
        unset CPPFLAGS
        oe_runmake MPC8536DS_config
        oe_runmake all
        mv u-boot.bin u-boot-nor.bin
        oe_runmake clean
        oe_runmake MPC8536DS_NAND_config
        oe_runmake all
        mv u-boot.bin u-boot-nand.bin
        oe_runmake clean
        oe_runmake MPC8536DS_SDCARD_config
        oe_runmake all
        mv u-boot.bin u-boot-sdcard.bin
        oe_runmake clean
        oe_runmake MPC8536DS_SPIFLASH_config
        oe_runmake all
        mv u-boot.bin u-boot-spiflash.bin
	oe_runmake tools env HOSTCC="${CC}"
}

do_deploy_calamari () {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 ${S}/u-boot-nor.bin ${DEPLOY_DIR_IMAGE}/u-boot-nor.bin
        install -m 0644 ${S}/u-boot-nand.bin ${DEPLOY_DIR_IMAGE}/u-boot-nand.bin
        install -m 0644 ${S}/u-boot-sdcard.bin ${DEPLOY_DIR_IMAGE}/u-boot-sdcard.bin
        install -m 0644 ${S}/u-boot-spiflash.bin ${DEPLOY_DIR_IMAGE}/u-boot-spiflash.bin
        install -m 0755 tools/mkimage ${STAGING_BINDIR_NATIVE}/uboot-mkimage
}

do_install_calamari () {
	install -d ${D}/boot
	install ${S}/u-boot-nor.bin ${D}/boot/u-boot-nor.bin
	install ${S}/u-boot-nand.bin ${D}/boot/u-boot-nand.bin
	install ${S}/u-boot-sdcard.bin ${D}/boot/u-boot-sdcard.bin
	install ${S}/u-boot-spiflash.bin ${D}/boot/u-boot-spiflash.bin
	ln -sf ${UBOOT_IMAGE} ${D}/boot/${UBOOT_BINARY}

	install -d ${D}${base_sbindir}
	install -d ${D}${sysconfdir}
	install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_printenv
	install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_setenv
}
SRC_URI_omap3-touchbook = "git://gitorious.org/u-boot-omap3/mainline.git;branch=omap3-dev;protocol=git \
                 file://fw_env.config \
                 file://dss2.patch \
                 file://600mhz.patch \
                 file://new-pinmux.patch \
                 file://spi3.patch \
                 file://spi4.patch \
                 file://headphone.patch \
                 file://power.patch \
                 file://ai-logo.patch \
                 file://mmcinit.patch \
                 file://touchbook-config.patch \
"
SRCREV_omap3-touchbook = "d363f9cb0918a1b6b92e2e20d01543d0c4f53274"
PV_omap3-touchbook = "2009.05+${PR}+gitr${SRCREV}"

# ~ TI PSP v2009.11_OMAPPSP_03.00.01.06 (+ couple of commits)
SRC_URI_omap3evm = "git://arago-project.org/git/projects/u-boot-omap3.git;protocol=git \
	file://0001-omap3evm-Change-default-console-serial-port-from.patch \
"
SRCREV_omap3evm = "c0a8fb217fdca7888d89f9a3dee74a4cec865620"
PV_omap3evm = "2009.11+${PR}+gitr${SRCREV}"

# ~ TI PSP v2009.11_OMAPPSP_03.00.01.06 (+ couple of commits)
SRC_URI_dm37x-evm = "git://arago-project.org/git/projects/u-boot-omap3.git;protocol=git \
	file://0001-omap3evm-Change-default-console-serial-port-from.patch \
"
SRCREV_dm37x-evm = "c0a8fb217fdca7888d89f9a3dee74a4cec865620"
PV_dm37x-evm = "2009.11+${PR}+gitr${SRCREV}"

# ~ TI PSP v2009.11_OMAPPSP_03.00.01.06 (+ couple of commits)
SRC_URI_am3517-crane = "git://arago-project.org/git/projects/u-boot-omap3.git;protocol=git \
                        file://0001-Added-Support-for-AM3517-05-based-CraneBoard.patch \
                        file://0001-OMAP2-3-I2C-Add-support-for-second-and-third-bus.patch \
                        file://0002-ARMV7-Restructure-OMAP-i2c-driver-to-allow-code-shar.patch \
                        file://0003-craneboard-add-expansionboard-support.patch \
"

SRCREV_am3517-crane = "c0a8fb217fdca7888d89f9a3dee74a4cec865620"
PV_am3517-crane = "2009.11+${PR}+gitr${SRCREV}"

# ~ TI PSP v2009.11_OMAPPSP_03.00.01.06 (+ couple of commits)
SRC_URI_am37x-evm = "git://arago-project.org/git/projects/u-boot-omap3.git;protocol=git \
	file://0001-omap3evm-Change-default-console-serial-port-from.patch \
"
SRCREV_am37x-evm = "c0a8fb217fdca7888d89f9a3dee74a4cec865620"
PV_am37x-evm = "2009.11+${PR}+gitr${SRCREV}"

# ~ TI PSP v2009.11_OMAPPSP_03.00.01.06 (+ couple of commits)
SRC_URI_am3517-evm = "git://arago-project.org/git/projects/u-boot-omap3.git;protocol=git"
SRCREV_am3517-evm = "c0a8fb217fdca7888d89f9a3dee74a4cec865620"
PV_am3517-evm = "2009.11+${PR}+gitr${SRCREV}"

SRC_URI_omapzoom = "git://www.sakoman.net/git/u-boot-omap3.git;branch=omap3-dev;protocol=git"
SRCREV_omapzoom = "d691b424f1f5bf7eea3a4131dfc578d272e8f335"
PV_omapzoom = "2009.01+${PR}+gitr${SRCREV}"

SRC_URI_omapzoom2 = "git://dev.omapzoom.org/pub/scm/bootloader/u-boot.git;branch=master;protocol=git \
                     file://0001-OMAP3-set-L1NEON-bit-in-aux-control-register.patch \
                     file://fix-default-boot.patch \
                    "

SRCREV_omapzoom2 = "fbe4cef852de5a39412234b4acd47a830d0282a2"
PV_omapzoom2 = "1.1.4+${PR}+gitr${SRCREV}"
PE_omapzoom2 = "1"

do_compile_omapzoom2 () {
	sed -i -e "s|OPTFLAGS=.*|OPTFLAGS=|" config.mk
        unset LDFLAGS
        unset CFLAGS
        unset CPPFLAGS
        oe_runmake ${UBOOT_MACHINE}
        oe_runmake all
        oe_runmake tools
}

SRC_URI_omapzoom36x = "git://dev.omapzoom.org/pub/scm/bootloader/u-boot.git;branch=master;protocol=git \
                       file://0001-OMAP3-set-L1NEON-bit-in-aux-control-register.patch \
                       file://fix-default-boot.patch \
                      "

SRCREV_omapzoom36x = "fbe4cef852de5a39412234b4acd47a830d0282a2"
PV_omapzoom36x = "1.1.4+${PR}+gitr${SRCREV}"
PE_omapzoom36x = "1"

do_compile_omapzoom36x () {
	sed -i -e "s|OPTFLAGS=.*|OPTFLAGS=|" config.mk
        unset LDFLAGS
        unset CFLAGS
        unset CPPFLAGS
        oe_runmake ${UBOOT_MACHINE}
        oe_runmake all
        oe_runmake tools
}

SRC_URI_overo = "git://www.sakoman.com/git/u-boot.git;branch=omap4-exp;protocol=git \
"
SRCREV_overo = "261733408a27d14590cf3ec6b596461808050e32"
PV_overo = "2010.12+${PR}+gitr${SRCREV}"

SRC_URI_omap4430-panda = "git://www.sakoman.com/git/u-boot.git;branch=omap4-exp;protocol=git \
                          file://fix-break-caused-by-new-binutils.patch \
                         "
SRCREV_omap4430-panda  = "261733408a27d14590cf3ec6b596461808050e32"
PV_omap4430-panda      = "2010.12+${PR}+git${SRCREV}"
PE_omap4430-panda      = "1"

SRC_URI_am45x-evm = "git://www.sakoman.com/git/u-boot.git;branch=omap4-exp;protocol=git \
                          file://fix-break-caused-by-new-binutils.patch \
                         "
SRCREV_am45x-evm  = "261733408a27d14590cf3ec6b596461808050e32"
PV_am45x-evm      = "2010.12+${PR}+git${SRCREV}"
PE_am45x-evm      = "1"

# DaVinci dm355-evm/dm365-evm/dm6446-evm/dm6467-evm/dm6467t-evm - PSP 3.1.0/3.2.0 (build 35)

SRC_URI_dm355-evm    = "git://arago-project.org/git/projects/u-boot-davinci.git;protocol=git;branch=u-boot-davinci-2009.06"
SRCREV_dm355-evm     = "ea7387c9511ac92a46d3d147adffe36f868820e4"
PV_dm355-evm         = "2009.05+2009.06-rc0+${PR}+gitr${SRCREV}"
PE_dm355-evm         = "1"

# Use this for both dm365-evm and dm368-evm devices by using the dm365
# SOC_FAMILY
SRC_URI_dm365    = "git://arago-project.org/git/projects/u-boot-davinci.git;protocol=git;branch=u-boot-davinci-2009.06"
SRCREV_dm365     = "ea7387c9511ac92a46d3d147adffe36f868820e4"
PV_dm365         = "2009.05+2009.06-rc0+${PR}+gitr${SRCREV}"
PE_dm365         = "1"

SRC_URI_dm6446-evm   = "git://arago-project.org/git/projects/u-boot-davinci.git;protocol=git;branch=u-boot-davinci-2009.06"
SRCREV_dm6446-evm    = "ea7387c9511ac92a46d3d147adffe36f868820e4"
PV_dm6446-evm        = "2009.05+2009.06-rc0+${PR}+gitr${SRCREV}"
PE_dm6446-evm        = "1"

SRC_URI_dm6467-evm   = "git://arago-project.org/git/projects/u-boot-dm646x.git;protocol=git"
SRCREV_dm6467-evm    = "98b31e3aae3e3fb772f8d06c18ccdd6265aa0d38"
PV_dm6467-evm        = "2009.08+${PR}+gitr${SRCREV}"

SRC_URI_dm6467t-evm  = "git://arago-project.org/git/projects/u-boot-dm646x.git;protocol=git"
SRCREV_dm6467t-evm   = "98b31e3aae3e3fb772f8d06c18ccdd6265aa0d38"
PV_dm6467t-evm       = "2009.08+${PR}+gitr${SRCREV}"

# OMAPL1 omapl137/omapl138 - PSP 3.20.0.11

SRC_URI_omapl137 = "git://arago-project.org/git/projects/u-boot-omapl1.git;protocol=git"
SRCREV_omapl137  = "5f16b8551b125f16cd8d58f278cb25b94272fd9f"
PV_omapl137      = "2009.11+${PR}+gitr${SRCREV}"

SRC_URI_omapl138 = "git://arago-project.org/git/projects/u-boot-omapl1.git;protocol=git"
SRCREV_omapl138  = "5f16b8551b125f16cd8d58f278cb25b94272fd9f"
PV_omapl138      = "2009.11+${PR}+gitr${SRCREV}"

# hawkboard - master branch (hawk still .07beta)

SRC_URI_hawkboard          = "git://arago-project.org/git/people/sekhar/u-boot-omapl1.git;protocol=git;branch=master"
SRC_URI_hawkboard         += "file://dont-inline-weak-symbols.patch"
SRCREV_hawkboard           = "0d291f2f255e6d66a78b3dc2445362a96ae39a57"
PV_hawkboard               = "2009.08+gitr${SRCREV}"

SRC_URI_dm355-leopard = "git://www.denx.de/git/u-boot-arm.git;protocol=git;branch=master \
"
SRCREV_dm355-leopard = "d650da2dd4af99967aabc43cccbd8f160eb4cea6"
PV_dm355-leopard = "2009.05+2010.03-rc1+gitr${SRCREV}"

SRC_URI_neuros-osd2 = "git://github.com/neuros/u-boot.git;protocol=git;branch=neuros"
SRCREV_neuros-osd2 = "8de979d346624c0e4cfe2e5c0f08ce20ca4b5d14"

SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git"
SRCREV_sequoa = "cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093"

SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git;tag=cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093 "

SRC_URI_mini2440 = "git://repo.or.cz/u-boot-openmoko/mini2440.git;protocol=git;branch=dev-mini2440-stable"
SRC_URI_mini2440 += "file://dont-inline-weak-symbols-mini2440.patch"
SRCREV_mini2440 = "3516c35fb777ca959e5cadf2156a792ca10e1cff"

SRC_URI_micro2440 = "git://repo.or.cz/u-boot-openmoko/mini2440.git;protocol=git;branch=dev-mini2440-stable"
SRCREV_micro2440 = "3516c35fb777ca959e5cadf2156a792ca10e1cff"

SRC_URI_neuros-osd2 += "file://Makefile-fix.patch"
SRC_URI_append_akita = "file://pdaXrom-u-boot.patch \
                        file://uboot-eabi-fix-HACK2.patch \
                        file://akita-standard-partitioning.patch \
                       "
SRC_URI_append_spitz = "file://pdaXrom-u-boot.patch \
                        file://uboot-eabi-fix-HACK2.patch \
                        file://spitz-standard-partitioning.patch \
                       "
SRC_URI_append_c7x0 = "file://pdaXrom-u-boot.patch \
                       file://uboot-eabi-fix-HACK2.patch \
                       file://corgi-standard-partitioning.patch \
                       "
SRC_URI_sheevaplug = "git://git.denx.de/u-boot-marvell.git;protocol=git;branch=master"
SRCREV_sheevaplug = "749c971873dbba301bd138c95d31223a25b32150"

SRC_URI_xilinx-ml507 = "git://git.xilinx.com/u-boot-xlnx.git;protocol=git"
SRCREV_xilinx-ml507 = "26e999650cf77c16f33c580abaadab2532f5e8b2"

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

do_compile_append_sheevaplug() {
	oe_runmake u-boot.kwb
}

UBOOT_IMAGE_sheevaplug = "u-boot-${MACHINE}-${PV}-${PR}.kwb"
UBOOT_BINARY_sheevaplug = "u-boot.kwb"
UBOOT_SYMLINK_sheevaplug ?= "u-boot-${MACHINE}.kwb"

do_deploy_prepend_mini2440() {
	cp ${S}/u-boot-nand16k.bin ${S}/u-boot.bin
}

do_deploy_prepend_micro2440() {
	cp ${S}/u-boot-nand16k.bin ${S}/u-boot.bin
}

do_configure_prepend_xilinx-ml507() {
if [ -e "${XILINX_BSP_PATH}/ppc440_0/include/xparameters.h" ]; then
    cp ${XILINX_BSP_PATH}/ppc440_0/include/xparameters.h \
    ${S}/board/xilinx/ml507
    echo "#define XPAR_PLB_CLOCK_FREQ_HZ XPAR_CPU_PPC440_MPLB_FREQ_HZ
#define XPAR_CORE_CLOCK_FREQ_HZ XPAR_CPU_PPC440_CORE_CLOCK_FREQ_HZ
#define XPAR_PCI_0_CLOCK_FREQ_HZ    0" >> ${S}/board/xilinx/ml507/xparameters.h
fi
}

do_deploy_prepend_xilinx-ml507() {
if [ -d "${XILINX_BSP_PATH}" ]; then
    install ${S}/u-boot ${XILINX_BSP_PATH}
fi
}

PV_nokia900 = "2010.06+gitr${SRCPV}"
SRC_URI_nokia900 = "git://www.denx.de/git/u-boot.git;protocol=git \
                    file://0001-ARM-Avoid-compiler-optimization-for-usages-of-readb-.patch \
                    file://0001-Reduce-delays-in-omap-i2c-driver.patch \
                    file://0002-Make-bootm-optionally-use-pre-existing-atags-for-Lin.patch \
                    file://0003-Store-existing-atags-at-startup-if-chainloading.patch \
                    file://0004-Nokia-RX-51-aka-N900-support.patch \
                    file://0001-nokia-rx51-fix-declaration-fails-when-building-with-.patch \
                    file://0005-fix-loading-file-from-ext2-partition-on-OMAP3-evm.patch \
                    file://0006-omap3_mmc.c-fix-formating.patch \
                    file://0007-Only-delay-boot-if-keyboard-open.patch \
"
SRC_URI_nokia900_append_shr = " \
                    file://0001-configs-nokia_rx51.h-start-shr-as-default-and-change.patch \
"

UBOOT_MACHINE_nokia900 = "nokia_rx51_config"
