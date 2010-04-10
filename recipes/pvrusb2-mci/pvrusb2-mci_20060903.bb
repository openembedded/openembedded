# FIXME, consider using kernel staging directory instead of KERNEL_SOURCE which is
# located in the work directory. see module.bbclass

require pvrusb2-mci2.inc

RRECOMMENDS = "kernel-module-tveeprom \
	kernel-module-firmware-class \
	kernel-module-tuner \
	kernel-module-msp3400 \
	kernel-module-saa7115 \
	kernel-module-tda9887 \
	kernel-module-v4l1-compat \
	kernel-module-v4l2-common \
	kernel-module-videodev"

SRC_URI = "http://www.isely.net/downloads/pvrusb2-mci-${PV}.tar.bz2 \
           file://hotplug.functions \
           file://firmware.hotplug \
           file://Makefile.patch;patch=1"

S = "${WORKDIR}/pvrusb2-mci-${PV}/driver"

inherit module

CFLAGS = "'-I${KERNEL_SOURCE}/include' \
	  '-I${KERNEL_SOURCE}/drivers/media/video' "

CFLAGS_append_arm = " '-D__LINUX_ARM_ARCH__=5' "

CFLAGS_append_armeb = " '-D__LINUX_ARM_ARCH__=5' "

EXTRA_OEMAKE = "'V=1' 'CFLAGS=${CFLAGS}' \
                'CC=${KERNEL_CC}' \
                'LD=${KERNEL_LD}' \
                'KDIR=${STAGING_KERNEL_DIR}'"

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
	mkdir -p ${D}/etc/hotplug.d/firmware
	cp ${WORKDIR}/hotplug.functions ${D}/etc/hotplug.d/firmware
	cp ${WORKDIR}/firmware.hotplug ${D}/etc/hotplug.d/firmware
}

SRC_URI[md5sum] = "64805cf3efcd43f39e500229ff511b5a"
SRC_URI[sha256sum] = "fe73f3e7586cead55920d7fcdaca3924776b55d335d815042d14b16aa68d74fa"
