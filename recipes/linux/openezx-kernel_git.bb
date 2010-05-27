DESCRIPTION = "OpenEZX 2.6 Linux Development Kernel for the Motorola EZX GSM phones"
AUTHOR = "The OpenEZX Team <openezx-devel@lists.openezx.org>"
HOMEPAGE = "http://www.openezx.org"
SRCREV = "b390bb1ee708277297fdfd38e26d955b17d81c2e"
KV = "2.6.33"
PV = "${KV}+gitr${SRCREV}"
PR = "r4"

require linux.inc

# Make sure not to use thumb[-interworking]
ARM_INSTRUCTION_SET = "arm"
THUMB_INTERWORKING = "no"

SRC_URI = "\
  git://git.openezx.org/openezx.git;protocol=git;branch=ezx/current \
"
S = "${WORKDIR}/git"

##############################################################
# The kernel image used to reside on a seperate flash partition
# It can be flashed from userspace, so we should package it anyways
# (flash_unlock /dev/mtdX && flash_eraseall /dev/mtdX && flashcp /boot/zImage /dev/mtdX)

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = '(a780|e680|a910|a1200|rorkre2|rokre6)'

# The Kernel command line parameters are given via boot_usb or gen-blob

###############################################################
# module configs specific to this kernel
#
#module_autoload_pxaficp_ir = "pxaficp_ir"
#module_autoload_snd-pcm-oss = "snd-pcm-oss"

do_configure_prepend() {
	install -m 0644 ${S}/arch/arm/configs/ezx_defconfig ${WORKDIR}/defconfig
}
