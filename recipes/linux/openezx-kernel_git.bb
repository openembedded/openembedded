DESCRIPTION = "OpenEZX 2.6 Linux Development Kernel for the Motorola EZX GSM phones"
AUTHOR = "The OpenEZX Team <openezx-devel@lists.openezx.org>"
HOMEPAGE = "http://www.openezx.org"
KV = "2.6.28+2.6.29rc8"
PV = "${KV}+gitr${SRCREV}"
PR = "r0"

require linux.inc

# Make sure not to use thumb[-interworking]
ARM_INSTRUCTION_SET = "arm"
THUMB_INTERWORKING = "no"

SRC_URI = "\
  git://git.openezx.org/openezx.git;protocol=git;branch=ezx/current \
"
S = "${WORKDIR}/git"

##############################################################
# kernel image resides on a seperate flash partition (for now)
# But we can flash it from userspace (flash_unlock /dev/mtdX && flash_eraseall /dev/mtdX && flashcp /boot/zImage /dev/mtdX)
# so lets make a package of it. What about a postinst that flashes the new kernel?

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = '(a780|e680|a910|a1200|rorkre2|rokre6)'

# Kernel command line parameters are given over boot_usb or gen-blob's menu

###############################################################
# module configs specific to this kernel
#
#module_autoload_pxaficp_ir = "pxaficp_ir"
#module_autoload_snd-pcm-oss = "snd-pcm-oss"

do_configure_prepend() {
	install -m 0644 ${S}/arch/arm/configs/ezx_defconfig ${WORKDIR}/defconfig
}
