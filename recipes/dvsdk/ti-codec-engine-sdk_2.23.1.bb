DESCRIPTION = "Codec Engine 2.23.01 for TI ARM/DSP processors"
inherit sdk

# tconf from xdctools dislikes '.' in pwd :/
PR = "r17"
PV = "2231"

SRC_URI = "http://install.source.dir.com/codec_engine_2_23_01.tar.gz "

# Set the source directory
S = "${WORKDIR}/codec_engine_2_23_01"

do_compile () {
    echo "nothing to build"
}

do_install() {
    # Update cmem and sdma Rules.make to point correct location of main 
    # Rules.make.
    sed -i -e s:Rules.make:../Rules.make:g \
	${S}/cetools/packages/ti/sdo/linuxutils/cmem/Rules.make
    sed -i -e s:Rules.make:../Rules.make:g \
	${S}/cetools/packages/ti/sdo/linuxutils/sdma/Rules.make

    install -d ${D}/${prefix}/dvsdk/codec_engine_2_23_01
    cp -pPrf ${S}/* ${D}/${prefix}/dvsdk/codec_engine_2_23_01

    # Creates rules.make file
    
	  mkdir -p ${STAGING_DIR_HOST}/ti-sdk-rules
	  echo "# Where the Codec Engine package is installed." > ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make
    echo "CE_INSTALL_DIR=${prefix}/dvsdk/codec_engine_2_23_01" >> ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make
    echo "" >> ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make
    echo "# Where the XDAIS package is installed." >> ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make
    echo "XDAIS_INSTALL_DIR=\$(CE_INSTALL_DIR)/cetools" >> ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make
    echo "" >> ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make
    echo "# Where the DSP Link package is installed." >> ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make    
    echo "LINK_INSTALL_DIR=\$(CE_INSTALL_DIR)/cetools" >> ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make
    echo "" >> ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make
    echo "# Where the CMEM (contiguous memory allocator) package is installed." >> ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make
    echo "CMEM_INSTALL_DIR=\$(CE_INSTALL_DIR)/cetools" >> ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make
    echo "" >> ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make
    echo "# Where Framework Components product is installed."  >> ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make
    echo "FC_INSTALL_DIR=\$(CE_INSTALL_DIR)/cetools"  >> ${STAGING_DIR_HOST}/ti-sdk-rules/ce.Rules.make
}

FILES_${PN} = "${prefix}/dvsdk/codec_engine_2_23_01"
INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} = True

