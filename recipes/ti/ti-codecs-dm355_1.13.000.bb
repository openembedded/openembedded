DESCRIPTION = "TI Codecs for DM355"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent"
SECTION = "multimedia"
LICENSE = "TI"

# TODO :: Move to common .inc

PV = "1_13_000"

SRC_URI[dm355codecsbin.md5sum] = "f6221188bea76b7aaf0c45e9bcf26329"
SRC_URI[dm355codecsbin.sha256sum] = "f1a6dea51be9798903a0543fb50f463b0594b1f11b897bc50e40825fb7527c61"

PR = "r17"

require ti-paths.inc
require ti-staging.inc
require ti-eula-unpack.inc

PROVIDES += "ti-codecs-dm355-server"

S = "${WORKDIR}/dm355_codecs_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/dvsdk/codecs/${BINFILE};name=dm355codecsbin \
           file://mapdmaq \
"

BINFILE = "dm355_codecs_setuplinux_${PV}.bin"
TI_BIN_UNPK_CMDS = "y:Y: qY:workdir"

do_compile() {
    echo "Do Nothing" 
}

do_install() {

    install -d ${D}/${installdir}/ti-codecs-server
    cd ${S}

    install -m 0755 ${WORKDIR}/mapdmaq ${D}/${installdir}/ti-codecs-server

    install -d ${D}${CODEC_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${CODEC_INSTALL_DIR_RECIPE}
}

PACKAGES += "ti-codecs-dm355-server"
FILES_ti-codecs-dm355-server = "${installdir}/ti-codecs-server/*"

INSANE_SKIP_ti-codecs-dm355-server = True
