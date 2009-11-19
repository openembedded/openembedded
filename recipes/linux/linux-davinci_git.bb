require linux.inc

DESCRIPTION = "Linux kernel for Davinci processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(dm6446-evm|dm6467-evm|dm6467t-evm|dm355-evm|dm365-evm|da830-omapl137-evm|da850-omapl138-evm|davinci-sffsdr|dm355-leopard)"

DEFAULT_PREFERENCE = "1"

SRCREV = "835d1ac43b1c0428cb0f7f91fbaf708ba8e7e504"

# OMAPL commits for PSP 3.20.00.07 Release Tag
SRCREV_da830-omapl137-evm = "b60234a5b0ee985912ecb59d3e689c1ed4baa46c"
SRCREV_da850-omapl138-evm = "b60234a5b0ee985912ecb59d3e689c1ed4baa46c"

BRANCH = "master"

# The main PR is now using MACHINE_KERNEL_PR, for davinci see conf/machine/include/davinci.inc
PV = "2.6.31+2.6.32-rc7-${PR}+gitr${SRCPV}"
PE = "1"

SRC_URI = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git \
           file://defconfig"

SRC_URI_da830-omapl137-evm = "git://arago-project.org/git/people/sekhar/linux-omapl1.git;protocol=git;branch=${BRANCH} \
			      file://defconfig"

SRC_URI_da850-omapl138-evm = "git://arago-project.org/git/people/sekhar/linux-omapl1.git;protocol=git;branch=${BRANCH} \
			      file://defconfig"

S = "${WORKDIR}/git"
