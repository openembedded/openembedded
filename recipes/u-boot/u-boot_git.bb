require u-boot.inc
PR ="r42"

FILESPATHPKG =. "u-boot-git:"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "
SRCREV_davinci-sffsdr = "4b50cd12a3b3c644153c4cf393f4a4c12289e5aa"
SRCREV_akita = "9bf86baaa3b35b25baa2d664e2f7f6cafad689ee"
SRCREV_spitz = "9bf86baaa3b35b25baa2d664e2f7f6cafad689ee"
SRCREV_c7x0 = "9bf86baaa3b35b25baa2d664e2f7f6cafad689ee"
SRCREV_afeb9260 = "6b8edfde22acc574b5532e9f086e6a7287a9bc78"
SRCREV_afeb9260-180 = "6b8edfde22acc574b5532e9f086e6a7287a9bc78"
SRCREV_palmpre = "6b8edfde22acc574b5532e9f086e6a7287a9bc78"
SRCREV_cm-t35 = "3c014f1586d5bfe30dca7549396915c83f31cd30"
SRC_URI_append_afeb9260 = " file://AFEB9260-network-fix.patch;patch=1"
SRC_URI_append_afeb9260-180 = " file://AFEB9260-network-fix.patch;patch=1"
SRC_URI_append_cm-t35 = "file://cm-t35/cm-t35.patch;patch=1"

SRC_URI_beagleboard = "git://git.denx.de/u-boot-ti.git;protocol=git \
                 file://fw_env.config \
                 file://new-pinmux.patch;patch=1 \
file://revision-detection.patch;patch=1 \
file://i2c.patch;patch=1 \
file://720MHz.patch;patch=1 \
file://dss.patch;patch=1 \
file://0001-omap3-clock.c-don-t-reprogram-clocks-when-trying-to-.patch;patch=1 \
file://0002-beagleboard-add-pinmuxing-for-beagleboard-XM.patch;patch=1 \
file://0003-beagleboard-move-muxing-into-revision-print-switch.patch;patch=1 \
file://Cortex-A8-erratum-725233.diff;patch=1 \
"

SRCREV_beagleboard = "a5cf522a91ba479d459f8221135bdb3e9ae97479"
PV_beagleboard = "2009.11-rc1+${PR}+gitr${SRCREV}"

SRCREV_calamari = "533cf3a024947aaf74c16573a6d951cd0c3d0a7d"

PV_calamari = "2009.11+${PR}+gitr${SRCREV}"
SRC_URI_calamari = " \
        git://git.denx.de/u-boot-mpc85xx.git;protocol=git \
	file://0002-cmd_itest.c-fix-pointer-dereferencing.patch;patch=1 \
	file://0001-cmd_i2c.c-reduced-subaddress-length-to-3-bytes.patch;patch=1 \
	file://0002-cmd_bootm.c-made-subcommand-array-static.patch;patch=1 \
	file://0003-cmd_i2c.c-reworked-subcommand-handling.patch;patch=1 \
	file://0004-cmd_i2c.c-sorted-commands-alphabetically.patch;patch=1 \
	file://0005-cmd_i2c.c-added-i2c-read-to-memory-function.patch;patch=1 \
	file://0007-cmd_setexpr-allow-memory-addresses-and-env-vars-in-e.patch;patch=1 \
        "

UBOOT_MACHINE_calamari = "MPC8536DS_config"

SRC_URI_omap3-touchbook = "git://gitorious.org/u-boot-omap3/mainline.git;branch=omap3-dev;protocol=git \
                 file://fw_env.config \
                 file://dss2.patch;patch=1 \
                 file://600mhz.patch;patch=1 \
                 file://new-pinmux.patch;patch=1 \
                 file://spi3.patch;patch=1 \
                 file://spi4.patch;patch=1 \
                 file://headphone.patch;patch=1 \
                 file://power.patch;patch=1 \
                 file://ai-logo.patch;patch=1 \
                 file://mmcinit.patch;patch=1 \
                 file://touchbook-config.patch;patch=1 \
"
SRCREV_omap3-touchbook = "d363f9cb0918a1b6b92e2e20d01543d0c4f53274"
PV_omap3-touchbook = "2009.05+${PR}+gitr${SRCREV}"


SRC_URI_omap3evm = "git://gitorious.org/u-boot-omap3/mainline.git;branch=omap3-dev;protocol=git"
SRCREV_omap3evm = "2dea1db2a3b7c12ed70bbf8ee50755089c5e5170"
PV_omap3evm = "2009.03+${PR}+gitr${SRCREV}"


SRCREV_am3517-evm = "e60beb13cf0"
SRC_URI_append_am3517-evm = " \
file://omap3evm/0001-Changes-for-making-a-NAND-build.patch;patch=1 \
file://omap3evm/0002-Fix-for-NFS-boot-for-OMAP3-EVM.patch;patch=1 \
file://omap3evm/0003-OMAP3-timer-handling-to-1ms-tick-and-CONFIG_SYS_HZ-t.patch;patch=1 \
file://omap3evm/0004-Reverse-patch-for-NFS-boot-to-fix-comments-provided.patch;patch=1 \
file://omap3evm/0005-SMC911x-driver-fixed-for-NFS-boot.patch;patch=1 \
file://omap3evm/0006-Added-OMAP3517-3505-support.patch;patch=1 \
file://omap3evm/0007-OMAP3517TEB-validated-on-OMAP3517TEB-board.patch;patch=1 \
file://omap3evm/0008-OMAP3517PRE-ALPHA-validated-on-OMAP3517PRE_ALPHA-bo.patch;patch=1 \
file://omap3evm/0009-OMAP3517PRE-ALPHA-DDR-size-issue-fixed.patch;patch=1 \
file://omap3evm/0010-OMAP3517PRE-ALPHA-Mux-configuration-for-MMC-CD-and.patch;patch=1 \
file://omap3evm/0011-Ethernet-driver-functional-no-need-for-time-delay.patch;patch=1 \
file://omap3evm/0012-EMAC-driver-Implement-GPIO-driven-PHY-reset.patch;patch=1 \
file://omap3evm/0013-Cleaned-up-during-EVM-hang-issue.patch;patch=1 \
file://omap3evm/0014-EMAC-driver-cleanup-removed-debug-prints.patch;patch=1 \
file://omap3evm/0015-EMAC-driver-Check-for-link-status-in-packet-send-lo.patch;patch=1 \
file://omap3evm/0016-Config-option-and-name-changed-to-omap3517_evm.patch;patch=1 \
"
PV_am3517-evm = "2009.03+${PR}+gitr${SRCREV}"

SRC_URI_omapzoom = "git://www.sakoman.net/git/u-boot-omap3.git;branch=omap3-dev;protocol=git"
SRCREV_omapzoom = "d691b424f1f5bf7eea3a4131dfc578d272e8f335"
PV_omapzoom = "2009.01+${PR}+gitr${SRCREV}"

SRC_URI_omapzoom2 = "git://dev.omapzoom.org/pub/scm/bootloader/u-boot.git;branch=master;protocol=git \
                     file://0001-OMAP3-set-L1NEON-bit-in-aux-control-register.patch;patch=1"
SRCREV_omapzoom2 = "78e778e0ea884306841c6499851a1e35177d81d0"
PV_omapzoom2 = "1.1.4+${PR}+gitr${SRCREV}"
PE_omapzoom2 = "1"

do_compile_omapzoom2 () {
        unset LDFLAGS
        unset CFLAGS
        unset CPPFLAGS
        oe_runmake ${UBOOT_MACHINE}
        oe_runmake all
        oe_runmake tools
}

SRC_URI_overo = "git://gitorious.org/u-boot-omap3/mainline.git;branch=omap3-dev;protocol=git \
                 file://fw-env.patch;patch=1 \
                 file://dss2.patch;patch=1 \
"
SRCREV_overo = "2dea1db2a3b7c12ed70bbf8ee50755089c5e5170"
PV_overo = "2009.03+${PR}+gitr${SRCREV}"

# Davinci dm355-evm/dm365-evm/dm6446-evm - PSP.03.01.00.28 (Phase 3 build 28)

SRC_URI_dm355-evm    = "git://arago-project.org/git/projects/u-boot-davinci.git;protocol=git"
SRCREV_dm355-evm     = "f8d047c84137ab331c0ee2c3e94c3f1ec4228298"
PV_dm355-evm         = "2009.10+2009.11-rc1+${PR}+gitr${SRCREV}"

SRC_URI_dm365-evm    = "git://arago-project.org/git/projects/u-boot-davinci.git;protocol=git"
SRCREV_dm365-evm     = "f8d047c84137ab331c0ee2c3e94c3f1ec4228298"
PV_dm365-evm         = "2009.10+2009.11-rc1+${PR}+gitr${SRCREV}"

SRC_URI_dm6446-evm   = "git://arago-project.org/git/projects/u-boot-davinci.git;protocol=git"
SRCREV_dm6446-evm    = "f8d047c84137ab331c0ee2c3e94c3f1ec4228298"
PV_dm6446-evm        = "2009.10+2009.11-rc1+${PR}+gitr${SRCREV}"

# Davinci dm6467-evm/dm6467-evm - PSP.03.02.00 (DM6467 Beta)

SRC_URI_dm6467-evm   = "git://arago-project.org/git/people/hemant/u-boot-dm646x.git;protocol=git"
SRCREV_dm6467-evm    = "b037106746e5b942d7ef06bfcd776a7cdfe32f68"
PV_dm6467-evm        = "1.3.4+${PR}+gitr${SRCREV}"

SRC_URI_dm6467t-evm  = "git://arago-project.org/git/people/hemant/u-boot-dm646x.git;protocol=git"
SRCREV_dm6467t-evm   = "b037106746e5b942d7ef06bfcd776a7cdfe32f68"
PV_dm6467t-evm       = "1.3.4+${PR}+gitr${SRCREV}"

# OMAPL da380-omapl137/da850-omapl138-evm/hawkboard - PSP 3.20.00.07 (Beta)

SRC_URI_da830-omapl137-evm = "git://arago-project.org/git/people/sekhar/u-boot-omapl1.git;protocol=git;branch=master"
SRCREV_da830-omapl137-evm  = "0d291f2f255e6d66a78b3dc2445362a96ae39a57"
PV_da830-omapl137-evm      = "2009.08+gitr${SRCREV}"

SRC_URI_da850-omapl138-evm = "git://arago-project.org/git/people/sekhar/u-boot-omapl1.git;protocol=git;branch=master"
SRCREV_da850-omapl138-evm  = "0d291f2f255e6d66a78b3dc2445362a96ae39a57"
PV_da850-omapl138-evm      = "2009.08+gitr${SRCREV}"

SRC_URI_hawkboard          = "git://arago-project.org/git/people/sekhar/u-boot-omapl1.git;protocol=git;branch=master"
SRCREV_hawkboard           = "0d291f2f255e6d66a78b3dc2445362a96ae39a57"
PV_hawkboard               = "2009.08+gitr${SRCREV}"

SRC_URI_dm355-leopard = "git://www.denx.de/git/u-boot-arm.git;protocol=git;branch=next \
                        file://leopardboard-support.patch;patch=1 \
"
SRCREV_dm355-leopard = "86d5c98d3d97d631b1d3a5f5e6a17e87c99b42cf"
PV_dm355-leopard = "2009.05+2009.06-rc2+gitr${SRCREV}"

SRC_URI_neuros-osd2 = "git://github.com/neuros/u-boot.git;protocol=git;branch=neuros"
SRCREV_neuros-osd2 = "8de979d346624c0e4cfe2e5c0f08ce20ca4b5d14"

SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git"
SRCREV_sequoa = "cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093"

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
SRC_URI_sheevaplug = "git://git.denx.de/u-boot-marvell.git;protocol=git;branch=testing"
SRCREV_sheevaplug = "119b9942da2e450d4e525fc004208dd7f7d062e0"

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
