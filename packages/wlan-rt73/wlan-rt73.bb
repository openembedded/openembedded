DESCRIPTION = "Driver for Ralink rt73 USB 802.11b/g WiFi sticks"
HOMEPAGE = "http://rt2x00.serialmonkey.com/"
SECTION = "kernel/modules"
LICENSE = "GPL"

SRCDATE = "20080521"
PR = "r1"

SRC_URI = "cvs://anonymous@rt2400.cvs.sourceforge.net/cvsroot/rt2400;module=source/rt73"

RDEPEND = "wireless-tools"

inherit module

FILES_${PN} += " /lib/firmware/rt73.bin"

S = "${WORKDIR}/rt73/Module/"

EXTRA_OEMAKE = "KERNDIR=${STAGING_KERNEL_DIR}"

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra
        install -m 0644 rt73${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
        install -d ${D}/lib/firmware
        install -m 0644 rt73.bin ${D}/lib/firmware/
}

