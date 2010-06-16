DESCRIPTION = "Boot a Motorola EZX device with a user supplied kernel"
DEPENDS = "virtual/libusb0-native virtual/kernel"
SECTION = "devel"
AUTHOR = "Team OpenEZX <openezx-devel@lists.openezx.org>"
LICENSE = "GPL"
SRCREV = "d7136c6c9fe9d62b8f3defccef5dca47258bef63"
PV = "0.3.0+gitr${SRCPV}"
PR = "r0"
PE = "1"

SRC_URI = "git://git.openezx.org/moto-boot-usb.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

EXTRA_OECONF := '--with-kernel-dir="${STAGING_DIR}/${MACHINE_ARCH}${TARGET_VENDOR}-${TARGET_OS}/kernel"'

inherit autotools native

do_deploy() {
        install -d ${DEPLOY_DIR_TOOLS}
        install -m 0755 src/moto-boot-usb ${DEPLOY_DIR_TOOLS}/moto-boot-usb-${PV}
}

do_install() {
  :
}

addtask deploy before do_build after do_compile
