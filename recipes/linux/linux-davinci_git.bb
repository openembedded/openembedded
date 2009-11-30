require linux.inc

DESCRIPTION = "Linux kernel for Davinci processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(dm355-evm|dm365-evm|dm6446-evm|dm6467-evm|dm6467t-evm|da830-omapl137-evm|da850-omapl138-evm|dm355-leopard|davinci-sffsdr|hawkboard)"

DEFAULT_PREFERENCE = "1"

BRANCH = "master"

# DAVINCI

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

SRC_URI_dm355-evm          = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git \
                              file://defconfig"
SRC_URI_dm365-evm          = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git \
                              file://defconfig"
SRC_URI_dm6446-evm         = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git \
                              file://defconfig"
SRC_URI_dm6467-evm         = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git \
                              file://defconfig"
SRC_URI_dm6467t-evm        = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git \
                              file://defconfig"


# OMAPL

# da830-omapl137-evm/da850-omapl138-evm/hawkboard OMAPL PSP.3.20.00.07 (Beta)
SRCREV_da830-omapl137-evm  = "b60234a5b0ee985912ecb59d3e689c1ed4baa46c"
SRCREV_da850-omapl138-evm  = "b60234a5b0ee985912ecb59d3e689c1ed4baa46c"
SRCREV_hawkboard           = "b60234a5b0ee985912ecb59d3e689c1ed4baa46c"

# The main PR is now using MACHINE_KERNEL_PR, for davinci see conf/machine/include/davinci.inc
PV_da830-omapl137-evm      = "2.6.31+2.6.32-rc6-${PR}+gitr${SRCREV}"
PV_da850-omapl138-evm      = "2.6.31+2.6.32-rc6-${PR}+gitr${SRCREV}"
PV_hawkboard               = "2.6.31+2.6.32-rc6-${PR}+gitr${SRCREV}"

SRC_URI_da830-omapl137-evm = "git://arago-project.org/git/people/sekhar/linux-omapl1.git;protocol=git;branch=${BRANCH} \
			      file://defconfig"

SRC_URI_da850-omapl138-evm = "git://arago-project.org/git/people/sekhar/linux-omapl1.git;protocol=git;branch=${BRANCH} \
			      file://defconfig"

SRC_URI_hawkboard          = "git://arago-project.org/git/people/sekhar/linux-omapl1.git;protocol=git;branch=${BRANCH} \
                              file://patch_hawk.diff;patch=1 \
                              file://defconfig"

S = "${WORKDIR}/git"
