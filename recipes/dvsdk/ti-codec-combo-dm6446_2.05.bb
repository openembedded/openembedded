DESCRIPTION = "DM6446 Codec Combo 2.05"

# Should be replaced with real http URL, but for now create codec combo tar from DVSDK installation.
SRC_URI	= "http://install.source.dir.com/dm6446_dvsdk_combos_2_05.tar.gz"

S = "${WORKDIR}/dm6446_dvsdk_combos_2_05"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "205"
PR = "r11"

installdir = "${datadir}/ti"
do_compile() {
	echo "do nothing"
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
FILES_${PN} = "/${installdir}/codec-combo/*"

