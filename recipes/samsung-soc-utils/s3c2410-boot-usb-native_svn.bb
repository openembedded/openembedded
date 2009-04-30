DESCRIPTION = "Boots a S3C2410 device with a user supplied kernel zImage"
DEPENDS = "virtual/libusb0-native"
SECTION = "devel"
AUTHOR = "Harald Welte <laforge@openmoko.org>"
LICENSE = "GPL"
PV = "0.1.0+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://svn.openmoko.org/trunk/src/host/;module=s3c2410_boot_usb;proto=https"
S = "${WORKDIR}/s3c2410_boot_usb"

inherit native

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} -lusb -o s3c2410-boot-usb boot_usb.c
}

do_deploy() {
        install -d ${DEPLOY_DIR_TOOLS}
        install -m 0755 s3c2410-boot-usb ${DEPLOY_DIR_TOOLS}/s3c2410-boot-usb-${PV}
}

do_stage() {
	:
}

do_install() {
	:
}

addtask deploy before do_build after do_compile
