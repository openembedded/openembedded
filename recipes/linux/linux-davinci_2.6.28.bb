require linux.inc

DESCRIPTION = "Linux kernel for Davinci processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(dm6446-evm|dm6467-evm|davinci-sffsdr)"

# The main PR is now using MACHINE_KERNEL_PR, for davinci see conf/machine/include/davinci.inc

SRCREV = "0fc192ac07c977ad6f14333651b53096a6027bc6"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/khilman/linux-davinci.git;protocol=git \
           file://defconfig"

SRC_URI_append_davinci-sffsdr = " \
           file://0001-USB-musb-cppi-bugfixes.patch;apply=yes \
           file://0002-ARM-Mark-unsupported-syscalls-as-IGNORE.patch;apply=yes \
           file://0003-Add-macros-for-enabling-a-UART.patch;apply=yes \
           file://0004-Davinci-Enable-MAC-address-to-be-specified-on-kerne.patch;apply=yes \
           file://0005-Add-DAS-Mini-DAS-and-AFE-USB-machine-types.patch;apply=yes \
           file://0006-ALSA-ASoC-DaVinci-Fix-SFFSDR-compilation-error.patch;apply=yes \
           file://0007-ALSA-ASoC-Davinci-Fix-SFFSDR-FPGA-module-codec-FS.patch;apply=yes \
           file://0008-ALSA-ASoC-Davinci-Fix-incorrect-machine-type-for.patch;apply=yes \
           file://0009-sound-ASoC-Fix-DaVinci-module-unload-error.patch;apply=yes \
           file://0010-Add-generic-FPGA-bitstream-loader-driver.patch;apply=yes \
           file://0011-Add-lyrvpss-example-driver-for-the-SFFSDR-board.patch;apply=yes \
           file://0012-Update-SFFSDR-to-support-FPGA-and-lyrvpss-drivers.patch;apply=yes \
          "

S = "${WORKDIR}/git"
