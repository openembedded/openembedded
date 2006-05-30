DESCRIPTION = "Boots an EZX device with a user supplied kernel zImage"
DEPENDS = "libusb-native"
SECTION = "devel"
AUTHOR = "Harald Welte"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "svn://svn.openezx.org/trunk/src/host;module=boot_usb;proto=http"
S = "${WORKDIR}/boot_usb"

inherit native

do_compile() {
	${CC} ${CFLAGS} -lusb -o ezx-boot-usb boot_usb.c
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
