require ti-paths.inc
require ti-edma3lld.inc
inherit native

SRC_URI	= "http://something/EDMA3_LLD_setuplinux_${PV}.tar.gz;name=edma3lldtarball"
#http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/edma3_lld/EDMA3-BIOS5-LLD/01_11/edma3_lld_01_11/EDMA3_LLD_setuplinux_${PV}.bin;name=edma3lldbin"

#BINFILE="EDMA3_LLD_setuplinux_${PV}.bin"

S = "${WORKDIR}/edma3_lld_${PV}"

do_stage() {
    install -d ${STAGING_DIR_NATIVE}/ti-edma3lld
    cp -pPrf ${S}/* ${STAGING_DIR_NATIVE}/ti-edma3lld
}


