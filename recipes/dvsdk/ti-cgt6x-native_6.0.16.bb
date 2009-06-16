require ti-cgt6x.inc
inherit native

SRC_URI	= "http://install.source.dir.com/TI-C6x-CGT-v6.0.16-eval.tar.gz"

S = "${WORKDIR}/cg6x_6_0_16"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "6016"
PR = "r12"

do_stage() {
    install -d ${STAGING_DIR_NATIVE}/${PN}
    cp -pPrf ${S}/* ${STAGING_DIR_NATIVE}/${PN}/ 
}

AUTOTOOLS_NATIVE_STAGE_INSTALL="1"

