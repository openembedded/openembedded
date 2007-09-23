DESCRIPTION = "Boots an EZX device with a user supplied kernel zImage"
DEPENDS = "libusb-native virtual/kernel"
SECTION = "devel"
AUTHOR = "Harald Welte"
LICENSE = "GPL"
PR = "r1"

DEFAULT_PREFERENCE = "1"

REV = "2060"
PV = "0.1.0+r${REV}"

SRC_URI = "svn://svn.openezx.org/trunk/src/host;module=boot_usb;proto=http;rev=${REV}"
S = "${WORKDIR}/boot_usb"


inherit module-base
#inherit native

do_compile() {
	${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS} -lusb -o ezx-boot-usb boot_usb.c -I${STAGING_KERNEL_DIR}/include
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
