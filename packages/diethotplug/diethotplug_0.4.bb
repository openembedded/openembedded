SECTION = "base"
LICENSE = "GPL"
DESCRIPTION = "A small, C implementation of hotplug."

SRC_URI = "http://www.kernel.org/pub/linux/utils/kernel/hotplug/diethotplug-${PV}.tar.gz \
           file://modules.usbmap \
           file://modules.pcimap \
           file://modules.ieee1394map"

export KLIBC = ""

do_compile () {
	perl convert_usb.pl ${WORKDIR}/modules.usbmap > usb_modules.h
	perl convert_pci.pl ${WORKDIR}/modules.pcimap > pci_modules.h
	perl convert_ieee1394.pl ${WORKDIR}/modules.ieee1394map > ieee1394_modules.h
	oe_runmake
}

do_install () {
	install -d ${D}${sbindir}
	install -m 0755 hotplug ${D}${sbindir}/
}
