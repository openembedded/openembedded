require ti-dspbios.inc
inherit native

SRC_URI	= "http://install.source.dir.com/bios_setuplinux_5_33_02.bin"
BINFILE="bios_setuplinux_5_33_02.bin"

S = "${WORKDIR}/bios_5_33_02"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "533"
PR = "r13"

do_stage() {
    install -d ${STAGING_DIR_NATIVE}/${PN}
    cp -pPrf ${S}/* ${STAGING_DIR_NATIVE}/${PN}/ 
}

AUTOTOOLS_NATIVE_STAGE_INSTALL="1"

