inherit sdk
require ti-dmai.inc

do_compile () {
	echo "do nothing"
}

do_install() {
    install -d ${D}/${prefix}/dvsdk/dmai_${PV}
    cp -pPrf ${S}/dmai/* ${D}/${prefix}/dvsdk/dmai_${PV}

    # Creates rules.make file
	  mkdir -p ${STAGING_DIR_HOST}/ti-sdk-rules
	  echo "# Where DMAI package is installed." > ${STAGING_DIR_HOST}/ti-sdk-rules/dmai.Rules.make
    echo "DMAI_INSTALL_DIR=${prefix}/dvsdk/dmai_${PV}" >> ${STAGING_DIR_HOST}/ti-sdk-rules/dmai.Rules.make
}

INHIBIT_PACKAGE_STRIP = "1"
FILES_${PN} = "${prefix}/dvsdk/dmai_${PV}/*"
INSANE_SKIP_${PN} = True

