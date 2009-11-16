require ti-codec.inc

SRC_URI	= "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/dvsdk/DVSDK_3_00/latest//exports/cs1omap3530_setuplinux_1_00_01-42.bin"

# Specify names of the InstallJammer binary file and the tarball it extracts
BINFILE = "cs1omap3530_setuplinux_1_00_01-42.bin"
TI_BIN_UNPK_CMDS = "Y:Y: qY:workdir"

require ti-eula-unpack.inc

S = "${WORKDIR}/dvsdk_3_00_01_42/cs1omap3530_1_00_01"

DEPENDS="ti-codec-engine ti-linuxutils"

export CODEGEN_INSTALL_DIR

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "1_00_1"
PR = "r5"

do_compile() {

	make CE_INSTALL_DIR=${CE_INSTALL_DIR} \
		 FC_INSTALL_DIR=${FC_INSTALL_DIR} \
		 LINK_INSTALL_DIR=${LINK_INSTALL_DIR} \
		 CMEM_INSTALL_DIR=${CMEM_INSTALL_DIR} \
		 LPM_INSTALL_DIR=${LPM_INSTALL_DIR} \
	     BIOS_INSTALL_DIR=${BIOS_INSTALL_DIR} \
		 CODEGEN_INSTALL_DIR=${CODEGEN_INSTALL_DIR} \
		 XDC_INSTALL_DIR=${XDC_INSTALL_DIR} \
		 CODEC_INSTALL_DIR="${S}" \
		 XDCARGS="prod" \
		 clean

	make CE_INSTALL_DIR=${CE_INSTALL_DIR} \
		 FC_INSTALL_DIR=${FC_INSTALL_DIR} \
		 LINK_INSTALL_DIR=${LINK_INSTALL_DIR} \
		 CMEM_INSTALL_DIR=${CMEM_INSTALL_DIR} \
		 LPM_INSTALL_DIR=${LPM_INSTALL_DIR} \
	     BIOS_INSTALL_DIR=${BIOS_INSTALL_DIR} \
		 CODEGEN_INSTALL_DIR=${CODEGEN_INSTALL_DIR} \
		 XDC_INSTALL_DIR=${XDC_INSTALL_DIR} \
		 CODEC_INSTALL_DIR="${S}" \
		 XDCARGS="prod" \
}

do_install () {
    install -d ${D}/${installdir}/codec-combo
	cd ${S}
	for file in `find . -name *.x64P`; do
		cp ${file} ${D}/${installdir}/codec-combo
	done
}


