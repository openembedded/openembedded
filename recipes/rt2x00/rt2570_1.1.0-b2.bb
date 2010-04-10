DESCRIPTION = "Driver for Ralink rt2570 USB 802.11g WiFi sticks"
HOMEPAGE = "http://rt2x00.serialmonkey.com/"
SECTION = "kernel/modules"
LICENSE = "GPL"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/rt2400/rt2570-${PV}.tar.gz"

inherit module

S = "${WORKDIR}/${PN}-${PV}/Module/"

EXTRA_OEMAKE = "KERNDIR=${STAGING_KERNEL_DIR}"

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra
	install -m 0644 rt2570${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
}

SRC_URI[md5sum] = "f4131d670920a878b4d4a0f5d4d8b93a"
SRC_URI[sha256sum] = "a677291149687339396fed06c46cc08fd76fcb62d0f4459cae02c6cf54b4eb39"
