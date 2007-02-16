DESCRIPTION = "Boots a S3C2410 device with a user supplied kernel zImage"
DEPENDS = "libusb-native"
SECTION = "devel"
AUTHOR = "Harald Welte"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "file://s3c2410_boot_usb-20060807.tar.bz2"
S = "${WORKDIR}/s3c2410_boot_usb"

inherit native

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -lusb -o s3c2410-boot-usb boot_usb.c
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0755 s3c2410-boot-usb ${DEPLOY_DIR_IMAGE}
}

do_stage() {
	:
}

do_install() {
	:
}

addtask deploy before do_build after do_compile
