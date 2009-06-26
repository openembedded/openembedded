require ti-cgt6x.inc
inherit native

SRC_URI	= "http://install.source.dir.com/ti_cgt_c6000_6.0.21_setup_linux_x86.bin"

BINFILE="ti_cgt_c6000_6.0.21_setup_linux_x86.bin"

S = "${WORKDIR}/cgt"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "6021"
PR = "r3"

do_stage() {
    install -d ${STAGING_DIR_NATIVE}/${PN}
    cp -pPrf ${S}/* ${STAGING_DIR_NATIVE}/${PN}/ 
}

AUTOTOOLS_NATIVE_STAGE_INSTALL="1"

