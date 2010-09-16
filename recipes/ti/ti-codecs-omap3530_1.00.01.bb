DESCRIPTION = "TI Codecs (and Server Combo) for OMAP3530"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent"
SECTION = "multimedia"
LICENSE = "TI"

# TODO :: Move to common .inc (omap3 and omapl ready)

PV = "1_00_01"

SRC_URI[omap3codecsbin.md5sum] = "4db567252e6c43119e1c0aafe401a679"
SRC_URI[omap3codecsbin.sha256sum] = "e042e1aad42a6728adf5c955dc38e4f8331fc0eacd833f1cd75d9cbb4faff0b5"

PE = "1"
PR = "${MACHINE_KERNEL_PR}"
PR_append = "a"

require ti-paths.inc
require ti-staging.inc
require ti-eula-unpack.inc

PROVIDES += "ti-codecs-omap3530-server"
RREPLACES_${PN} = "ti-cs1-omap3530"

S = "${WORKDIR}/dvsdk_3_00_02_44/cs1omap3530_1_00_01"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/dvsdk/DVSDK_3_00/3_00_02_44/exports/cs1omap3530_setuplinux_1_00_01-44.bin;name=omap3codecsbin"

BINFILE = "cs1omap3530_setuplinux_1_00_01-44.bin"
TI_BIN_UNPK_CMDS = "Y:Y: qY:workdir"

DEPENDS = "ti-cgt6x ti-xdctools ti-dspbios ti-codec-engine ti-linuxutils"

#generic codec
DSPSUFFIX_omap3 = "x64P"

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

PACKAGES += "ti-codecs-omap3530-server"
FILES_ti-codecs-omap3530-server = "${installdir}/ti-codecs-server/*"
