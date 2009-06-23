DESCRIPTION = "DM355 Codec Combo 1.13"

inherit sdk
require ti-codec-combo-dm355.inc

SRC_URI	= "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/dvsdk/codecs/dm355_codecs_setuplinux_1_13_000.bin\
		   file://dm355mm_1_30.patch;patch=1 \
		 "

S = "${WORKDIR}/dm355_codecs_1_13_000"
BINFILE="dm355_codecs_setuplinux_1_13_000.bin"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "113"
PR = "r16"

do_compile() {
	echo "Do nothing"
}

do_install() {
    install -d ${D}/${prefix}/dvsdk/dm355_codecs_1_13_000
    cp -pPrf ${S}/* ${D}/${prefix}/dvsdk/dm355_codecs_1_13_000

    # Creates rules.make file
	  mkdir -p ${STAGING_DIR_HOST}/ti-sdk-rules
		echo "# Where the codec servers are installed." > ${STAGING_DIR_HOST}/ti-sdk-rules/codec.Rules.make
    echo "CODEC_INSTALL_DIR=${prefix}/dvsdk/dm355_codecs_1_13_000" >> ${STAGING_DIR_HOST}/ti-sdk-rules/codec.Rules.make
}

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} = True
FILES_${PN} = "${prefix}/dvsdk/dm355_codecs_1_13_000/*"

