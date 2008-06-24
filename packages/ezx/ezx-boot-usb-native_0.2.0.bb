require ezx-boot-usb-native.inc

SRC_URI = "http://www.openezx.org/download/boot_usb-${PV}.tar.bz2 \
           file://asm-arm"
S = "${WORKDIR}/boot_usb-${PV}"
