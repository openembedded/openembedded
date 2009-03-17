DESCRIPTION = "Driver for usb serial cables based upon ArkMicroChips 3116s chip"
HOMEPAGE = "http://avr.auctionant.de/ark3116_linux_driver/"
PRIORITY = "optional"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r2"
RRECOMMENDS = "kernel-module-usbserial"

SRC_URI = "http://avr.auctionant.de/ark3116_linux_driver/releases/ark3116-0.4.1.tgz \
           file://ark3116.c.patch;patch=1 \
           file://Makefile.patch;patch=1"

S = "${WORKDIR}/ark3116"

inherit module

CFLAGS = "'-I${KERNEL_SOURCE}/include'"

CFLAGS_append_arm = " '-D__LINUX_ARM_ARCH__=5' "

CFLAGS_append_armeb = " '-D__LINUX_ARM_ARCH__=5' "

EXTRA_OEMAKE = "'V=1' 'CFLAGS=${CFLAGS}' \
                'CC=${KERNEL_CC}' \
                'LD=${KERNEL_LD}' \
                'KDIR=${STAGING_KERNEL_DIR}'"

export TARGET_LDFLAGS = "-L${STAGING_DIR_TARGET}${layout_libdir} \
                         -Wl,-rpath-link,${STAGING_DIR_TARGET}${layout_libdir}"

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/serial
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/serial
}
