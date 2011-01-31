DESCRIPTION = "Linux 2.6.36 kernel for the Ben Nanonote"
SECTION = "kernel"
LICENSE = "GPLv2"

DEPENDS += "u-boot-mkimage-native"

SRCREV = "${AUTOREV}"

DEFAULT_PREFERENCE_ben-nanonote = "1"
COMPATIBLE_MACHINE = "ben-nanonote"

KERNEL_IMAGETYPE = "vmlinux.bin"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/kristoffer/linux-hpc.git;protocol=git;branch=v2.6.36-hpc \
	   file://logo_linux_clut224.tar.gz \
	   file://modifier-keys.patch \
	   file://config-ben-nanonote \
	   file://jz4740-udc.patch"

S = "${WORKDIR}/git"

inherit kernel

FILES_kernel-image = "/boot/uImage*"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/config-ben-nanonote ${S}/.config
	mv -f ${WORKDIR}/logo_linux_clut224.ppm ${S}/drivers/video/logo
}

do_install_append() {
	cd ${S}
	kernel_entry=`nm vmlinux | grep " kernel_entry" | cut -d' ' -f1`

	cd ${S}/arch/mips/boot
	rm -f vmlinux.bin.gz
	gzip -c9 vmlinux.bin > vmlinux.bin.gz

	mkimage -A mips -O linux -T kernel -C gzip -a 0x80010000 -e 0x${kernel_entry} \
	-n 'MIPS' -d vmlinux.bin.gz uImage-${KERNEL_VERSION}

	install -m 0644 uImage-${KERNEL_VERSION} ${D}/boot
}

pkg_postinst_kernel() {
	cd /${KERNEL_IMAGEDEST}; update-alternatives --install /${KERNEL_IMAGEDEST}/uImage uImage uImage-${KERNEL_VERSION} ${KERNEL_PRIORITY} || true
}

pkg_postrm_kernel() {
	cd /${KERNEL_IMAGEDEST}; update-alternatives --remove uImage uImage-${KERNEL_VERSION} || true
}
