DESCRIPTION = "TI EDMA3 Low Level Driver (LLD) for SYSBIOS"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_tii/psp/edma3_lld"
SECTION = "devel"
LICENSE = "TI"

require ti-paths.inc
require ti-staging.inc

PR = "r1"

S = "${WORKDIR}/edma3_lld_${PV}"

do_install() {
    install -d ${D}${EDMA3_LLD_SYSBIOS_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${EDMA3_LLD_SYSBIOS_INSTALL_DIR_RECIPE}
}

