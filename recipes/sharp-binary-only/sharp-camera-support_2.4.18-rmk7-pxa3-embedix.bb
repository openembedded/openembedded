DESCRIPTION = "Driver for the SHARP CG-AG06 digital compact flash camera for linux ${PV}"
SECTION = "kernel/modules"
PRIORITY = "optional"
LICENSE = "CLOSED"
RDEPENDS = "kernel (${KERNEL_VERSION})"
PR = "r4"

SRC_URI = "http://openzaurus.sf.net/mirror/camera-modules-2.4.18-rmk7-pxa3-embedix.tar.bz2 \
           file://CE-AG06.dat \
           file://sharpzdc \
           file://sharpzdc.conf"
S = "${WORKDIR}"

COMPATIBLE_MACHINE = '(collie|poodle|tosa)'

inherit module-base

do_install() {
	install -d ${D}${sysconfdir}/pcmcia/cis
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/pcmcia
	install -m 0644 ${WORKDIR}/CE-AG06.dat ${D}${sysconfdir}/pcmcia/cis/
	install -m 0644 ${WORKDIR}/sharpzdc.conf ${D}${sysconfdir}/pcmcia/
	install -m 0755 ${WORKDIR}/sharpzdc ${D}${sysconfdir}/pcmcia/
	install -m 0644 ${MACHINE}/sharpzdc_cs.o ${D}${base_libdir}/modules/${KERNEL_VERSION}/pcmcia/
}

FILES_${PN} = "/"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI[md5sum] = "b28d863b340a27c507398f717bc752e2"
SRC_URI[sha256sum] = "97d19b84f695a7f58f84fe2b4e8e1a2cde164be869db82b4536b05a2b2d055d1"
