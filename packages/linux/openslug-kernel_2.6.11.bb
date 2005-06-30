SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Linksys NSLU2 device"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PR = "r7"

KERNEL_SUFFIX = "openslug"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.11.2.tar.bz2 \
           file://nslu2_2.6.11.patch;patch=1 \
	   file://usbnet.patch;patch=1 \
	   file://ixp4xx_copy_from.patch;patch=1 \
           file://defconfig \
           file://x1205-rtc.c \
           file://nslu2-io.c \
           file://nslu2-setup.c \
           file://nslu2-pci.c \
           file://nslu2-part.c \
           file://nslu2.h" 
S = "${WORKDIR}/linux-2.6.11.2"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel

ARCH = "arm"
KERNEL_IMAGETYPE = "zImage"
CMDLINE_CONSOLE ?= "ttyS0,115200n8"
#CMDLINE_ROOT ?= "root=/dev/mtdblock4 rootfstype=jffs2 mem=32M@0x00000000"
CMDLINE_ROOT ?= "root=/dev/ram0 rw rootfstype=ext2,jffs2 initrd=0x01000000,10M init=/linuxrc mem=32M@0x00000000"
CMDLINE = "${CMDLINE_ROOT} ${CMDLINE_CONSOLE}"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        install -m 0644 ${WORKDIR}/x1205-rtc.c ${S}/drivers/i2c/chips/x1205-rtc.c
        install -m 0644 ${WORKDIR}/nslu2-io.c ${S}/arch/arm/mach-ixp4xx/nslu2-io.c
        install -m 0644 ${WORKDIR}/nslu2-setup.c ${S}/arch/arm/mach-ixp4xx/nslu2-setup.c
        install -m 0644 ${WORKDIR}/nslu2-pci.c ${S}/arch/arm/mach-ixp4xx/nslu2-pci.c
        install -m 0644 ${WORKDIR}/nslu2-part.c ${S}/arch/arm/mach-ixp4xx/nslu2-part.c
        install -m 0644 ${WORKDIR}/nslu2.h ${S}/include/asm-arm/arch-ixp4xx/nslu2.h
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
	# Don't build openslug kernel unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	dist = bb.data.getVar("DISTRO", d, 1)
	if mach != 'nslu2' or dist != 'openslug':
		raise bb.parse.SkipPackage("OpenSlug only builds for the Linksys NSLU2")
}
