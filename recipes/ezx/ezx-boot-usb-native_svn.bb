DESCRIPTION = "Boot a Motorola EZX device with a user supplied kernel"
DEPENDS = "virtual/libusb0-native virtual/kernel"
SECTION = "devel"
AUTHOR = "Team OpenEZX <openezx-devel@lists.openezx.org>"
LICENSE = "GPL"
PV = "0.3.0+svnr${SRCPV}"

SRC_URI = "svn://svn.openezx.org/trunk/src/host;module=boot_usb;proto=http" 
S = "${WORKDIR}/boot_usb"

EXTRA_OECONF := '--with-kernel-dir="${STAGING_DIR}/${MACHINE_ARCH}${TARGET_VENDOR}-${TARGET_OS}/kernel"'

inherit autotools native

do_deploy() {
        install -d ${DEPLOY_DIR_TOOLS}
        install -m 0755 src/boot_usb ${DEPLOY_DIR_TOOLS}/ezx-boot-usb-${PV}
}

do_stage() {
	:
}

do_install() {
	:
}

addtask deploy before do_build after do_compile
