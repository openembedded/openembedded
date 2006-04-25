DESCRIPTION = "Philips USB Webcam driver for Linux that supports VGA resolution"
HOMEPAGE = "http://www.saillard.org/linux/pwc"
PRIORITY = "optional"
SECTION = "kernel/modules"
MAINTAINER = "eFfeM <fransmeulenbroeks at yahoo dot com>"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.saillard.org/linux/pwc/files/pwc-${PV}.tar.bz2 \
           file://Makefile.patch;patch=1" 

S = "${WORKDIR}/pwc-${PV}"

inherit module

CFLAGS = "'-I${KERNEL_SOURCE}/include' "

CFLAGS_append_arm = " '-D__LINUX_ARM_ARCH__=5' "

CFLAGS_append_armeb = " '-D__LINUX_ARM_ARCH__=5' "

EXTRA_OEMAKE = "'V=1' 'CFLAGS=${CFLAGS}' \
                'CC=${KERNEL_CC}' \
                'LD=${KERNEL_LD}' \
                'KDIR=${STAGING_KERNEL_DIR}'" 

export TARGET_LDFLAGS = "-L${STAGING_DIR}/${TARGET_SYS}/lib \
                         -rpath-link ${STAGING_DIR}/${TARGET_SYS}/lib"

do_install() {   
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
}
