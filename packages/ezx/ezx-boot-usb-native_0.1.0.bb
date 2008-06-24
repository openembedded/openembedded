require ezx-boot-usb-native.inc
PR = "r0"

SRC_URI = "http://www.openezx.org/download/boot_usb-${PV}.tar.bz2"
S = "${WORKDIR}/boot_usb-${PV}"

inherit native
