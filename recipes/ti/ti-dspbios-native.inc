require ti-paths.inc
require ti-dspbios.inc
inherit native

SRC_URI	= "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/bios/dspbios/${PV}/exports/bios_setuplinux_${PV}.bin;name=biosbin"

BINFILE="bios_setuplinux_${PV}.bin"

S = "${WORKDIR}/bios_${PV}"

do_stage() {
    install -d ${BIOS_INSTALL_DIR}
    cp -pPrf ${S}/* ${BIOS_INSTALL_DIR}
    chmod 755 -R ${BIOS_INSTALL_DIR}/*
}

AUTOTOOLS_NATIVE_STAGE_INSTALL="1"

