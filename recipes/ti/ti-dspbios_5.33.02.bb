require ti-dspbios.inc

# download bios_setuplinux_5_33_02.bin from https://www-a.ti.com/downloads/sds_support/targetcontent/bios/bios_5_33/bios_5_33_02/index_external.html and copy in Arago/OE installation directory

SRC_URI	= "http://install.source.dir.local/bios_setuplinux_5_33_02.bin"
BINFILE="bios_setuplinux_5_33_02.bin"

S = "${WORKDIR}/bios_5_33_02"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "5_33_02"
PR = "r14"

do_install() {
    install -d ${BIOS_INSTALL_DIR}
    cp -pPrf ${S}/* ${BIOS_INSTALL_DIR}
}


