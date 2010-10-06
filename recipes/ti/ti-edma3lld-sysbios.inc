DESCRIPTION = "TI EDMA3 Low Level Driver (LLD) for SYSBIOS"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_tii/psp/edma3_lld"
SECTION = "devel"
LICENSE = "TI"

require ti-paths.inc
require ti-staging.inc
require ti-eula-unpack.inc

PR = "r1"

S = "${WORKDIR}/edma3_lld_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_tii/psp/edma3_lld/edma3-lld-bios6/${PV}/exports/EDMA3_LLD_setuplinux_${PV}.bin;name=edma3lldsysbiosbin"

BINFILE="EDMA3_LLD_setuplinux_${PV}.bin"
TI_BIN_UNPK_CMDS="Y:workdir"

do_install() {
    install -d ${D}${EDMA3_LLD_SYSBIOS_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${EDMA3_LLD_SYSBIOS_INSTALL_DIR_RECIPE}
}

