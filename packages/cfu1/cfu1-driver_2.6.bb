DESCRIPTION = "PCMCIA driver for the RATOC REX-CFU1 USB host controller CF card."
MAINTAINER = "Botond Botyanszki <openembedded@siliconium.net>"
SECTION = "kernel/modules"
PRIORITY = "optional"
DEPENDS = "virtual/kernel"

RDEPENDS = "kernel-module-usbcore"

SRC_URI = "file://rex-cfu1.conf \
 file://cfu1-driver/Makefile \
 file://cfu1-driver/sl811_cs.c \
 file://cfu1-driver/sl811_hcd.c \
 file://cfu1-driver/sl811.h \
 file://cfu1-driver/hcd.h \
 file://cfu1-driver/hub.h \
 "

S = "${WORKDIR}/${PN}"

inherit module

#EXTRA_OEMAKE = "-C ${STAGING_KERNEL_DIR} SUBDIRS=${WORKDIR}/cfu1-driver"
EXTRA_OEMAKE = 'EXTRA_CFLAGS="-DCONFIG_USB_SL811_CS -DCONFIG_USB_DEBUG" -C ${STAGING_KERNEL_DIR} SUBDIRS=${WORKDIR}/cfu1-driver'

do_configure() {
        if grep CONFIG_PCMCIA=[ym] ${STAGING_KERNEL_DIR}/.config && 
	    grep CONFIG_USB_ARCH_HAS_HCD=[ym] ${STAGING_KERNEL_DIR}/.config; then
#                echo "CONFIG_USB_SL811_CS=m"          >> config.mk
		 echo ".config OK"
	else
		echo "CONFIG_USB_ARCH_HAS_HCD or CONFIG_PCMCIA not defined in kernel config!"
		exit 1
        fi
}

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake modules
}
		

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/pcmcia/
	install -m 0644 sl811_cs.ko ${D}/lib/modules/${KERNEL_VERSION}/pcmcia/
	install -m 0644 sl811_hcd.ko ${D}/lib/modules/${KERNEL_VERSION}/pcmcia/
}

do_install_append () {
	install -d ${D}/${sysconfdir}/pcmcia/
	install -m 0644 ${WORKDIR}/rex-cfu1.conf ${D}/${sysconfdir}/pcmcia/
}
