DESCRIPTION = "U-boot bootloader"
PROVIDES = "virtual/bootloader"
SECTION = "bootloader"
MAINTAINER = "Holger Schurig"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2 \
	   file://arm_flags.patch;patch=1 "
SRC_URI_append_vibren = "ftp://bec-systems.com/pub/pxa255_idp/u-boot/uboot_pxa255-idp_2005-03-23.patch;patch=1"
SRC_URI_append_mnci   = "file://mnci.patch;patch=1 \
                         file://mnci-jffs2.patch;patch=1 \
                         file://cmd-arm-linux.patch;patch=1 \
                         file://command-names.patch;patch=1"
# TODO: SRC_URI_append_rt3000

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"
TARGET_LDFLAGS = ""

UBOOT_MACHINE ?= "${MACHINE}_config"
UBOOT_MACHINE_mnci   = "mnci_config"
UBOOT_MACHINE_vibren = "pxa255_idp_config"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.bin"

inherit base

do_compile () {
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake all
}

do_stage() {
	install -m755 tools/mkimage ${STAGING_BINDIR}
}

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/u-boot.bin ${DEPLOY_DIR_IMAGE}/${UBOOT_IMAGE}
}
do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_compile


#########################################################

RDEPENDS_append_mnci = " hwctrl"

FILES_${PN}_mnci = "/tmp/${UBOOT_IMAGE}"
do_install_openmn() {
	install -d ${D}/tmp
	install ${S}/u-boot.bin ${D}/tmp/${UBOOT_IMAGE}
}

pkg_postinst_mnci() {
ldconfig
A=/tmp/bootargs
hwctrl kernel_conf_get bootargs >$A
cp /tmp/${UBOOT_IMAGE} /dev/mtdblock/0
rm /tmp/${UBOOT_IMAGE}
hwctrl kernel_conf_set bootargs "`cat $A`"
cat /dev/mtdblock/0 >/dev/null
exit 0
}
