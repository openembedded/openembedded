DESCRIPTION = "Codec Engine 2.23.01 for TI ARM/DSP processors"

# compile time dependencies
DEPENDS_dm6446-evm 	+= "ti-xdctools-native ti-cgt6x-native ti-dspbios-native"
DEPENDS_omap3evm   	+= "ti-cgt6x-native ti-dspbios-native ti-xdctools-native"
DEPENDS_beagleboard	+= "ti-cgt6x-native ti-dspbios-native ti-xdctools-native"
DEPENDS_dm355-evm 	+= "ti-xdctools-native"

# tconf from xdctools dislikes '.' in pwd :/
PR = "r16"
PV = "2231"

# Download codec_engine_2_23_01.tar.gz from https://www-a.ti.com/downloads/sds_support/targetcontent/CE/ce_2_23/index.html and copy in Arago (or OE) download directory.

SRC_URI = "http://install.source.dir.local/codec_engine_2_23_01.tar.gz "

# Set the source directory
S = "${WORKDIR}/codec_engine_2_23_01"

do_compile () {
    echo "! Do not rebuild for now !"
}

# stage tree - other packages may need this
do_stage() {
    install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}
    cp -pPrf ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}/ 
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_PACKAGE_STRIP = "1"

