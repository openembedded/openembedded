DESCRIPTION = "eDMA library for use by PRU sw example applications"
HOMEPAGE = "https://gforge.ti.com/gf/project/pru_sw/"
LICENSE = "BSD"
PR = "r2+svnr${SRCPV}"

DEPENDS += "virtual/kernel ti-pru-sw-edma-driver"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "omapl138"

SRC_URI = "svn://gforge.ti.com/svn/pru_sw/;module=trunk;proto=https;user=anonymous;pswd=''"

SRCREV = "24"
S = "${WORKDIR}/trunk/peripheral_lib/edma_driver/interface"

do_compile () {
	oe_runmake KERNEL_DIR="${STAGING_KERNEL_DIR}"
}

do_install () {
	install -d ${D}${libdir}
	install -d ${D}${includedir}
	install -m 0755 ${S}/../lib/libedmautils.a ${D}${libdir}/
	install -m 0644 ${S}/../include/edma.h ${D}${includedir}/
}
