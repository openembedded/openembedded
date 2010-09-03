DESCRIPTION = "Ralink 3572"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
PR = "r0"

inherit module

SRC_URI = "http://sources.openembedded.org/2010_0709_RT3572_Linux_STA_v${PV}.tar.bz2 \
           file://makefile.patch \
           file://config.patch \
	 "

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR}"

S = "${WORKDIR}/2010_0709_RT3572_Linux_STA_v${PV}"

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -m 0644 ${S}/os/linux/rt3572sta.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -d ${D}/etc/Wireless/RT2870STA
	install -m 0644 ${S}/RT2870STA.dat ${D}/etc/Wireless/RT2870STA
	install -d ${D}/lib/firmware
	install -m 0644 ${S}/common/*.bin ${D}/lib/firmware/
}

PACKAGES =+ "${PN}-firmware"
FILES_${PN}-firmware = "/etc /lib/firmware"

RDEPENDS_${PN} = "${PN}-firmware"

SRC_URI[md5sum] = "ae16d9a445591bbea5a234bdfc64a826"
SRC_URI[sha256sum] = "870acc786d0c756b3d5854dd21dd1a7b03256edba1b6c343d0ffd73bc63274ce"
