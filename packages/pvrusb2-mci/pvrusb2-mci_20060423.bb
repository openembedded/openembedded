DESCRIPTION = "Driver for the Hauppauge WinTV PVR USB2"
PRIORITY = "optional"
SECTION = "kernel/modules"
MAINTAINER = "eFfeM <fransmeulenbroeks at yahoo dot com>"
LICENSE = "GPL"
PR = "r0"
RRECOMMENDS = "kernel-module-tveeprom kernel-module-tuner kernel-module-msp3400 kernel-module-saa7115 kernel-module-tda9887"
 
SRC_URI = "http://www.isely.net/downloads/pvrusb2-mci-${PV}.tar.bz2 \
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

export TARGET_LDFLAGS = "-L${STAGING_DIR}/${TARGET_SYS}/lib \
                         -rpath-link ${STAGING_DIR}/${TARGET_SYS}/lib"

do_install() {   
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
}
