DESCRIPTION = "TI DSP/BIOS v5 Kernel"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/bios/dspbios"

require ti-paths.inc
require ti-staging.inc
require ti-eula-unpack.inc

S = "${WORKDIR}/bios_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/bios/dspbios/${PV}/exports/bios_setuplinux_${PV}.bin;name=biosbin"

BINFILE="bios_setuplinux_${PV}.bin"
TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"

do_install() {
    install -d ${D}${BIOS_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${BIOS_INSTALL_DIR_RECIPE}
}

