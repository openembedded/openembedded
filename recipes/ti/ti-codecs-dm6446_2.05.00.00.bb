DESCRIPTION = "TI Codecs (and Server Combo) for DM6446"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent"
SECTION = "multimedia"
LICENSE = "TI"

# TODO :: Move to common .inc (omap3 and omapl ready)
# TODO :: XDCARGS = eval in this server?

PV = "2_05_00_00"

SRC_URI[dm6446codecsbin.md5sum] = "2ce99015bb1ed1df0491403c5e8d99fb"
SRC_URI[dm6446codecsbin.sha256sum] = "6467ea4854abbff3cbc224df1f163d01c7fb387f15483129a40a1f68e6742b62"

PR = "r18"

require ti-paths.inc
require ti-staging.inc
require ti-eula-unpack.inc

PROVIDES += "ti-codecs-dm6446-server"

S = "${WORKDIR}/dvsdk_2_00_00_22/dm6446_dvsdk_combos_2_05"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/S1SDKLNX/DVSDK_2_00/exports/dm6446_codecs_setuplinux_2_00_00_22.bin;name=dm6446codecsbin"

BINFILE = "dm6446_codecs_setuplinux_2_00_00_22.bin"
TI_BIN_UNPK_CMDS = "Y: qY:workdir:Y"

DEPENDS = "ti-xdais ti-cgt6x ti-xdctools ti-dspbios ti-codec-engine ti-linuxutils"

#generic codec
DSPSUFFIX_dm6446 = "x64P"

# LINK_INSTALL_DIR already has 'packages' at the end
do_configure() {
         sed -i -e 's:(LINK_INSTALL_DIR)/packages:(LINK_INSTALL_DIR):g' ${S}/Makefile
}

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
             XDAIS_INSTALL_DIR="${XDAIS_INSTALL_DIR}" \
             BIOSUTILS_INSTALL_DIR="${BIOSUTILS_INSTALL_DIR}" \
             XDCARGS="eval" \
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
             XDAIS_INSTALL_DIR="${XDAIS_INSTALL_DIR}" \
             BIOSUTILS_INSTALL_DIR="${BIOSUTILS_INSTALL_DIR}" \
             XDCARGS="eval" \
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

PACKAGES += "ti-codecs-dm6446-server"
FILES_ti-codecs-dm6446-server = "${installdir}/ti-codecs-server/*"

