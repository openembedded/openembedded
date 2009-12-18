inherit native

require ti-xdctools.inc

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/rtsc/${PV}/exports/xdctools_setuplinux_${PV}.bin;name=xdcbin"

do_stage() {
    install -d ${XDC_INSTALL_DIR}
    cp -pPrf ${S}/* ${XDC_INSTALL_DIR}
        chmod 755 -R  ${XDC_INSTALL_DIR}
        chmod 755 -R  ${S}
}


