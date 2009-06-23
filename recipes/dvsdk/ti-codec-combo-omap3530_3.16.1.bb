DESCRIPTION = "OMAP3530 TSPA codec combo 3.16.01"

require ti-codec-combo-omap3530.inc

SRC_URI	= "http://software-dl.ti.com/sdo/sdo_apps_public_sw/omap3530_dvsdk_combos_tspa/omap3530_dvsdk_combos_tspa-3_16_01-Linux-x86.bin"

# Specify names of the InstallJammer binary file and the tarball it extracts
BINFILE = "omap3530_dvsdk_combos_tspa-3_16_01-Linux-x86.bin"
TARFILE = "omap3530_dvsdk_combos_tspa/omap3530_dvsdk_combos_tspa_3_16_01.tar.gz"

S = "${WORKDIR}/omap3530_dvsdk_combos_tspa_3_16_01"

DEPENDS="ti-codec-engine"

CE_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine"
FC_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"
LINK_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"
CMEM_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"
LPM_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"
BIOS_INSTALL_DIR="${STAGING_DIR_NATIVE}/ti-dspbios-native"
CODEGEN_INSTALL_DIR="${STAGING_DIR_NATIVE}/ti-cgt6x-native"
XDC_INSTALL_DIR="${STAGING_DIR_NATIVE}/ti-xdctools-native"

export ${CODEGEN_INSTALL_DIR}

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "3161"
PR = "r12"
installdir = "${datadir}/ti"

do_compile() {
	make CE_INSTALL_DIR=${CE_INSTALL_DIR} \
		 FC_INSTALL_DIR=${FC_INSTALL_DIR} \
		 LINK_INSTALL_DIR=${LINK_INSTALL_DIR} \
		 CMEM_INSTALL_DIR=${CMEM_INSTALL_DIR} \
		 LPM_INSTALL_DIR=${LPM_INSTALL_DIR} \
	     BIOS_INSTALL_DIR=${BIOS_INSTALL_DIR} \
		 CODEGEN_INSTALL_DIR=${CODEGEN_INSTALL_DIR} \
		 XDC_INSTALL_DIR=${XDC_INSTALL_DIR} \
}

do_install () {
    install -d ${D}/${installdir}/codec-combo
	cd ${S}
	for file in `find . -name *.x64P`; do
		cp ${file} ${D}/${installdir}/codec-combo
	done
}

do_stage() {
    install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}
    cp -pPrf ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}/ 
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} = "${installdir}/codec-combo/*"

