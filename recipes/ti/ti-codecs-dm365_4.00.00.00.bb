DESCRIPTION = "TI Codecs for DM365"
SECTION = "multimedia"
LICENSE = "TI"
PR="r3"

require ti-paths.inc
require ti-staging.inc

PV="4_00_00_00"

CODEC_SUITE_NAME="${WORKDIR}/${PN}_${PV}"

require ti-eula-unpack.inc

SRC_URI="http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_mpeg4dec_hdvicp_02_00_00_05_production.bin;name=mpeg4dec_hdvicp \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_mpeg4enc_hdvicp_02_00_00_08_production.bin;name=mpeg4enc_hdvicp \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_h264dec_02_00_00_10_production.bin;name=h264dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_h264enc_02_00_00_10_production.bin;name=h264enc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_mpeg2dec_01_00_00_06_production.bin;name=mpeg2dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_mpeg2enc_01_00_00_07_production.bin;name=mpeg2enc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_vc1dec_01_00_00_06_production.bin;name=vc1dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_mpeg4dec_01_10_00_01_production.bin;name=mpeg4dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_mpeg4enc_01_10_00_03_production.bin;name=mpeg4enc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_jpegdec_01_00_00_10_production.bin;name=jpegdec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_jpegenc_01_00_00_09_production.bin;name=jpegenc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_aaclcdec_6_1_00_production.bin;name=aaclcdec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_aaclcenc_3_5_00_production.bin;name=aaclcenc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_g711dec_2_0_00_production.bin;name=g711dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_g711enc_2_0_00_production.bin;name=g711enc \
"


SRC_URI[mpeg4dec_hdvicp.md5sum] = "a9ebad2a72969c6e202ca2e2b5c1abe8"
SRC_URI[mpeg4dec_hdvicp.sha256sum] = "a3e2b07182116a4d99ba10b7f1eb2c89fb80f54b43203e2404eae197b05f613d"

SRC_URI[mpeg4enc_hdvicp.md5sum] = "dbe17489d957441189bfae7d6deb5a65"
SRC_URI[mpeg4enc_hdvicp.sha256sum] = "f58c7095b5249d5f8faa75ffd0d13f0b275f4f6bd4744b1ec53addf521eaf54f"

SRC_URI[h264dec.md5sum] = "0169478c5113e03b2f7f32c73921ef3c"
SRC_URI[h264dec.sha256sum] = "afe63f190123eddf6e0f4d6eab837137242af1a4ae3101f453c251cea0d731b3"

SRC_URI[h264enc.md5sum] = "e3f3b7a2c26a5a8cfbe3c84f991db9de"
SRC_URI[h264enc.sha256sum] = "5b5ed8b064e873506a54cfac8b02a682437890b300cb3a15f43bf5a84071fc27"

SRC_URI[mpeg2dec.md5sum] = "5a8c680e7da234b770b0ce7d3b5089f6"
SRC_URI[mpeg2dec.sha256sum] = "1db4202f8183803c5734f1848e478f8b301ca0f8b5c3d3d25cfb00f40a67a4fe"

SRC_URI[mpeg2enc.md5sum] = "831253e5694b22c7954faf8bc78cf206"
SRC_URI[mpeg2enc.sha256sum] = "173f1519ba098cfa55c64ff3d990be4094f306599f1b6a43fe43a1e1c123f40a"

SRC_URI[vc1dec.md5sum] = "90b8786a10fe9169ea25bd6579f80b10"
SRC_URI[vc1dec.sha256sum] = "ac180cd48b8c84ef0c64b91e4bf65a8f6d15d207d97c0b11cc5af4b5a88f7104"

SRC_URI[mpeg4dec.md5sum] = "e96eea9805116282b85286dc84da08e3"
SRC_URI[mpeg4dec.sha256sum] = "da0dc7f54c20d209fecc71657f0fef7c7b85ec2554b61de69164930849b47e7e"

SRC_URI[mpeg4enc.md5sum] = "03a806fba77aa5036154871403d4cb32"
SRC_URI[mpeg4enc.sha256sum] = "6e2b542d419c245170eeb3beb9b67afa856818947d274d54cc2dd63f0dd7c666"

SRC_URI[jpegdec.md5sum] = "8c19a6b9fd17dacae56c972c748d0821"
SRC_URI[jpegdec.sha256sum] = "18cdfb820a1db967a3c3d532584cc275ef22f1bc71b9a932a4299502c8963973"

SRC_URI[jpegenc.md5sum] = "3d6c2d92361fd674b39f2efb4ef598c4"
SRC_URI[jpegenc.sha256sum] = "ebbc39ac0738f93211cd0ad9371316bf7e2d3f34b8b2fca6f50d7c752737ffc0"

SRC_URI[aaclcdec.md5sum] = "5759bc1c7cea6673cfab050d69729ece"
SRC_URI[aaclcdec.sha256sum] = "532bdc449760d2bc165f00c61d3912c0c8037c21adde549d4e1c0d24908bcb7a"

SRC_URI[aaclcenc.md5sum] = "ff89ace9a3a96b4073e0685657375451"
SRC_URI[aaclcenc.sha256sum] = "a368133d310f8e942ac10e000d00b13c6ad4e591b37013044d6f09ea0d473588"

SRC_URI[g711dec.md5sum] = "00b5d1e7bd059a397fd47ac2e020d56d"
SRC_URI[g711dec.sha256sum] = "ec4d4312e9f21d2b25e75f98cc013deca75e5373e955fa32a7f2a5417ef2e2c3"

SRC_URI[g711enc.md5sum] = "416030f1c56aff8e0a9c78020de6fefc"
SRC_URI[g711enc.sha256sum] = "7bcea809aff63e258dfaf7a7e72f82fd6aac1af10e42b2ade12f1d9c15e33198"


TI_BIN_UNPK_CMDS = "Y:workdir"
S = "${CODEC_SUITE_NAME}"
PROVIDES += "ti-codecs-dm365-server"

python do_unpack () {
    bb.build.exec_func('base_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_mpeg4dec_hdvicp_02_00_00_05_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm365_mpeg4dec_hdvicp_02_00_00_05_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_mpeg4enc_hdvicp_02_00_00_08_production.bin", d)
    bb.data.setVar("TARFILE", "dm365_mpeg4enc_hdvicp_02_00_00_08_production/dm365_mpeg4enc_hdvicp_02_00_00_08_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_h264enc_02_00_00_10_production.bin", d)
    bb.data.setVar("TARFILE", "dm365_h264enc_02_00_00_10_production/dm365_h264enc_02_00_00_10_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_h264dec_02_00_00_10_production.bin", d)
    bb.data.setVar("TARFILE", "dm365_h264dec_02_00_00_10_production/dm365_h264dec_02_00_00_10_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_mpeg2dec_01_00_00_06_production.bin", d)
    bb.data.setVar("TARFILE", "dm365_mpeg2dec_01_00_00_06_production/dm365_mpeg2dec_01_00_00_06_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_mpeg2enc_01_00_00_07_production.bin", d)
    bb.data.setVar("TARFILE", "dm365_mpeg2enc_01_00_00_07_production/dm365_mpeg2enc_01_00_00_07_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_mpeg4dec_01_10_00_01_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm365_mpeg4dec_01_10_00_01_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_mpeg4enc_01_10_00_03_production.bin", d)
    bb.data.setVar("TARFILE", "dm365_mpeg4enc_01_10_00_03_production/dm365_mpeg4enc_01_10_00_03_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_jpegdec_01_00_00_10_production.bin", d)
    bb.data.setVar("TARFILE", "dm365_jpegdec_01_00_00_10_production/dm365_jpegdec_01_00_00_10_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_jpegenc_01_00_00_09_production.bin", d)
    bb.data.setVar("TARFILE", "dm365_jpegenc_01_00_00_09_production/dm365_jpegenc_01_00_00_09_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_aaclcdec_6_1_00_production.bin", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_aaclcenc_3_5_00_production.bin", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_g711dec_2_0_00_production.bin", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_g711enc_2_0_00_production.bin", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_vc1dec_01_00_00_06_production.bin", d)
    bb.data.setVar("TARFILE", "dm365_vc1dec_01_00_00_06_production/dm365_vc1dec_01_00_00_06_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)
}

addtask prepsources after do_unpack before do_patch

do_prepsources() {

    mkdir -p ${CODEC_SUITE_NAME}/packages/ti/sdo/codecs
    mkdir -p ${CODEC_SUITE_NAME}/packages/ittiam/codecs
    cp -a "${WORKDIR}/dm365_h264dec_02_00_00_10_production/packages/ti/sdo/codecs/h264dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_h264enc_02_00_00_10_production/packages/ti/sdo/codecs/h264enc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_mpeg4dec_hdvicp_02_00_00_05_production/packages/ti/sdo/codecs/mpeg4dec_hdvicp" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_mpeg4enc_hdvicp_02_00_00_08_production/packages/ti/sdo/codecs/mpeg4enc_hdvicp" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_mpeg2dec_01_00_00_06_production/packages/ti/sdo/codecs/mpeg2dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_mpeg2enc_01_00_00_07_production/packages/ti/sdo/codecs/mpeg2enc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_vc1dec_01_00_00_06_production/packages/ti/sdo/codecs/vc1dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_mpeg4dec_01_10_00_01_production/packages/ti/sdo/codecs/mpeg4dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_mpeg4enc_01_10_00_03_production/packages/ti/sdo/codecs/mpeg4enc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_jpegdec_01_00_00_10_production/packages/ti/sdo/codecs/jpegdec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_jpegenc_01_00_00_09_production/packages/ti/sdo/codecs/jpegenc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_aaclcdec_6_1_00_production/aac_dec_6_1_00_production_dm365_mvl/packages-production/ittiam/codecs/aac_dec" "${CODEC_SUITE_NAME}/packages/ittiam/codecs"
    cp -a "${WORKDIR}/dm365_aaclcenc_3_5_00_production/aaclc_enc_3_5_00_production_dm365_mvl/packages-production/ittiam/codecs/aaclc_enc" "${CODEC_SUITE_NAME}/packages/ittiam/codecs"
    cp -a "${WORKDIR}/dm365_g711dec_2_0_00_production/g711_dec_2_0_00_production_dm365_mvl/packages-production/ittiam/codecs/g711_dec" "${CODEC_SUITE_NAME}/packages/ittiam/codecs"
    cp -a "${WORKDIR}/dm365_g711enc_2_0_00_production/g711_enc_2_0_00_production_dm365_mvl/packages-production/ittiam/codecs/g711_enc" "${CODEC_SUITE_NAME}/packages/ittiam/codecs"
}

do_install() {
    install -d ${D}${CODEC_INSTALL_DIR_RECIPE}
    cp -pPrf ${CODEC_SUITE_NAME}/* ${D}/${CODEC_INSTALL_DIR_RECIPE}
}

PACKAGES += "ti-codecs-dm365-server"
FILES_ti-codecs-dm365-server = "${installdir}/ti-codecs-server/*"
INSANE_SKIP_ti-codecs-dm365-server = True

