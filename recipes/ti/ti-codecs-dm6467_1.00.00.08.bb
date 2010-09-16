DESCRIPTION = "TI Codecs (and Server Combo) for DM6467"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent"
SECTION = "multimedia"
LICENSE = "TI"

# TODO :: Move to common .inc (omap3 and omapl ready)

PV = "1_00_00_08"

SRC_URI[dm6467codecsbin.md5sum] = "41b039978b18fc5214d31b477b7558c9"
SRC_URI[dm6467codecsbin.sha256sum] = "84c000d01ca6d8fd3389f44fb0daa47522995306f5546dc656afd8b1efc8ba79"

PR = "${MACHINE_KERNEL_PR}"
PR_append = "a"

require ti-paths.inc
require ti-staging.inc
require ti-eula-unpack.inc

PROVIDES += "ti-codecs-dm6467-server"

S = "${WORKDIR}/dvsdk/dvsdk_3_10_00_16/cs2dm6467_1_00_00_08"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/dvsdk/DVSDK_3_10/3_10_00_16/exports/cs2dm6467_1_00_00_08_Setup.bin;name=dm6467codecsbin"

BINFILE = "cs2dm6467_1_00_00_08_Setup.bin"
TI_BIN_UNPK_CMDS = "Y: qY:workdir:Y"

DEPENDS = "ti-cgt6x ti-xdctools ti-dspbios ti-codec-engine ti-linuxutils"

#generic codec
DSPSUFFIX_dm6467 = "x64P"

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

PACKAGES += "ti-codecs-dm6467-server"
FILES_ti-codecs-dm6467-server = "${installdir}/ti-codecs-server/*"

