DESCRIPTION = "Driver for the SHARP Zaurus SD/MMC Slot for linux ${PV}"
SECTION = "kernel/modules"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "CLOSED"
RDEPENDS = "kernel (${PV})"
PR = "r23"
PACKAGE_ARCH = "${MACHINE}"

COMPATIBLE_MACHINE = '(collie|poodle|tosa)'

KERNEL2418 = "2.4.18-rmk7-pxa3-embedix"
KERNEL2420 = "2.4.20"

PV_collie = "${KERNEL2418}"
PV_poodle = "${KERNEL2418}"
PV_tosa   = "${KERNEL2418}"
PV_akita  = "${KERNEL2420}"
PV_borzoi = "${KERNEL2420}"
PV_spitz  = "${KERNEL2420}"

SRC_URI = "http://openzaurus.sf.net/mirror/sd-modules-2.4.18-rmk7-pxa3-embedix-r4.tar.bz2 \
           file://sd \
           file://sdmgr \
           file://sdcontrol"

S = "${WORKDIR}"

inherit module-base update-rc.d

INITSCRIPT_NAME = "sd"
INITSCRIPT_PARAMS = "start 39 S . stop 96 0 1 6 ."

do_install() {
        install -d ${D}${sysconfdir}/init.d \
                   ${D}${sysconfdir}/default \
                   ${D}${base_sbindir} \
                   ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/block/
                   
        install -m 0755 ${WORKDIR}/sdmgr ${D}${base_sbindir}/
        install -m 0755 ${WORKDIR}/sdcontrol ${D}${sysconfdir}
        install -m 0755 ${WORKDIR}/sd ${D}${sysconfdir}/init.d/
        install -m 0644 ${MACHINE}/sharp_mmcsd_m.o ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/block/
        echo "MODULE_FILE='${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/block/sharp_mmcsd_m.o'" > ${D}${sysconfdir}/default/sharp_sdmmc
}

FILES_${PN} = "/"
