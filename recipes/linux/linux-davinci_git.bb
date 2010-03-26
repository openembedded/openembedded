require multi-kernel.inc

DESCRIPTION = "Linux kernel for DaVinci processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(dm355-evm|dm365-evm|dm6446-evm|dm6467-evm|dm6467t-evm|da830-omapl137-evm|da850-omapl138-evm|dm355-leopard|davinci-sffsdr|hawkboard)"

DEFAULT_PREFERENCE = "1"

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

# OMAPL tracking master branch

ARAGO_L1_REV = "76fcecb83d562608bcebba44774f92b6c62d3593"
ARAGO_L1_BR  = "master"
ARAGO_L1_PV  = "2.6.32+2.6.33-rc4-${PR}+gitr${SRCREV}"
ARAGO_L1_URI = "git://arago-project.org/git/projects/linux-omapl1.git;protocol=git;branch=${BRANCH} "

SRCREV_da830-omapl137-evm         = ${ARAGO_L1_REV}
SRCREV_da850-omapl138-evm         = ${ARAGO_L1_REV}
SRCREV_hawkboard                  = ${ARAGO_L1_REV}

PV_da830-omapl137-evm             = ${ARAGO_L1_PV}
PV_da850-omapl138-evm             = ${ARAGO_L1_PV}
PV_hawkboard                      = ${ARAGO_L1_PV}

BRANCH_da830-omapl137-evm         = ${ARAGO_L1_BR}
BRANCH_da850-omapl138-evm         = ${ARAGO_L1_BR}
BRANCH_hawkboard                  = ${ARAGO_L1_BR}

SRC_URI_append_da830-omapl137-evm = ${ARAGO_L1_URI}
SRC_URI_append_da850-omapl138-evm = ${ARAGO_L1_URI}
SRC_URI_append_hawkboard          = ${ARAGO_L1_URI}

SRC_URI_append_da850-omapl138-evm = "file://logo_linux_clut224.ppm \
                                     "

SRC_URI_append_hawkboard          = "file://logo_linux_clut224.ppm \
                                     file://patch-2.6.33rc4-psp-to-hawkboard.patch;patch=1 "

do_configure_prepend_dm355-leopard() {
	sed -i s:2138:1381:g ${S}/arch/arm/tools/mach-types
}
