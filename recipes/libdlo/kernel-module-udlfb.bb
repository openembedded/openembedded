DESCRIPTION = "Framebuffer console driver for displaylink based usb devices"
LICENSE = "GPLv2"

PV = "0.2.3"

SRC_URI = "file://udlfb.c \
           file://udlfb.h \
           file://Makefile \
"

inherit module

S = "${WORKDIR}"

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/drivers/usb/
	install -m 0644 *.ko ${D}/lib/modules/${KERNEL_VERSION}/drivers/usb/
}

