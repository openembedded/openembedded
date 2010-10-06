DESCRIPTION = "TI EDMA3 Low Level Driver (LLD)"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/${SRC_URI_edma3lldsite}/edma3_lld"
SECTION = "devel"
LICENSE = "TI"

require ti-paths.inc
require ti-staging.inc
require ti-eula-unpack.inc

PR = "r1"

S = "${WORKDIR}/edma3_lld_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/${SRC_URI_edma3lldsite}/edma3_lld/edma3-lld-bios5/${PV}/exports/EDMA3_LLD_setuplinux_${PV}.bin;name=edma3lldbin"

BINFILE="EDMA3_LLD_setuplinux_${PV}.bin"
TI_BIN_UNPK_CMDS="Y:workdir"

do_install() {
    install -d ${D}${EDMA3_LLD_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${EDMA3_LLD_INSTALL_DIR_RECIPE}
}

