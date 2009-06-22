inherit sdk
require ti-xdctools.inc

SRC_URI	= "http://install.source.dir.com/xdctools_setuplinux_3_10_03.bin"
BINFILE="xdctools_setuplinux_3_10_03.bin"

S = "${WORKDIR}/xdctools_3_10_03"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "310"
PR = "r16"

do_install() {
    install -d ${D}/${prefix}/dvsdk/xdctools_3_10_03
    cp -pPrf ${S}/* ${D}/${prefix}/dvsdk/xdctools_3_10_03

    # Creates rules.make file
	  mkdir -p ${STAGING_DIR_HOST}/ti-sdk-rules
	  echo "# Where the RTSC tools package is installed." > ${STAGING_DIR_HOST}/ti-sdk-rules/xdc.Rules.make
    echo "XDC_INSTALL_DIR=${prefix}/dvsdk/xdctools_3_10_03" >> ${STAGING_DIR_HOST}/ti-sdk-rules/xdc.Rules.make
}

FILES_${PN} = "${prefix}/dvsdk/xdctools_3_10_03"
INSANE_SKIP_${PN} = True
INHIBIT_PACKAGE_STRIP = "1"
