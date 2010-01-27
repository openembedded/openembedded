DESCRIPTION = "Driver for Ralink rt3070 USB 802.11abgn WiFi sticks"
SECTION = "kernel/modules"
LICENSE = "GPL"

PR = "r0"

TMP = "2009_1110_RT3070_Linux_STA_v${PV}.0"

SRC_URI = "http://ynezz.ibawizard.net/dump/${TMP}.tar.bz2;name=tarball \
           file://makefile.patch;patch=1 \
           file://add-belkin-F6D4050v2.patch;patch=1 \
"

SRC_URI[tarball.md5sum] = "01a4d6804fff2a76584d20f7c21b1af4"
SRC_URI[tarball.sha256sum] = "46723d7284360435a9d5769ac1f81fb7f6058c393bb0625dc3fa0a2f282feadd"

inherit module

S = "${WORKDIR}/${TMP}"

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR}"

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/net/wireless
	install -d ${D}${sysconfdir}/Wireless/RT2870STA
	install -m 0644 ${S}/${PN}sta${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/drivers/net/wireless
	touch ${D}${sysconfdir}/Wireless/RT2870STA/RT2870STA.dat
}
