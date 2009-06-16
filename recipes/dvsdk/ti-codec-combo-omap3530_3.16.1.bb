DESCRIPTION = "OMAP3530 TSPA codec combo 3.16.01"

require ti-codec-combo-omap3530.inc

SRC_URI	= "http://software-dl.ti.com/sdo/sdo_apps_public_sw/omap3530_dvsdk_combos_tspa/omap3530_dvsdk_combos_tspa-3_16_01-Linux-x86.bin"

# Specify names of the InstallJammer binary file and the tarball it extracts
BINFILE = "omap3530_dvsdk_combos_tspa-3_16_01-Linux-x86.bin"
TARFILE = "omap3530_dvsdk_combos_tspa/omap3530_dvsdk_combos_tspa_3_16_01.tar.gz"

S = "${WORKDIR}/omap3530_dvsdk_combos_tspa_3_16_01"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "3161"
PR = "r9"
installdir = "${prefix}/ti"

do_compile() {
  	echo "Do not rebuild for now"
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

