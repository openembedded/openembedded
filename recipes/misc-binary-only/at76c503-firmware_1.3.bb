DESCRIPTION = "Atmel At76c503 802.11b wireless firmware."
SECTION = "base"
LICENSE = "Unknown"

SRC_URI = "http://www.thekelleys.org.uk/atmel/atmel-firmware-${PV}.tar.gz"

FILES_${PN} = "/lib"

do_install() {
	install -d ${D}/lib/firmware/
	install -m 0644  ${WORKDIR}/atmel-firmware-1.3/images.usb/atmel_at76c503-rfmd.bin ${D}/lib/firmware/atmel_at76c503-rfmd.bin
}

