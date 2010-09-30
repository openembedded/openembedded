DESCRIPTION = "TI Codecs and Server Combo for OMAPL138"
SECTION = "multimedia"
LICENSE = "TI"

require ti-paths.inc
require ti-staging.inc

PR="r9"

PV="4_00_00_00"

CODEC_SUITE_NAME="${WORKDIR}/${PN}_${PV}"

SRCREV = "4dd14941ff514f30aaaeeebcde446e11de62e075"

require ti-eula-unpack.inc

SRC_URI="http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Video//C64XPlus_Video_latest/dm6446_h264enc_02_02_00_02_production.bin;name=h264enc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Video//C64XPlus_Video_latest/dm6446_h264dec_2_00_002_production.bin;name=h264dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Video//C64XPlus_Video_latest/c64xplus_jpegenc_02_00_01_00_production.bin;name=jpegenc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Video//C64XPlus_Video_latest/c64xplus_jpegdec_02_00_01_01_production.bin;name=jpegdec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Video//C64XPlus_Video_latest/c64xplus_mpeg2dec_02_00_02_00_production.bin;name=mpeg2dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Video//C64XPlus_Video_latest/c64xplus_mpeg4enc_02_02_04_production.bin;name=mpeg4enc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Video//C64XPlus_Video_latest/c64xplus_mpeg4dec_02_01_00_00_production.bin;name=mpeg4dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Audio//C64XPlus_Audio_latest/c64xplus_aachedec_01_30_03_00_production.bin;name=aachedec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Speech//C64XPlus_Speech_latest/c64xplus_g711_1_12_00_000_production.bin;name=g711 \
    git://arago-project.org/git/projects/codec-servers.git;protocol=git \

"

SRC_URI[h264enc.md5sum] = "54f914b9c49b9ed811980382b2002542"
SRC_URI[h264enc.sha256sum] = "34ba313d82c12483589951cbbb8687cc4f79b9e80b421ea97012a4b14c6784b6"

SRC_URI[h264dec.md5sum] = "b0e3b892e7725ea3daf14852959871cc"
SRC_URI[h264dec.sha256sum] = "9d0b32089b8945e0c439e79e22cc11abca7b7e5842715bdb663a3b811d10a1ff"

SRC_URI[jpegenc.md5sum] = "53a6ba0a2f13a91f8e31b36772689d95"
SRC_URI[jpegenc.sha256sum] = "57faa4b2bb0298f21a658d17c1bf31589676b01e55b174e87ec7b6966d1a3b27"

SRC_URI[jpegdec.md5sum] = "cf2886c3406ab41409a586e5d550918d"
SRC_URI[jpegdec.sha256sum] = "6b0c9f1b8f023070c6a59af690f015f84f2c7f3143235f788ddd1a4a7b229089"

SRC_URI[mpeg2dec.md5sum] = "da3d0561f3073352be43dce96ce1ea62"
SRC_URI[mpeg2dec.sha256sum] = "06cdb31242b8649bdd46bc07b9276de0ccd5f4e1c137d3cb79e0866c1ed04264"

SRC_URI[mpeg4enc.md5sum] = "5ad19ce6ce52fc0aae8de870aab845cf"
SRC_URI[mpeg4enc.sha256sum] = "2f5d8cfb6b19488f36b30c4bec5bf32b31935b97b3f024453203caee32e6c914"

SRC_URI[mpeg4dec.md5sum] = "4a27cda2d5a859e6322680a4855b6b88"
SRC_URI[mpeg4dec.sha256sum] = "ca35db6841586fc2c22dd9c07a7f5b8557f480fa907e8a3471b660d4ada76e40"

SRC_URI[aachedec.md5sum] = "649f2e79b4950719295cfecbff2ea82b"
SRC_URI[aachedec.sha256sum] = "34d19e40d624ccdc1b371f9a5d6594b4793bdf3b7223ac65912d15d75320e020"

SRC_URI[g711.md5sum] = "fd8e9f939cc505dc5761705ed17a726c"
SRC_URI[g711.sha256sum] = "c87021e8df2a3f494f47e5bdce8a5fad04d667aa1b792fd9b3ecff634867b48d"

TI_BIN_UNPK_CMDS = "Y:workdir"

S = "${CODEC_SUITE_NAME}"

DEPENDS = "ti-cgt6x ti-xdctools ti-dspbios ti-codec-engine ti-linuxutils ti-c6accel"

#generic codec
DSPSUFFIX_omapl138 = "x64P"

python do_unpack () {
    bb.build.exec_func('base_do_unpack', d)

    bb.data.setVar("BINFILE", "dm6446_h264enc_02_02_00_02_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm6446_h264enc_02_02_00_02_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm6446_h264dec_2_00_002_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm6446_h264dec_2_00_002_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "c64xplus_jpegenc_02_00_01_00_production.bin", d)
    bb.data.setVar("TARFILE", "c64xplus_jpegenc_02_00_01_00_production/c64xplus_jpegenc_02_00_01_00_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "c64xplus_jpegdec_02_00_01_01_production.bin", d)
    bb.data.setVar("TARFILE", "c64xplus_jpegdec_02_00_01_01_production/c64xplus_jpegdec_02_00_01_01_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "c64xplus_mpeg2dec_02_00_02_00_production.bin", d)
    bb.data.setVar("TARFILE", "c64xplus_mpeg2dec_02_00_02_00_production/c64xplus_mpeg2dec_02_00_02_00_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "c64xplus_mpeg4enc_02_02_04_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/c64xplus_mpeg4enc_02_02_04_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "c64xplus_mpeg4dec_02_01_00_00_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/c64xplus_mpeg4dec_02_01_00_00_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "c64xplus_aachedec_01_30_03_00_production.bin", d)
    bb.data.setVar("TARFILE", "c64xplus_aachedec_01_30_03_00_production/dm6446_aachedec_01_30_03_00_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "c64xplus_g711_1_12_00_000_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm6446_g711enc_1_12_00_000_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "c64xplus_g711_1_12_00_000_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm6446_g711dec_1_12_00_000_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

}

addtask prepsources after do_unpack before do_patch

do_prepsources () {

    mkdir -p ${CODEC_SUITE_NAME}/packages/ti/sdo/server/cs
    cp ${WORKDIR}/git/omap-l138/cs1omapl138/rel-files/*  ${CODEC_SUITE_NAME}/  
    cp ${WORKDIR}/git/omap-l138/cs1omapl138/source/*  ${CODEC_SUITE_NAME}/packages/ti/sdo/server/cs
    cp -a "${WORKDIR}/git/omap-l138/cs1omapl138/docs"  ${CODEC_SUITE_NAME}/packages/ti/sdo/server/cs 

    mkdir -p ${CODEC_SUITE_NAME}/packages/ti/sdo/codecs
    cp -a "${WORKDIR}/dm6446_h264enc_02_02_00_02_production/packages/ti/sdo/codecs/h264enc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm6446_h264dec_2_00_002_production/packages/ti/sdo/codecs/h264dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/c64xplus_jpegenc_02_00_01_00_production/packages/ti/sdo/codecs/jpegenc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/c64xplus_jpegdec_02_00_01_01_production/packages/ti/sdo/codecs/jpegdec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/c64xplus_mpeg2dec_02_00_02_00_production/packages/ti/sdo/codecs/mpeg2dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/c64xplus_mpeg4enc_02_02_04_production/packages/ti/sdo/codecs/mpeg4enc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/c64xplus_mpeg4dec_02_01_00_00_production/packages/ti/sdo/codecs/mpeg4dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    chmod -R +w "${WORKDIR}/dm6446_aachedec_01_30_03_00_production/packages/ti/sdo/codecs/aachedec/docs"
    cp -a "${WORKDIR}/dm6446_aachedec_01_30_03_00_production/packages/ti/sdo/codecs/aachedec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm6446_g711enc_1_12_00_000_production/packages/ti/sdo/codecs/g711enc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm6446_g711dec_1_12_00_000_production/packages/ti/sdo/codecs/g711dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
}

do_compile() {

    cd "${S}"

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
             C6ACCEL_INSTALL_DIR=${C6ACCEL_INSTALL_DIR} \
             clean

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
             C6ACCEL_INSTALL_DIR=${C6ACCEL_INSTALL_DIR} \
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
    cp -pPrf ${CODEC_SUITE_NAME}/* ${D}${CODEC_INSTALL_DIR_RECIPE}
}


PACKAGES += "ti-codecs-omapl138-server"
FILES_ti-codecs-omapl138-server = "${installdir}/ti-codecs-server/*"

