require linux.inc

DESCRIPTION = "Linux kernel for Davinci processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(dm6446-evm|dm6467-evm|dm355-evm|dm365-evm|davinci-sffsdr|dm355-leopard)"

DEFAULT_PREFERENCE = "1"

SRCREV = "98d4d89866a3fa7375e697ab8434b331ca6a6705"

# The main PR is now using MACHINE_KERNEL_PR, for davinci see conf/machine/include/davinci.inc
PV = "2.6.30+2.6.31-rc2+gitr${SRCREV}"
PE = "1"

SRC_URI = "git://arago-project.org/git/people/sneha/linux-davinci-staging.git;protocol=git\
           file://defconfig"

S = "${WORKDIR}/git"
