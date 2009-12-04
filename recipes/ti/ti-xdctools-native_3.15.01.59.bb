inherit native

BASE_PV = "3_15"
PV = "3_15_01_59"

require ti-xdctools.inc

do_stage() {
    install -d ${STAGING_DIR_NATIVE}/${PN}
    cp -pPrf ${S}/* ${STAGING_DIR_NATIVE}/${PN}
        chmod 755 -R  ${STAGING_DIR_NATIVE}/${PN}
        chmod 755 -R  ${S}
}

AUTOTOOLS_NATIVE_STAGE_INSTALL="1"

