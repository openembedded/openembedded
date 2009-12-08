DESCRIPTION = "DM365 Codecs"

BASE_SRC_URI = "http://install.source.dir.local"
SRC_URI	= "${BASE_SRC_URI}/dm365_codecs_${PV}.tar.gz"

S = "${WORKDIR}/dm365_codecs_${PV}"

do_compile() {
	echo "Do nothing"
}

do_install () {
     # install mapdmaq on target
     install -d ${D}/${installdir}/codecs
}

do_stage() {
    install -d ${CODEC_INSTALL_DIR}
    cp -pPrf ${S}/* ${CODEC_INSTALL_DIR}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES_${PN} = "${installdir}/codecs"
INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} = True

