DESCRIPTION = "TI Codec for ${MACHINE_ARCH}"

require ti-paths.inc

do_stage() {
    install -d ${CODEC_INSTALL_DIR}
    cp -pPrf ${S}/* ${CODEC_INSTALL_DIR}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} = "${installdir}/codec-combo/*"

