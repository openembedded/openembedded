DESCRIPTION = "Codec Engine for TI ARM/DSP processors"

# compile time dependencies
DEPENDS = "ti-xdctools-native ti-xdais-native ti-linuxutils ti-framework-components"
DEPENDS_append_dm6446 = " ti-cgt6x-native ti-dspbios-native"
DEPENDS_append_omap3 = "  ti-cgt6x-native ti-dspbios-native"

BASE_SRC_URI = "http://install.source.dir.local"
SRC_URI = "${BASE_SRC_URI}/codec_engine_${PV},lite.tar.gz "

# Set the source directory
S = "${WORKDIR}/codec_engine_${PV}"

do_compile () {
        echo "! Do not rebuild for now !"
}

# stage tree - other packages may need this
do_stage() {
    install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}
    cp -pPrf ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"


INHIBIT_PACKAGE_STRIP = "1"
