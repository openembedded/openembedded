DESCRIPTION = "Driver for the Hauppauge WinTV PVR USB2"
PRIORITY = "optional"
SECTION = "kernel/modules"
MAINTAINER = "dyoung <dyoung@thestuffguy.com>"
LICENSE = "GPL"
PR = "r0"
RDEPENDS = "kernel-module-tveeprom kernel-module-tuner kernel-module-msp3400
# It in fact also requires kernel-module-saa7115", but for now is using the local ones.
 
SRC_URI = "http://www.isely.net/downloads/pvrusb2-mci-20050921.tar.bz2 \
           file://Makefile.patch;patch=1" 

S = "${WORKDIR}/pvrusb2-mci-20050921/driver"

inherit module

CFLAGS = "'-I${KERNEL_SOURCE}/include' \
          '-D__LINUX_ARM_ARCH__=5'"

EXTRA_OEMAKE = "'CFLAGS=${CFLAGS}' \
                'CC=${KERNEL_CC}' \
                'LD=${KERNEL_LD}' \
                'KDIR=${STAGING_KERNEL_DIR}'" 

do_install() {   
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/media
}

