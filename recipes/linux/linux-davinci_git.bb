require multi-kernel.inc

DESCRIPTION = "Linux kernel for DaVinci processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(dm355-evm|dm365-evm|dm6446-evm|dm6467-evm|dm6467t-evm|omapl137|omapl138|dm355-leopard|davinci-sffsdr|hawkboard|dm368-evm)"

DEFAULT_PREFERENCE = "1"
DEFAULT_PREFERENCE_dm365 = "-1"

BRANCH = "master"
SRC_URI = "file://defconfig "

S = "${WORKDIR}/git"

# DaVinci DM3xx/DM6xxx
# dm355-evm/dm365-evm/dm6446-evm/dm6467-evm/dm6467t-evm Davinci PSP 03.01.00/03.02.00 (build r30)
# The main PR is now using MACHINE_KERNEL_PR, for davinci see conf/machine/include/davinci.inc

ARAGO_DM_REV = "e87a8397d2830db11ce1518bd2abc4e8815763f1"
ARAGO_DM_PV  = "2.6.31+2.6.32-rc2-${PR}+gitr${SRCREV}"
ARAGO_DM_BR  = "r32"
ARAGO_DM_URI = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git;branch=${BRANCH} "

SRCREV_dm355           = ${ARAGO_DM_REV}
SRCREV_dm365           = ${ARAGO_DM_REV}
SRCREV_dm6446          = ${ARAGO_DM_REV}
SRCREV_dm6467          = ${ARAGO_DM_REV}

PV_dm355               = ${ARAGO_DM_PV}
PV_dm365               = ${ARAGO_DM_PV}
PV_dm6446              = ${ARAGO_DM_PV}
PV_dm6467              = ${ARAGO_DM_PV}

BRANCH_dm355           = ${ARAGO_DM_BR}
BRANCH_dm365           = ${ARAGO_DM_BR}
BRANCH_dm6446          = ${ARAGO_DM_BR}
BRANCH_dm6467          = ${ARAGO_DM_BR}

SRC_URI_append_dm355   = ${ARAGO_DM_URI}
SRC_URI_append_dm365   = ${ARAGO_DM_URI}
SRC_URI_append_dm6446  = ${ARAGO_DM_URI}
SRC_URI_append_dm6467  = ${ARAGO_DM_URI}


# The main PR is now using MACHINE_KERNEL_PR, for davinci see conf/machine/include/davinci.inc

# OMAPL tracking master branch - PSP 3.20.00.12

ARAGO_L1_REV = "2acf935c01b9adb50164d421c40cdc5862b9e143"
ARAGO_L1_BR  = "master"
ARAGO_L1_PV  = "2.6.32+2.6.33-rc4-${PR}+gitr${SRCREV}"
ARAGO_L1_URI = "git://arago-project.org/git/projects/linux-omapl1.git;protocol=git;branch=${BRANCH} "

SRCREV_omapl137         = ${ARAGO_L1_REV}
SRCREV_omapl138         = ${ARAGO_L1_REV}
SRCREV_hawkboard                  = ${ARAGO_L1_REV}

PV_omapl137             = ${ARAGO_L1_PV}
PV_omapl138             = ${ARAGO_L1_PV}

BRANCH_omapl137         = ${ARAGO_L1_BR}
BRANCH_omapl138         = ${ARAGO_L1_BR}

SRC_URI_append_omapl137 = ${ARAGO_L1_URI}
SRC_URI_append_omapl138 = ${ARAGO_L1_URI}

SRC_URI_append_omapl138 = "file://logo_linux_clut224.ppm \
                                     file://0001-ahci-ti-Fix-currently-harmless-typo-in-SATA-PHY.patch \
                                     file://0002-ahci-ti-Update-SATA-PHY-configuration-RXCDR.patch \
                                     file://0001-board-da850-evm-Disable-NAND-SUBPAGE.patch \
                                     file://0001-uio_pruss1-Core-driver-addition.patch \
                                     file://0002-uio_pruss2-Platform-changes.patch \
                                     file://0003-uio_pruss3-Workarounds-put-into-core-code.patch \
                                     "

SRC_URI_append_hawkboard          = " \
                                     file://patch-2.6.33rc4-psp-to-hawkboard.patch \
                                     file://0001-board-da850-hawk-Disable-NAND-SUBPAGE.patch \
                                    "

do_configure_prepend_dm355-leopard() {
	sed -i s:2138:1381:g ${S}/arch/arm/tools/mach-types
}
