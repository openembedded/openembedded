DEPENDS="ti-codec-engine ti-linuxutils"

require ti-codec.inc

SRC_URI	= "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/S1SDKLNX/DVSDK_2_00/exports/dm6446_codecs_setuplinux_2_00_00_22.bin"

S = "${WORKDIR}/dvsdk_2_00_00_22/dm6446_dvsdk_combos_2_05"
BINFILE = "dm6446_codecs_setuplinux_2_00_00_22.bin"
TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"

require ti-eula-unpack.inc

export ${CODEGEN_INSTALL_DIR}

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "205"
PR = "r15"

do_configure () {
	find . -name *.x64P | xargs rm -rf {} 
}

do_compile() {
	make BIOS_INSTALL_DIR=${BIOS_INSTALL_DIR} \
		XDC_INSTALL_DIR=${XDC_INSTALL_DIR} \
		CE_INSTALL_DIR=${CE_INSTALL_DIR} \
		FC_INSTALL_DIR=${FC_INSTALL_DIR} \
		CMEM_INSTALL_DIR=${CMEM_INSTALL_DIR} \
		XDAIS_INSTALL_DIR=${XDAIS_INSTALL_DIR} \
		LINK_INSTALL_DIR=${LINK_INSTALL_DIR} \
		CODEGEN_INSTALL_DIR=${CODEGEN_INSTALL_DIR} \
		XDCARGS=\"eval\"
}

do_install () {
    install -d ${D}/${installdir}/codec-combo
	cd ${S}
	for file in `find . -name *.x64P`; do
		cp ${file} ${D}/${installdir}/codec-combo
	done
}

