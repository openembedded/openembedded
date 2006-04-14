SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Linksys NSLU2 device"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PR = "r2"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.4/linux-2.4.22.tar.bz2 \
	   http://nslu.sf.net/downloads/xfs-2.4.22-all-i386.bz2;patch=1 \
	   http://nslu.sf.net/downloads/2.4.22-xfs-nslu2.patch.bz2;patch=1 \
	   file://config-fixes.patch;patch=1 \
	   file://nofpu.patch;patch=1 \
	   file://short_loadbytes.patch;patch=1 \
	   file://gcc3-userfuncs.patch;patch=1 \
	   file://gcc-registerparanoia.patch;patch=1 \
	   file://linux-2.4.24-attribute-used.patch;patch=1 \
	   file://double_cpdo.patch;patch=1 \
           file://defconfig"
S = "${WORKDIR}/linux-2.4.22"

COMPATIBLE_HOST = 'arm.*-linux'
COMPATIBLE_MACHINE = "nslu2"

inherit kernel

ARCH = "arm"
KERNEL_IMAGETYPE = "zImage"
KERNEL_SUFFIX ?= "nslu2-linksys"
CMDLINE_CONSOLE ?= "ttyS0,115200"
CMDLINE_ROOT = "root=/dev/ram0 initrd=0x01000000,10M mem=32M@0x00000000"
CMDLINE = "${CMDLINE_CONSOLE} ${CMDLINE_ROOT}"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config
	rm -rf ${S}/include/asm-arm/arch ${S}/include/asm-arm/proc \
	       ${S}/include/asm-arm/.proc ${S}/include/asm-arm/.arch
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${KERNEL_SUFFIX}
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile
