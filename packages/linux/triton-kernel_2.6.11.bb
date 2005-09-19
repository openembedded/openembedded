SECTION = "kernel"
DESCRIPTION = "Linux kernel for the KARO TRITON XScale Board"
LICENSE = "GPL"
MAINTAINER = "Justin Huff <jjhuff@mspin.net"
PR = "r0"

KERNEL_SUFFIX = "triton"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           ftp://ftp.kernel.org/pub/linux/kernel/people/akpm/patches/2.6/${PV}/${PV}-mm2/${PV}-mm2.bz2;patch=1 \
		   file://patch-2.6.11-mm2-karo9.bz2;patch=1 \
		   file://defconfig"
 
S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel

ARCH = "arm"
KERNEL_IMAGETYPE = "zImage"
CMDLINE ?= "root=/dev/mtdblock2 rw rootfstype=jffs2 reboot=5"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config
	rm -rf ${S}/include/asm-arm/arch ${S}/include/asm-arm/proc \
	       ${S}/include/asm-arm/.proc ${S}/include/asm-arm/.arch
}

do_deploy() {
        install -d ${DEPLOY_DIR}/images
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${KERNEL_SUFFIX}
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile

python () {
	# Don't build kernel unless we're targeting an triton
	mach = bb.data.getVar("MACHINE", d, 1)
	if mach != 'triton':
		raise bb.parse.SkipPackage("The triton kernel is only for use on triton machines")
}
