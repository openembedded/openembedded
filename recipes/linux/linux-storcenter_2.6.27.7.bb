DESCRIPTION = "Linux Kernel for the IOMega StorCenter"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r2"

DEPENDS = "dtc-native"
COMPATIBLE_MACHINE = "storcenter"

SRC_URI = "http://kernel.org/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           file://fw-and-powerpc-install.patch;patch=1 \
           file://defconfig-${PV} \
               "

S = "${WORKDIR}/linux-${PV}"

inherit kernel

export ARCH="powerpc"

KERNEL_IMAGETYPE = "uImage"

FILES_kernel-image += "/boot/storcenter.dtb"

do_configure() {
	mkdir -p ${IMAGE_ROOTFS}
        install -m 0644 ${WORKDIR}/defconfig-${PV} ${S}/.config
        ARCH=${ARCH} oe_runmake oldconfig
}

do_install_append() {
	rm -f ${D}/boot/vmlinux-*
	dtc -f -I dts -O dtb -o ${D}/boot/storcenter.dtb -V 16 ${S}/arch/${ARCH}/boot/dts/storcenter.dts
}

do_builtin_initramfs_foonas() {
	:
}

pkg_preinst_foonas() {
        if [ "x$D" != "x" ]; then
		ln -sf ${KERNEL_IMAGETYPE}-${PV} ${D}/boot/uImage
                exit 1
        fi

	rm -f /boot/uImage
	ln -sf ${KERNEL_IMAGETYPE}-${PV} /boot/uImage
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 ${S}/arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/vmlinux.UBoot
	install -m 0644 ${D}/boot/storcenter.dtb ${DEPLOY_DIR_IMAGE}/storcenter.dtb
}

do_deploy[dirs] = "${S}"

addtask deploy before do_package after do_install

SRC_URI[kernel.md5sum] = "db323884c7dc46e4cd33d0d944fa59a9"
SRC_URI[kernel.sha256sum] = "8e7075fc855ffbcf3c24cbd70b22791759224f98839886d50bba8d659193a950"
