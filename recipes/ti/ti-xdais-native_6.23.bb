require ti-xdais.inc

PV = "6_23"

inherit native

do_stage() {
    install -d ${STAGING_DIR_NATIVE}/ti-xdais
    cp -pPrf ${S}/* ${STAGING_DIR_NATIVE}/ti-xdais
}


