DESCRIPTION = "Driver for at76 based usb-wifi devices"
SECTION = "base"
LICENSE = "GPL"

PR = "r2"

RDEPENDS = "at76c503-firmware"

SRC_URI = "http://download.berlios.de/at76c503a/at76_usb-0.17.tar.gz"
SRC_URI_ixp4xx = "http://download.berlios.de/at76c503a/at76_usb-0.17.tar.gz \
                  file://at76_usb-0.17-.patch;patch=1"
S = "${WORKDIR}/at76_usb-${PV}/"

inherit module

MODULES = "at76c503 at76_usbdfu at76c503-i3861 at76c503-rfmd at76c503-rfmd-acc \
	at76c505-rfmd at76c503-i3863 at76c505-rfmd2958"

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/
	for i in *${KERNEL_OBJECT_SUFFIX}; do
		install -m 0644 $i ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/
	done
}

SRC_URI[md5sum] = "b47d4fa958aaf83916b6a917626102cd"
SRC_URI[sha256sum] = "9d1fff10d391cb64890bb8e0050d3f023520a8dd5aee43c4d3f9c6f8611da668"
