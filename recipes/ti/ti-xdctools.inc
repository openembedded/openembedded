DESCRIPTION = "TI XDC tool"

SRC_URI	= "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/rtsc/xdctools_${BASE_PV}/exports/xdctools_setuplinux_${PV}.bin"
BINFILE="xdctools_setuplinux_${PV}.bin"

S = "${WORKDIR}/xdctools_${PV}"

TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"

require ti-paths.inc
require ti-eula-unpack.inc
require ti-staging.inc

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/rtsc/${PV}/exports/xdctools_setuplinux_${PV}.bin;name=xdcbin"

do_install() {
    chmod 755 -R  ${S}
    install -d ${D}${XDC_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${XDC_INSTALL_DIR_RECIPE}
}


