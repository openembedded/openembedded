DESCRIPTION = "OMAP3530 Codec Combo 3.16.01"
require ti-codec-combo-omap3530.inc

inherit sdk

SRC_URI	= "http://software-dl.ti.com/sdo/sdo_apps_public_sw/omap3530_dvsdk_combos_tspa/omap3530_dvsdk_combos_tspa-3_16_01-Linux-x86.bin"

# Specify names of the InstallJammer binary file and the tarball it extracts
BINFILE = "omap3530_dvsdk_combos_tspa-3_16_01-Linux-x86.bin"
TARFILE = "omap3530_dvsdk_combos_tspa/omap3530_dvsdk_combos_tspa_3_16_01.tar.gz"

S = "${WORKDIR}/omap3530_dvsdk_combos_tspa_3_16_01"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "316"
PR = "r10"

do_compile () {
	echo "No nothing"
}

do_install() {
    install -d ${D}/${prefix}/dvsdk/omap3530_dvsdk_combos_3_16_01
    cp -pPrf ${S}/* ${D}/${prefix}/dvsdk/omap3530_dvsdk_combos_3_16_01

    # Creates rules.make file
	  mkdir -p ${STAGING_DIR_HOST}/ti-sdk-rules
	  echo "# Where the codec servers are installed." > ${STAGING_DIR_HOST}/ti-sdk-rules/codec.Rules.make
    echo "CODEC_INSTALL_DIR=${prefix}/dvsdk/omap3530_dvsdk_combos_3_16_01" >> ${STAGING_DIR_HOST}/ti-sdk-rules/codec.Rules.make
}

INHIBIT_PACKAGE_STRIP = "1"
FILES_${PN} = "${prefix}/dvsdk/omap3530_dvsdk_combos_3_16_01/*"
INSANE_SKIP_${PN} = True

