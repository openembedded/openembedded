DESCRIPTION = "TI DSP/BIOS for Davinci and OMAP processor"

TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"

require ti-eula-unpack.inc
require ti-paths.inc
require ti-staging.inc

PE = "1"

SRC_URI	= "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/bios/dspbios/${PV}/exports/bios_setuplinux_${PV}.bin;name=biosbin"

BINFILE="bios_setuplinux_${PV}.bin"

S = "${WORKDIR}/bios_${PV}"

do_install() {
    chmod 755 -R ${S}
    install -d ${D}${BIOS_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${BIOS_INSTALL_DIR_RECIPE}
}


