PR = "r3"
require u-boot.inc

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
	   file://arm_flags.patch;patch=1 "
# Override whole URI fr Neon since Neon patch is incompatible with arm_flags patch.
SRC_URI_bd-neon = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
                   file://u-boot-1.1.2-neon.patch;patch=1"
SRC_URI_append_vibren = "ftp://bec-systems.com/pub/pxa255_idp/u-boot/uboot_pxa255-idp_2005-03-23.patch;patch=1"
SRC_URI_append_mnci   = "file://mnci.patch;patch=1 \
                         file://mnci-jffs2.patch;patch=1 \
                         file://cmd-arm-linux.patch;patch=1 \
                         file://command-names.patch;patch=1"

SRC_URI_append_magicbox  = "file://u-boot-emetec.patch;patch=1 "


# TODO: SRC_URI_append_rt3000

TARGET_LDFLAGS = ""

UBOOT_MACHINE_mnci   = "mnci_config"
UBOOT_MACHINE_vibren = "pxa255_idp_config"
UBOOT_MACHINE_magicbox = "EMETEC405_config"

inherit base

do_compile () {
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake all
}

#########################################################

RDEPENDS_append_mnci = " hwctrl"

FILES_${PN}_mnci = "/tmp/${UBOOT_IMAGE}"

do_configure_prepend_bd-neon () {
	chmod +x ${S}/Configure
}

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
