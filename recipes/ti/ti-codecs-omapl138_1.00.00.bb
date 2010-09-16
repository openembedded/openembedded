DESCRIPTION = "TI Codecs (and Server Combo) for OMAPL138"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent"
SECTION = "multimedia"
LICENSE = "TI"

# TODO :: Move to common .inc (omap3 and omapl ready)

PV = "1_00_00"

SRC_URI[l138codecsbin.md5sum] = "64a53cd55bc63d3a6f4db742aff90de9"
SRC_URI[l138codecsbin.sha256sum] = "4fb1075ad83f6017616410eff35ada7d567f1ee1b5b23624a817e8fc7dda3f8a"

PR = "${MACHINE_KERNEL_PR}"
PR_append = "a"

require ti-paths.inc
require ti-staging.inc
require ti-eula-unpack.inc

PROVIDES += "ti-codecs-omapl138-server"

S = "${WORKDIR}/OMAP_L138_arm_1_00_00_08/cs1omapl138_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/sdk/omap_l138/1_00/latest/exports/${BINFILE};name=l138codecsbin \
           file://ti-codecs-omapl138-1-00-00-fixDman3Config.patch"

BINFILE = "cs1omapl138_${PV}-v2_setup_linux.bin"
TI_BIN_UNPK_CMDS = "y:Y: qY:workdir"

DEPENDS = "ti-cgt6x ti-xdctools ti-dspbios ti-codec-engine ti-linuxutils"

#generic codec
DSPSUFFIX_omapl138 = "x64P"

do_prepsources() {

	make \
             CE_INSTALL_DIR=${CE_INSTALL_DIR} \
             FC_INSTALL_DIR=${FC_INSTALL_DIR} \
             LINK_INSTALL_DIR=${LINK_INSTALL_DIR} \
             CMEM_INSTALL_DIR=${CMEM_INSTALL_DIR} \
             LPM_INSTALL_DIR=${LPM_INSTALL_DIR} \
             BIOS_INSTALL_DIR=${BIOS_INSTALL_DIR} \
             CODEGEN_INSTALL_DIR=${CODEGEN_INSTALL_DIR} \
             XDC_INSTALL_DIR=${XDC_INSTALL_DIR} \
             CODEC_INSTALL_DIR="${S}" \
             XDCARGS="prod" \
             clean
}

addtask prepsources after do_configure before do_compile

do_compile() {

	make \
             CE_INSTALL_DIR=${CE_INSTALL_DIR} \
             FC_INSTALL_DIR=${FC_INSTALL_DIR} \
             LINK_INSTALL_DIR=${LINK_INSTALL_DIR} \
             CMEM_INSTALL_DIR=${CMEM_INSTALL_DIR} \
             LPM_INSTALL_DIR=${LPM_INSTALL_DIR} \
             BIOS_INSTALL_DIR=${BIOS_INSTALL_DIR} \
             CODEGEN_INSTALL_DIR=${CODEGEN_INSTALL_DIR} \
             XDC_INSTALL_DIR=${XDC_INSTALL_DIR} \
             CODEC_INSTALL_DIR="${S}" \
             XDCARGS="prod" \
             all
}

do_install() {

    install -d ${D}/${installdir}/ti-codecs-server
    cd ${S}

    # Install the DSP Server Binary 
    for file in `find . -name *.${DSPSUFFIX}`; do
        cp ${file} ${D}/${installdir}/ti-codecs-server
    done

    # Install docs (codec qualiTI test reports, server config datasheet, etc)
    for file in `find . -name *.html`; do
        cp ${file} ${D}/${installdir}/ti-codecs-server
    done

    install -d ${D}${CODEC_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${CODEC_INSTALL_DIR_RECIPE}
}

PACKAGES += "ti-codecs-omapl138-server"
FILES_ti-codecs-omapl138-server = "${installdir}/ti-codecs-server/*"


