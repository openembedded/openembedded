PR = "r3"
require u-boot.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_hipox = "1"

DEPENDS_append_hipox = " oxnas-boot-tools oxnas-boot-tools-native "

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
	file://cfi-amic-fixup.patch \
"

SRC_URI_append_hipox = " \
	file://00-hipox.patch \
	file://01-hipox-fix-gmac-reset.patch \
	file://02-hipox-enable-mmu.patch \
	file://03-hipox-direct-switch.patch \
	file://04-hipox-env.patch \
	file://10-hipox-boot-abort-key.patch \
"

TARGET_LDFLAGS = ""

UBOOT_MACHINE_hipox  = "hipox_config"

inherit base

do_compile () {
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake all
}

do_deploy_append_hipox () {
	cat ${STAGING_DATADIR}/oxnas-boot-tools/arm/oxnasbt_header.bin ${DEPLOY_DIR_IMAGE}/${UBOOT_IMAGE} > ${DEPLOY_DIR_IMAGE}/${UBOOT_IMAGE}.wrapped
	oxnasbt_update_header ${DEPLOY_DIR_IMAGE}/${UBOOT_IMAGE}.wrapped
}

SRC_URI[md5sum] = "285e2184d2efef50e0fe43b71d2a7b11"
SRC_URI[sha256sum] = "a2889bee9c45575b284564dbc27cf3dc6cb9833d4ff643976a1b3dba2d763f86"
