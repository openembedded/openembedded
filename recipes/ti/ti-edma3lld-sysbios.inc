DESCRIPTION = "TI EDMA3 Low Level Driver (LLD) for SYSBIOS"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_tii/psp/edma3_lld"
SECTION = "devel"
LICENSE = "TI"

require ti-paths.inc
require ti-staging.inc

PR = "r2"

S = "${WORKDIR}/edma3_lld_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_tii/psp/edma3_lld/edma3-lld-bios6/${PV}/exports/edma3_lld_${PV}.tar.gz"

do_install() {
    install -d ${D}${EDMA3_LLD_SYSBIOS_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${EDMA3_LLD_SYSBIOS_INSTALL_DIR_RECIPE}
}

