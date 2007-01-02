DESCRIPTION = "Boots an EZX device with a user supplied kernel zImage"
DEPENDS = "libusb-native"
SECTION = "devel"
AUTHOR = "Harald Welte"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.openezx.org/download/boot_usb-${PV}.tar.bz2"
S = "${WORKDIR}/boot_usb-${PV}"

inherit native

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -lusb -o ezx-boot-usb boot_usb.c
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0755 ezx-boot-usb ${DEPLOY_DIR_IMAGE}/ezx-boot-usb
}

do_stage() {
	:
}

do_install() {
	:
}

addtask deploy before do_build after do_compile
