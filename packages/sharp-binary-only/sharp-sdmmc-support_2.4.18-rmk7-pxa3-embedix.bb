DESCRIPTION = "Driver for the SHARP Zaurus SD/MMC Slot for linux ${PV}"
SECTION = "kernel/modules"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "CLOSED"
RDEPENDS = "kernel (${KERNEL_VERSION})"
PR = "r12"

SRC_URI = "http://www.openzaurus.org/mirror/sd-modules-2.4.18-rmk7-pxa3-embedix-r1.tar.bz2 \
	   file://sd \
	   file://sdmgr \
	   file://sdcontrol"
S = "${WORKDIR}"

inherit module-base update-rc.d

INITSCRIPT_NAME = "sd"
INITSCRIPT_PARAMS = "start 39 S . stop 96 0 1 6 ."

do_install() {
	install -d ${D}/etc/init.d ${D}/sbin
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/block/
	install -m 0755 ${WORKDIR}/sdmgr ${D}/sbin/
	install -m 0755 ${WORKDIR}/sdcontrol ${D}/${sysconfdir}
	install -m 0755 ${WORKDIR}/sd ${D}/etc/init.d/
	install -m 0644 ${MACHINE}/sharp_mmcsd_m.o ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/block/
}

FILES_${PN} = "/"

PACKAGE_ARCH = "${MACHINE_ARCH}"
