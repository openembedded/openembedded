SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Vibren PXA255 IDP"
LICENSE = "GPL"
MAINTAINER = "Cliff Brake <cliff.brake@gmail.com>"
PR = "r2"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.11.tar.bz2 \
	   ftp://bec-systems.com/pub/pxa255_idp/linux/kernel-2.6.11-rc4_idp.patch;patch=1 \
	   ftp://bec-systems.com/pub/pxa255_idp/linux/kernel-2.6.11_idp_leds.patch;patch=1 \
           file://vibren-pxa255idp_defconfig"

S = "${WORKDIR}/linux-2.6.11"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel
inherit package

ARCH = "arm"
KERNEL_IMAGETYPE = "uImage"
#CMDLINE_CONSOLE ?= "ttyS0,115200n8"
#CMDLINE_ROOT = "root=/dev/slug rootfstype=ext2,jffs2 initrd=0x01000000,10M mem=32M@0x00000000"
#CMDLINE_ROOT = "root=/dev/mtdblock4 rootfstype=jffs2 mem=32M@0x00000000"
#CMDLINE_ROOT = "root=/dev/ram0 rw rootfstype=ext2,jffs2 initrd=0x01000000,10M init=/linuxrc mem=32M@0x00000000"
#CMDLINE = "${CMDLINE_ROOT} ${CMDLINE_CONSOLE}"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/${MACHINE}_defconfig ${S}/.config
#	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config
}

do_deploy() {
        install -d ${DEPLOY_DIR}/images
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${MACHINE}-${DATETIME}.bin
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile

python () {
	# Don't build openslug kernel unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	if mach != 'vibren-pxa255idp':
		raise bb.parse.SkipPackage("This kernel only builds for the Vibren PXA255 IDP")
}
