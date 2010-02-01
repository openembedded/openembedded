require ti-codec.inc

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/dvsdk/DVSDK_3_00/3_00_02_44/exports/cs1omap3530_setuplinux_1_00_01-44.bin;name=cs1omaptarball"

SRC_URI[cs1omaptarball.md5sum] = "4db567252e6c43119e1c0aafe401a679"
SRC_URI[cs1omaptarball.sha256sum] = "e042e1aad42a6728adf5c955dc38e4f8331fc0eacd833f1cd75d9cbb4faff0b5"

# Specify names of the InstallJammer binary file and the tarball it extracts
BINFILE = "cs1omap3530_setuplinux_1_00_01-44.bin"
TI_BIN_UNPK_CMDS = "Y:Y: qY:workdir"

require ti-eula-unpack.inc

S = "${WORKDIR}/dvsdk_3_00_02_44/cs1omap3530_1_00_01"

DEPENDS="ti-codec-engine ti-linuxutils"
RREPLACES_${PN} = "ti-cs1-omap3530"

export CODEGEN_INSTALL_DIR

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "1_00_01_44"
PR = "r6"

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
