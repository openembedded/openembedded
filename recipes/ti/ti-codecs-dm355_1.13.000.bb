DESCRIPTION = "TI Codecs for DM355"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent"
SECTION = "multimedia"

# TODO :: Move to common .inc

PV = "1_13_000"

SRC_URI[dm355codecsbin.md5sum] = "64a53cd55bc63d3a6f4db742aff90de9"
SRC_URI[dm355codecsbin.sha256sum] = "4fb1075ad83f6017616410eff35ada7d567f1ee1b5b23624a817e8fc7dda3f8a"

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

