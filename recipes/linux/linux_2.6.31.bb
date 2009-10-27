require linux.inc

PR = "r2"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_db1200 = "1"
DEFAULT_PREFERENCE_qemumips = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.3.bz2;patch=1 \
           http://maxim.org.za/AT91RM9200/2.6/2.6.31-at91.patch.gz;patch=1 \
           file://defconfig"

SRC_URI_append_boc01 = "\
           file://boc01.dts \
           file://boc01.dts.v1 \
           file://004-081205-usb.patch;patch=1 \
           file://005-091008-isl12024.patch;patch=1 \
           file://007-091005-lm73.patch;patch=1 \
           file://011-090115-gpio.patch;patch=1 \
           file://012-091019-capsense.patch;patch=1 \
           file://013-091015-lcd.patch;patch=1 \
           "

SRC_URI_append_ep93xx = " \
           file://edb9301-fix-machine-id.patch;patch=1 \
           "

do_devicetree_image_append_boc01() {
	dtc -I dts -O dtb ${KERNEL_DEVICETREE_FLAGS} -o devicetree.v1 ${KERNEL_DEVICETREE}.v1
	install -m 0644 devicetree.v1 ${D}/boot/devicetree-${KERNEL_VERSION}.v1
}

pkg_postinst_kernel-devicetree_append_boc01 () {
	cd /${KERNEL_IMAGEDEST}; update-alternatives --install /${KERNEL_IMAGEDEST}/devicetree.v1 devicetree.v1 devicetree-${KERNEL_VERSION}.v1 ${KERNEL_PRIORITY} || true
}

pkg_postrm_kernel-devicetree_append_boc01 () {
	cd /${KERNEL_IMAGEDEST}; update-alternatives --remove devicetree.v1 devicetree-${KERNEL_VERSION}.v1 || true
}

