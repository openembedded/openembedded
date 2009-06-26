require ti-dspbios.inc
inherit sdk

SRC_URI	= "http://install.source.dir.com/bios_setuplinux_5_33_02.bin"
BINFILE="bios_setuplinux_5_33_02.bin"

S = "${WORKDIR}/bios_5_33_02"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "533"
PR = "r13"

do_install() {
    install -d ${D}/${prefix}/dvsdk/bios_5_33_02
    cp -pPrf ${S}/* ${D}/${prefix}/dvsdk/bios_5_33_02

    # Creates rules.make file
	  mkdir -p ${STAGING_DIR_HOST}/ti-sdk-rules
	  echo "# Where DSP/BIOS is installed." > ${STAGING_DIR_HOST}/ti-sdk-rules/bios.Rules.make
    echo "BIOS_INSTALL_DIR=${prefix}/dvsdk/bios_5_33_02" >> ${STAGING_DIR_HOST}/ti-sdk-rules/bios.Rules.make
}

FILES_${PN} ="${prefix}/dvsdk/bios_5_33_02/*"
INSANE_SKIP_${PN} = True
INHIBIT_PACKAGE_STRIP = "1"

