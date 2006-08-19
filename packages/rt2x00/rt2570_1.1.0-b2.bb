DESCRIPTION = "Driver for Ralink rt2570 USB 802.11g WiFi sticks"
HOMEPAGE = "http://rt2x00.serialmonkey.com/"
SECTION = "kernel/modules"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/rt2400/rt2570-${PV}.tar.gz"

inherit module

S = "${WORKDIR}/${PN}-${PV}/Module/"

EXTRA_OEMAKE = "KERNDIR=${STAGING_KERNEL_DIR}"

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra
	install -m 0644 rt2570${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
}
