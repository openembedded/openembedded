DESCRIPTION = "TI Codecs for DM355"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent"
SECTION = "multimedia"
LICENSE = "TI"

# TODO :: Move to common .inc

PV = "3_10_00_00"

SRC_URI[dm355codecsbin.md5sum] = "4754892642d44aea67f43dee446ea1f7"
SRC_URI[dm355codecsbin.sha256sum] = "bad458c49543f585d7f55c3bcd63816613fa730522534b9959c49cdd7fb76492"

PR = "r1"

require ti-paths.inc
require ti-staging.inc

PROVIDES += "ti-codecs-dm355-server"

S = "${WORKDIR}/dm355_codecs_0${PV}"

SRC_URI = "ftp://gtftp01.gt.design.ti.com/arago/dm355_codecs_0${PV}.tar.gz;name=dm355codecsbin \
           file://mapdmaq \
"

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
