require linux.inc

DESCRIPTION = "Linux kernel for Davinci processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(dm355-evm|dm365-evm|dm6446-evm|dm6467-evm|dm6467t-evm|da830-omapl137-evm|da850-omapl138-evm|dm355-leopard|davinci-sffsdr|hawkboard)"

DEFAULT_PREFERENCE = "1"

BRANCH = "master"
SRC_URI = "file://defconfig "

# dm355-evm/dm365-evm/dm6446-evm/dm6467-evm/dm6467t-evm Davinci PSP.03.01.00.28 (Phase 3 Build r28)
SRCREV_dm355-evm           = "7b2683fd0168df1576fcea947ef9f63e905de807"
SRCREV_dm365-evm           = "7b2683fd0168df1576fcea947ef9f63e905de807"
SRCREV_dm6446-evm          = "7b2683fd0168df1576fcea947ef9f63e905de807"
SRCREV_dm6467-evm          = "7b2683fd0168df1576fcea947ef9f63e905de807"
SRCREV_dm6467t-evm         = "7b2683fd0168df1576fcea947ef9f63e905de807"

# The main PR is now using MACHINE_KERNEL_PR, for davinci see conf/machine/include/davinci.inc
PV_dm355-evm               = "2.6.31+2.6.32-rc2-${PR}+gitr${SRCREV}"
PV_dm365-evm               = "2.6.31+2.6.32-rc2-${PR}+gitr${SRCREV}"
PV_dm6446-evm              = "2.6.31+2.6.32-rc2-${PR}+gitr${SRCREV}"
PV_dm6467-evm              = "2.6.31+2.6.32-rc2-${PR}+gitr${SRCREV}"
PV_dm6467t-evm             = "2.6.31+2.6.32-rc2-${PR}+gitr${SRCREV}"

BRANCH_dm355-evm           = "r28"
BRANCH_dm365-evm           = "r28"
BRANCH_dm6446-evm          = "r28"
BRANCH_dm6467-evm          = "r28"
BRANCH_dm6467t-evm         = "r28"

SRC_URI_append_dm355-evm          = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git;branch=${BRANCH}"
SRC_URI_append_dm365-evm          = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git;branch=${BRANCH}"
SRC_URI_append_dm6446-evm         = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git;branch=${BRANCH}"
SRC_URI_append_dm6467-evm         = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git;branch=${BRANCH}"
SRC_URI_append_dm6467t-evm        = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git;branch=${BRANCH}"


# OMAPL

# da830-omapl137-evm/da850-omapl138-evm/hawkboard OMAPL PSP.3.20.00.07 (Beta)
SRCREV_da830-omapl137-evm  = "b306b47248ef6b4e5927a6baa2849ff434c12ddb"
SRCREV_da850-omapl138-evm  = "b306b47248ef6b4e5927a6baa2849ff434c12ddb"
SRCREV_hawkboard           = "b306b47248ef6b4e5927a6baa2849ff434c12ddb"

# The main PR is now using MACHINE_KERNEL_PR, for davinci see conf/machine/include/davinci.inc
PV_da830-omapl137-evm      = "2.6.31+2.6.32-rc6-${PR}+gitr${SRCREV}"
PV_da850-omapl138-evm      = "2.6.31+2.6.32-rc6-${PR}+gitr${SRCREV}"
PV_hawkboard               = "2.6.31+2.6.32-rc6-${PR}+gitr${SRCREV}"

SRC_URI_append_da830-omapl137-evm = "git://arago-project.org/git/people/sekhar/linux-omapl1.git;protocol=git;branch=${BRANCH}"
SRC_URI_append_da850-omapl138-evm = "git://arago-project.org/git/people/sekhar/linux-omapl1.git;protocol=git;branch=${BRANCH}"
SRC_URI_append_hawkboard          = "git://arago-project.org/git/people/sekhar/linux-omapl1.git;protocol=git;branch=${BRANCH} \
                              file://patch_hawk.diff;patch=1"

S = "${WORKDIR}/git"
