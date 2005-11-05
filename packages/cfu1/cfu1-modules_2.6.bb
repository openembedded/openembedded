DESCRIPTION = "PCMCIA driver for the RATOC REX-CFU1 USB host controller CF card."
MAINTAINER = "Botond Botyanszki <openembedded@siliconium.net>"
SECTION = "kernel/modules"
PRIORITY = "optional"
DEPENDS = "virtual/kernel"
LICENSE = "GPL"
RDEPENDS = "kernel-module-usbcore"
PR = "r2"

SRC_URI = "file://rex-cfu1.conf \
           file://Makefile \
           file://sl811_cs.c \
           file://sl811_hcd.c \
           file://sl811.h \
           file://hcd.h \
           file://hub.h"

S = "${WORKDIR}"

inherit module

EXTRA_OEMAKE = 'EXTRA_CFLAGS="-DCONFIG_USB_SL811_CS -DCONFIG_USB_DEBUG" -C ${STAGING_KERNEL_DIR} SUBDIRS=${WORKDIR}'

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/pcmcia/
	install -m 0644 sl811_cs.ko ${D}/lib/modules/${KERNEL_VERSION}/pcmcia/
	install -m 0644 sl811_hcd.ko ${D}/lib/modules/${KERNEL_VERSION}/pcmcia/

	install -d ${D}/${sysconfdir}/pcmcia/
	install -m 0644 ${WORKDIR}/rex-cfu1.conf ${D}/${sysconfdir}/pcmcia/
}
