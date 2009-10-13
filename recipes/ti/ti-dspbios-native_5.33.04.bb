require ti-dspbios.inc
inherit native

# download bios_setuplinux_5_33_04.bin from https://www-a.ti.com/downloads/sds_support/targetcontent/bios/bios_5_33/bios_5_33_04/index_external.html and copy in Arago (or OE) installation directory

SRC_URI	= "http://install.source.dir.local/bios_setuplinux_5_33_04.bin"
BINFILE="bios_setuplinux_5_33_04.bin"

S = "${WORKDIR}/bios_5_33_04"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "5334"
PR = "r2"

do_stage() {
    install -d ${STAGING_DIR_NATIVE}/${PN}
    cp -pPrf ${S}/* ${STAGING_DIR_NATIVE}/${PN}/ 
    chmod 755 -R ${STAGING_DIR_NATIVE}/${PN}/*
}

AUTOTOOLS_NATIVE_STAGE_INSTALL="1"

