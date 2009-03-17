DESCRIPTION = "Driver for Ralink rt73 USB 802.11g WiFi sticks found in the Chumby"
HOMEPAGE = "http://www.chumby.com"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r2"

SRC_URI="http://files.chumby.com/source/ironforge/build396/${PN}-${PV}.tar.gz"

inherit module
 
S = "${WORKDIR}/wifi/rt73/Module/"

EXTRA_OEMAKE = "KERNDIR=${STAGING_KERNEL_DIR}"

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra
        install -m 0644 rt73${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
        install -d ${D}${sysconfdir}/Wireless/RT73STA/
	install -m 0644 rt73.bin ${D}${sysconfdir}/Wireless/RT73STA/
}

