DESCRIPTION = "Boots a Motorola EZX device with a user supplied kernel zImage"
DEPENDS = "libusb-native"
SECTION = "devel"
AUTHOR = "Harald Welte <laforge@openezx.org>"
LICENSE = "GPL"

SRC_URI = "\
  svn://svn.openezx.org/trunk/src/host;module=boot_usb;proto=http \
  file://asm-arm \
" 
S = "${WORKDIR}/boot_usb"

inherit native

do_compile() {
	${CC} -I${WORKDIR} ${CFLAGS} ${LDFLAGS} -lusb -o ezx-boot-usb boot_usb.c
}

do_deploy() {
        install -d ${DEPLOY_DIR_TOOLS}
        install -m 0755 ezx-boot-usb ${DEPLOY_DIR_TOOLS}/ezx-boot-usb-${PV}
}

do_stage() {
	:
}

do_install() {
	:
}

addtask deploy before do_build after do_compile
