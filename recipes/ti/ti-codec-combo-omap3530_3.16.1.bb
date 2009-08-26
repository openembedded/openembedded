require ti-codec.inc
require ti-codec-combo-omap3530.inc

SRC_URI	= "http://software-dl.ti.com/sdo/sdo_apps_public_sw/omap3530_dvsdk_combos_tspa/omap3530_dvsdk_combos_tspa-3_16_01-Linux-x86.bin"

# Specify names of the InstallJammer binary file and the tarball it extracts
BINFILE = "omap3530_dvsdk_combos_tspa-3_16_01-Linux-x86.bin"
TARFILE = "omap3530_dvsdk_combos_tspa/omap3530_dvsdk_combos_tspa_3_16_01.tar.gz"

S = "${WORKDIR}/omap3530_dvsdk_combos_tspa_3_16_01"

DEPENDS="ti-codec-engine ti-dsplink-module"

CODEC_INSTALL_DIR = "${S}"

export CODEGEN_INSTALL_DIR

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "3161"
PR = "r17"
do_compile() {
	make CE_INSTALL_DIR=${CE_INSTALL_DIR} \
		 FC_INSTALL_DIR=${FC_INSTALL_DIR} \
		 LINK_INSTALL_DIR=${LINK_INSTALL_DIR} \
		 CMEM_INSTALL_DIR=${CMEM_INSTALL_DIR} \
		 LPM_INSTALL_DIR=${LPM_INSTALL_DIR} \
	     BIOS_INSTALL_DIR=${BIOS_INSTALL_DIR} \
		 CODEGEN_INSTALL_DIR=${CODEGEN_INSTALL_DIR} \
	     CODEC_INSTALL_DIR=${CODEC_INSTALL_DIR} \
		 XDC_INSTALL_DIR=${XDC_INSTALL_DIR} clean

	make CE_INSTALL_DIR=${CE_INSTALL_DIR} \
		 FC_INSTALL_DIR=${FC_INSTALL_DIR} \
		 LINK_INSTALL_DIR=${LINK_INSTALL_DIR} \
		 CMEM_INSTALL_DIR=${CMEM_INSTALL_DIR} \
		 LPM_INSTALL_DIR=${LPM_INSTALL_DIR} \
	     BIOS_INSTALL_DIR=${BIOS_INSTALL_DIR} \
		 CODEGEN_INSTALL_DIR=${CODEGEN_INSTALL_DIR} \
	     CODEC_INSTALL_DIR=${CODEC_INSTALL_DIR} \
		 XDC_INSTALL_DIR=${XDC_INSTALL_DIR} 
}

do_install () {
    install -d ${D}/${installdir}/codec-combo
	cd ${S}
	for file in `find . -name *.x64P`; do
		cp ${file} ${D}/${installdir}/codec-combo
	done
}


