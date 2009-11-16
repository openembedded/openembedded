DESCRIPTION = "DM355 Codecs"

BASE_SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/dvsdk/codecs"
SRC_URI = "${BASE_SRC_URI}/dm355_codecs_setuplinux_${PV}.bin \
                   file://mapdmaq \
                 "

S = "${WORKDIR}/dm355_codecs_${PV}"

require ti-paths.inc

BINFILE = "dm355_codecs_setuplinux_${PV}.bin"
TI_BIN_UNPK_CMDS = "Y:Y: qY:workdir"

require ti-eula-unpack.inc

do_compile() {
        echo "Do nothing"
}

do_install () {
     # install mapdmaq on target
     install -d ${D}/${installdir}/codecs
     install -m 0755 ${WORKDIR}/mapdmaq ${D}/${installdir}/codecs
}

do_stage() {
    install -d ${CODEC_INSTALL_DIR}
    cp -pPrf ${S}/* ${CODEC_INSTALL_DIR}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = "${installdir}/codecs/mapdmaq"

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} = "True"
