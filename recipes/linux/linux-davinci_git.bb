require linux.inc

DESCRIPTION = "Linux kernel for Davinci processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(dm6446-evm|dm6467-evm|dm6467t-evm|dm355-evm|dm365-evm|da830-omapl137-evm|da850-omapl138-evm|davinci-sffsdr|dm355-leopard)"

DEFAULT_PREFERENCE = "1"

SRCREV = "835d1ac43b1c0428cb0f7f91fbaf708ba8e7e504"
SRCREV_da830-omapl137-evm = "1f3804f945375f699023056a462891b80ea2a36e"
SRCREV_da850-omapl138-evm = "1f3804f945375f699023056a462891b80ea2a36e"

# The main PR is now using MACHINE_KERNEL_PR, for davinci see conf/machine/include/davinci.inc
PV = "2.6.30+2.6.31-rc7-${PR}+gitr${SRCREV}"

SRC_URI = "git://arago-project.org/git/projects/linux-davinci.git;protocol=git \
           file://defconfig"

SRC_URI_da830-omapl137-evm = "git://arago-project.org/git/people/sekhar/linux-omapl1.git;protocol=git;branch=staging \
			      file://defconfig"

SRC_URI_da850-omapl138-evm = "git://arago-project.org/git/people/sekhar/linux-omapl1.git;protocol=git;branch=staging \
			      file://defconfig"

S = "${WORKDIR}/git"
