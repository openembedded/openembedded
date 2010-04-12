SECTION = "base"
LICENSE = "GPL"
DESCRIPTION = "A small, C implementation of hotplug."

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/kernel/hotplug/diethotplug-${PV}.tar.gz \
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

SRC_URI[md5sum] = "1fd89c902006271f00a774cc3183c15d"
SRC_URI[sha256sum] = "dcc1809e8477b95317a7ff503cdd8b6d3f85b8d83a3245252ff47cf631523620"
