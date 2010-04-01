DESCRIPTION = "U-boot bootloader w/ BUG support"
LICENSE = "GPL"
SECTION = "bootloader"
PRIORITY = "optional"
PV = "1.3.2+svnr${SRCPV}"
SRCREV = "8674"
PR = "r6"

SRC_URI = "\
  svn://svn.buglabs.net/bug/branches/R1.4/qa;module=u-boot;proto=svn \
"
S = "${WORKDIR}/u-boot"

COMPATIBLE_MACHINE = "bug"
PACKAGE_ARCH = "${MACHINE}"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"
TARGET_LDFLAGS = ""

do_compile () {
    oe_runmake mx31_bug2_config
    oe_runmake clean
    oe_runmake all
}

do_deploy () {
    install -d ${DEPLOY_DIR_IMAGE}
    install -m 0644 ${S}/u-boot.bin ${DEPLOY_DIR_IMAGE}/u-boot-${PV}-${PR}.bin
    ln -sf ${DEPLOY_DIR_IMAGE}/u-boot-${PV}-${PR}.bin ${DEPLOY_DIR_IMAGE}/uboot-latest.bin
}

do_stage() {
    install -m 0755 tools/mkimage ${STAGING_BINDIR_NATIVE}/mkimage
}

do_deploy[dirs] = "${S}"
addtask deploy before do_package after do_install
