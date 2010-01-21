require linux.inc

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

ARAGO_DM_REV = "c2aeffe9e835c5b6b275edc416951ce4a348b0fd"
ARAGO_DM_PV  = "2.6.31+2.6.32-rc2-${PR}+gitr${SRCREV}"
ARAGO_DM_BR  = "r30"
ARAGO_DM_URI = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git;branch=${BRANCH} "

SRCREV_dm355-evm           = ${ARAGO_DM_REV}
SRCREV_dm365-evm           = ${ARAGO_DM_REV}
SRCREV_dm6446-evm          = ${ARAGO_DM_REV}
SRCREV_dm6467-evm          = ${ARAGO_DM_REV}
SRCREV_dm6467t-evm         = ${ARAGO_DM_REV}

PV_dm355-evm               = ${ARAGO_DM_PV}
PV_dm365-evm               = ${ARAGO_DM_PV}
PV_dm6446-evm              = ${ARAGO_DM_PV}
PV_dm6467-evm              = ${ARAGO_DM_PV}
PV_dm6467t-evm             = ${ARAGO_DM_PV}

BRANCH_dm355-evm           = ${ARAGO_DM_BR}
BRANCH_dm365-evm           = ${ARAGO_DM_BR}
BRANCH_dm6446-evm          = ${ARAGO_DM_BR}
BRANCH_dm6467-evm          = ${ARAGO_DM_BR}
BRANCH_dm6467t-evm         = ${ARAGO_DM_BR}

SRC_URI_append_dm355-evm   = ${ARAGO_DM_URI}
SRC_URI_append_dm365-evm   = ${ARAGO_DM_URI}
SRC_URI_append_dm6446-evm  = ${ARAGO_DM_URI}
SRC_URI_append_dm6467-evm  = ${ARAGO_DM_URI}
SRC_URI_append_dm6467t-evm = ${ARAGO_DM_URI}

# OMAPL1 DA8xx/L1xx
# da830-omapl137-evm/da850-omapl138-evm/hawkboard OMAPL1 PSP 03.20.00.08 (Beta)
# The main PR is now using MACHINE_KERNEL_PR, for davinci see conf/machine/include/davinci.inc

ARAGO_L1_REV = "e3939e092ce59a6906bf8869a3c7d40314c02eef"
ARAGO_L1_PV  = "2.6.31+2.6.32-rc6-${PR}+gitr${SRCREV}"
ARAGO_L1_URI = "git://arago-project.org/git/people/sekhar/linux-omapl1.git;protocol=git;branch=${BRANCH} "

SRCREV_da830-omapl137-evm         = ${ARAGO_L1_REV}
SRCREV_da850-omapl138-evm         = ${ARAGO_L1_REV}
SRCREV_hawkboard                  = ${ARAGO_L1_REV}

PV_da830-omapl137-evm             = ${ARAGO_L1_PV}
PV_da850-omapl138-evm             = ${ARAGO_L1_PV}
PV_hawkboard                      = ${ARAGO_L1_PV}

SRC_URI_append_da830-omapl137-evm = ${ARAGO_L1_URI}
SRC_URI_append_da850-omapl138-evm = ${ARAGO_L1_URI}
SRC_URI_append_hawkboard          = ${ARAGO_L1_URI}

SRC_URI_append_da850-omapl138-evm = "file://logo_linux_clut224.ppm \
                                     file://0001-CheckRegisterForDCDC.patch;patch=1 \
                                     file://0002-DefDcDcTiedhigh.patch;patch=1 \
                                     file://da850_omapl138_opp456mhz.patch;patch=1 \
                                     file://da850_omapl138_opp408mhz.patch;patch=1 \
                                     file://da850_omapl138_opp456mhz_increaseDcDc3.patch;patch=1"
SRC_URI_append_hawkboard          = "file://logo_linux_clut224.ppm \
                                     file://da850_omapl138_opp456mhz.patch;patch=1 \
                                     file://patch_hawk.diff;patch=1"


do_configure_prepend_hawkboard() {
	sed -i s:2157:2495:g ${S}/arch/arm/tools/mach-types
}


