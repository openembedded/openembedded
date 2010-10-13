DESCRIPTION = "TI Codecs and Server Combo for OMAP3530"
SECTION = "multimedia"
LICENSE = "TI"

require ti-paths.inc
require ti-staging.inc

PR="${MACHINE_KERNEL_PR}"
PR_append = "a"

PV="4_00_00_00"

CODEC_SUITE_NAME="${WORKDIR}/${PN}_${PV}"

SRCREV = "8393c892b09e0ac42b19ff1531e232478c3b1a6c"

require ti-eula-unpack.inc

SRC_URI="http://software-dl.ti.com/dsps/dsps_public_sw/codecs/OMAP35xx//OMAP35xx_latest/omap3530_h264enc_2_01_013_production.bin;name=h264enc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/OMAP35xx//OMAP35xx_latest/omap3530_h264dec_2_01_007_production.bin;name=h264dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/OMAP35xx//OMAP35xx_latest/omap3530_jpegenc_02_01_01_00_production.bin;name=jpegenc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Video//C64XPlus_Video_latest/c64xplus_jpegdec_02_00_01_01_production.bin;name=jpegdec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Video//C64XPlus_Video_latest/c64xplus_mpeg2dec_02_00_02_00_production.bin;name=mpeg2dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/OMAP35xx//OMAP35xx_latest/omap3530_mpeg4enc_02_04_00_00_production.bin;name=mpeg4enc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Video//C64XPlus_Video_latest/c64xplus_mpeg4dec_02_01_00_00_production.bin;name=mpeg4dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Audio//C64XPlus_Audio_latest/c64xplus_aachedec_01_30_03_00_production.bin;name=aachedec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/C64XPlus_Speech//C64XPlus_Speech_latest/c64xplus_g711_1_12_00_000_production.bin;name=g711 \
    http://software-dl.ti.com/dsps/dsps_public_sw/sdo_tii/OMAP35xx_DM37xx_C64xPLUS_Algorithms/01_00_00_07//exports/c64xplus_deinterlacer_01_00_00_07_production.bin;name=i2p \
    git://arago-project.org/git/projects/codec-servers.git;protocol=git \

"

SRC_URI[h264enc.md5sum] = "4a7a4698b1db360fe103aae76127a4ec"
SRC_URI[h264enc.sha256sum] = "8fd970d83004bb099f51420b0eecd660b4ba9dccc87b2759d0b5a0be46f8f1a0"

SRC_URI[h264dec.md5sum] = "81980df2d9dbedc5b64789c4e5575819"
SRC_URI[h264dec.sha256sum] = "19d65e71ba0342670cb217e0fa6617263ff68a513e8444a8dfd5f34bd641b24f"

SRC_URI[jpegenc.md5sum] = "c2e8ad88e90c04d2de7b199517019ac8"
SRC_URI[jpegenc.sha256sum] = "6525e067cb5dd00cfc0b38045c44dcbed05866f8ad20188ceac630812502d473"

SRC_URI[jpegdec.md5sum] = "cf2886c3406ab41409a586e5d550918d"
SRC_URI[jpegdec.sha256sum] = "6b0c9f1b8f023070c6a59af690f015f84f2c7f3143235f788ddd1a4a7b229089"

SRC_URI[mpeg2dec.md5sum] = "da3d0561f3073352be43dce96ce1ea62"
SRC_URI[mpeg2dec.sha256sum] = "06cdb31242b8649bdd46bc07b9276de0ccd5f4e1c137d3cb79e0866c1ed04264"

SRC_URI[mpeg4enc.md5sum] = "07c36e5d03368e1326df75a1f0c4934d"
SRC_URI[mpeg4enc.sha256sum] = "a9566c8978f7230936053de9b1f3bfe8820ae555262ceba87243abdf60e5193f"

SRC_URI[mpeg4dec.md5sum] = "4a27cda2d5a859e6322680a4855b6b88"
SRC_URI[mpeg4dec.sha256sum] = "ca35db6841586fc2c22dd9c07a7f5b8557f480fa907e8a3471b660d4ada76e40"

SRC_URI[aachedec.md5sum] = "649f2e79b4950719295cfecbff2ea82b"
SRC_URI[aachedec.sha256sum] = "34d19e40d624ccdc1b371f9a5d6594b4793bdf3b7223ac65912d15d75320e020"

SRC_URI[g711.md5sum] = "fd8e9f939cc505dc5761705ed17a726c"
SRC_URI[g711.sha256sum] = "c87021e8df2a3f494f47e5bdce8a5fad04d667aa1b792fd9b3ecff634867b48d"

SRC_URI[i2p.md5sum] = "f67c04eec9ee49c7a686eecf5d54be33"
SRC_URI[i2p.sha256sum] = "3fbf8801f3ce2aabb6d31eb18e1e24e41ca861696b3140536f1d66adc76f0323"


TI_BIN_UNPK_CMDS = "Y:workdir"

S = "${CODEC_SUITE_NAME}"

DEPENDS = "ti-cgt6x ti-xdctools ti-dspbios ti-codec-engine ti-linuxutils ti-c6accel"

#generic codec
DSPSUFFIX_omap3530 = "x64P"

python do_unpack () {
    bb.build.exec_func('base_do_unpack', d)

    bb.data.setVar("BINFILE", "omap3530_h264enc_2_01_013_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/omap3530_h264enc_2_01_013_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "omap3530_h264dec_2_01_007_production.bin", d)
    bb.data.setVar("TARFILE", "omap3530_h264dec_2_01_007_production/omap3530_h264dec_2_01_007_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "omap3530_jpegenc_02_01_01_00_production.bin", d)
    bb.data.setVar("TARFILE", "omap3530_jpegenc_02_01_01_00_production/omap3530_jpegenc_02_01_01_00_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "c64xplus_jpegdec_02_00_01_01_production.bin", d)
    bb.data.setVar("TARFILE", "c64xplus_jpegdec_02_00_01_01_production/c64xplus_jpegdec_02_00_01_01_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "c64xplus_mpeg2dec_02_00_02_00_production.bin", d)
    bb.data.setVar("TARFILE", "c64xplus_mpeg2dec_02_00_02_00_production/c64xplus_mpeg2dec_02_00_02_00_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "omap3530_mpeg4enc_02_04_00_00_production.bin", d)
    bb.data.setVar("TARFILE", "omap3530_mpeg4enc_02_04_00_00_production/omap3530_mpeg4enc_02_04_00_00_production.tar", d)
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

    bb.data.setVar("BINFILE", "c64xplus_deinterlacer_01_00_00_07_production.bin", d)
    bb.data.setVar("TARFILE", "c64xplus_deinterlacer_01_00_00_07/c64xplus_deinterlacer_01_00_00_07_production.tar", d)
    bb.data.setVar("TI_BIN_UNPK_CMDS", "y: :q: ", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

}

addtask prepsources after do_unpack before do_patch

do_prepsources () {

    mkdir -p ${CODEC_SUITE_NAME}/packages/ti/sdo/server/cs
    cp ${WORKDIR}/git/omap3530/cs1omap3530/rel-files/*  ${CODEC_SUITE_NAME}/  
    cp ${WORKDIR}/git/omap3530/cs1omap3530/source/*  ${CODEC_SUITE_NAME}/packages/ti/sdo/server/cs
    cp -a "${WORKDIR}/git/omap3530/cs1omap3530/docs"  ${CODEC_SUITE_NAME}/packages/ti/sdo/server/cs 

    mkdir -p ${CODEC_SUITE_NAME}/packages/ti/sdo/codecs
    cp -a "${WORKDIR}/omap3530_h264enc_2_01_013_production/packages/ti/sdo/codecs/h264enc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/omap3530_h264dec_2_01_007_production/packages/ti/sdo/codecs/h264dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/omap3530_jpegenc_02_01_01_00_production/packages/ti/sdo/codecs/jpegenc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/c64xplus_jpegdec_02_00_01_01_production/packages/ti/sdo/codecs/jpegdec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/c64xplus_mpeg2dec_02_00_02_00_production/packages/ti/sdo/codecs/mpeg2dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/omap3530_mpeg4enc_02_04_00_00_production/packages/ti/sdo/codecs/mpeg4enc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/c64xplus_mpeg4dec_02_01_00_00_production/packages/ti/sdo/codecs/mpeg4dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    chmod -R +w "${WORKDIR}/dm6446_aachedec_01_30_03_00_production/packages/ti/sdo/codecs/aachedec/docs"
    cp -a "${WORKDIR}/dm6446_aachedec_01_30_03_00_production/packages/ti/sdo/codecs/aachedec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm6446_g711enc_1_12_00_000_production/packages/ti/sdo/codecs/g711enc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm6446_g711dec_1_12_00_000_production/packages/ti/sdo/codecs/g711dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/c64xplus_deinterlacer_01_00_00_07_production/packages/ti/sdo/codecs/deinterlacer" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    chmod 755 -R ${CODEC_SUITE_NAME}
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


PACKAGES += "ti-codecs-omap3530-server"
FILES_ti-codecs-omap3530-server = "${installdir}/ti-codecs-server/*"


