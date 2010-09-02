DESCRIPTION = "TI Codecs for DM365"
SECTION = "multimedia"
LICENSE = "TI"
PR="r2"

require ti-paths.inc
require ti-staging.inc

PV="4_00_00_00"

CODEC_SUITE_NAME="${WORKDIR}/${PN}_${PV}"

require ti-eula-unpack.inc

SRC_URI="http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_h264dec_01_10_00_05_production.bin;name=h264dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_h264enc_01_10_00_08_production.bin;name=h264enc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_mpeg4dec_hdvicp_02_00_00_05_production.bin;name=mpeg4dec_hdvicp \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_mpeg4enc_hdvicp_02_00_00_05_production.bin;name=mpeg4enc_hdvicp \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_mpeg2dec_01_00_00_04_production.bin;name=mpeg2dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_mpeg2enc_01_00_00_04_production.bin;name=mpeg2enc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_vc1dec_01_00_00_04_production.bin;name=vc1dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_mpeg4dec_01_10_00_01_production.bin;name=mpeg4dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_mpeg4enc_01_10_00_00_production.bin;name=mpeg4enc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_jpegdec_01_00_00_06_production.bin;name=jpegdec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_jpegenc_01_00_00_07_production.bin;name=jpegenc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_aaclcdec_6_1_00_production.bin;name=aaclcdec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_aaclcenc_3_5_00_production.bin;name=aaclcenc \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_g711dec_2_0_00_production.bin;name=g711dec \
    http://software-dl.ti.com/dsps/dsps_public_sw/codecs/DM365//DM365_latest/dm365_g711enc_2_0_00_production.bin;name=g711enc \
"

SRC_URI[h264dec.md5sum] = "b1f3f073bd1b9db57c8d3d824b60511a"
SRC_URI[h264dec.sha256sum] = "da4f2e77229589094c145a4a57ad04a9e9404798e44c9a0a661eac4594bbd5c3"

SRC_URI[h264enc.md5sum] = "f48be5e052707e0099afd9ad91aa201a"
SRC_URI[h264enc.sha256sum] = "4326ea03ba25d7eba6466a7dac32fb6930a19f973a6903cf5ae5a11e7930d9f4"

SRC_URI[mpeg4dec_hdvicp.md5sum] = "a9ebad2a72969c6e202ca2e2b5c1abe8"
SRC_URI[mpeg4dec_hdvicp.sha256sum] = "a3e2b07182116a4d99ba10b7f1eb2c89fb80f54b43203e2404eae197b05f613d"

SRC_URI[mpeg4enc_hdvicp.md5sum] = "855c295225d4aae27892b933d337ca03"
SRC_URI[mpeg4enc_hdvicp.sha256sum] = "70222da40e24c01121d7364b132281eb3bac92272f42378f7d36e3695a87c66b"

SRC_URI[mpeg2dec.md5sum] = "f090637bcc5b6ae921232c5d3fe6ab4f"
SRC_URI[mpeg2dec.sha256sum] = "611c8e8ac0046c3a06ee61c794d8ab8583a5c590e782224f7a67dadfad7139e0"

SRC_URI[mpeg2enc.md5sum] = "9ae1be9814849087c4893589447a3936"
SRC_URI[mpeg2enc.sha256sum] = "f92b5ae3c17d7b0a4bb997d56db549ab792d566e2b9d58f8cf33f2ae46f05430"

SRC_URI[vc1dec.md5sum] = "85dae02dbcd6b4f06ca97b6c02bff214"
SRC_URI[vc1dec.sha256sum] = "bc38a11dfdb1916e6ec62735673b2a5ca70bfc73e4f0c745b0d555eedca1ac11"

SRC_URI[mpeg4dec.md5sum] = "e96eea9805116282b85286dc84da08e3"
SRC_URI[mpeg4dec.sha256sum] = "da0dc7f54c20d209fecc71657f0fef7c7b85ec2554b61de69164930849b47e7e"

SRC_URI[mpeg4enc.md5sum] = "3fa04bc985fe3bc26a8b320fbbd6484f"
SRC_URI[mpeg4enc.sha256sum] = "c978849b29c4357cb5bf5f5d8bbec0878d8f7e12da305a831ca8661cc2ab8be3"

SRC_URI[jpegdec.md5sum] = "81f49947ba7c46ccd3ce68accac5dfdc"
SRC_URI[jpegdec.sha256sum] = "7e6f185b0a5794f6e92cbd79db1e7a1ca17b52ad987633eb7678c2dc4ba20f3f"

SRC_URI[jpegenc.md5sum] = "4fe49335e46aae1a29a54ab71a9f354f"
SRC_URI[jpegenc.sha256sum] = "079aa90851754c66e61da0ebc852d1a0d49593631e4cc06651195a9a213d9927"

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

    bb.data.setVar("BINFILE", "dm365_h264enc_01_10_00_08_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm365_h264enc_01_10_00_08_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_h264dec_01_10_00_05_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm365_h264dec_01_10_00_05_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_mpeg4dec_hdvicp_02_00_00_05_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm365_mpeg4dec_hdvicp_02_00_00_05_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_mpeg4enc_hdvicp_02_00_00_05_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm365_mpeg4enc_hdvicp_02_00_00_05_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_mpeg2dec_01_00_00_04_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm365_mpeg2dec_01_00_00_04_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_mpeg2enc_01_00_00_04_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm365_mpeg2enc_01_00_00_04_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_mpeg4dec_01_10_00_01_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm365_mpeg4dec_01_10_00_01_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_mpeg4enc_01_10_00_00_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm365_mpeg4enc_01_10_00_00_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_jpegdec_01_00_00_06_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm365_jpegdec_01_00_00_06_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_jpegenc_01_00_00_07_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm365_jpegenc_01_00_00_07_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_aaclcdec_6_1_00_production.bin", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_aaclcenc_3_5_00_production.bin", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_g711dec_2_0_00_production.bin", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_g711enc_2_0_00_production.bin", d)
    bb.build.exec_func('ti_bin_do_unpack', d)

    bb.data.setVar("BINFILE", "dm365_vc1dec_01_00_00_04_production.bin", d)
    bb.data.setVar("TARFILE", "h264enc_dm6467_1_20_00_08/dm365_vc1dec_01_00_00_04_production.tar", d)
    bb.build.exec_func('ti_bin_do_unpack', d)
}

addtask prepsources after do_unpack before do_patch

do_prepsources() {

    mkdir -p ${CODEC_SUITE_NAME}/packages/ti/sdo/codecs
    mkdir -p ${CODEC_SUITE_NAME}/packages/ittiam/codecs
    cp -a "${WORKDIR}/dm365_h264dec_01_10_00_05_production/packages/ti/sdo/codecs/h264dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_h264enc_01_10_00_08_production/packages/ti/sdo/codecs/h264enc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_mpeg4dec_hdvicp_02_00_00_05_production/packages/ti/sdo/codecs/mpeg4dec_hdvicp" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_mpeg4enc_hdvicp_02_00_00_05_production/packages/ti/sdo/codecs/mpeg4enc_hdvicp" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_mpeg2dec_01_00_00_04_production/packages/ti/sdo/codecs/mpeg2dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_mpeg2enc_01_00_00_04_production/packages/ti/sdo/codecs/mpeg2enc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_vc1dec_01_00_00_04_production/packages/ti/sdo/codecs/vc1dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_mpeg4dec_01_10_00_01_production/packages/ti/sdo/codecs/mpeg4dec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_mpeg4enc_01_10_00_00_production/packages/ti/sdo/codecs/mpeg4enc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_jpegdec_01_00_00_06_production/packages/ti/sdo/codecs/jpegdec" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
    cp -a "${WORKDIR}/dm365_jpegenc_01_00_00_07_production/packages/ti/sdo/codecs/jpegenc" "${CODEC_SUITE_NAME}/packages/ti/sdo/codecs"
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

