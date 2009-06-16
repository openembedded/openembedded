require ti-cgt6x.inc
inherit sdk

SRC_URI	= "http://install.source.dir.com/TI-C6x-CGT-v6.0.16-eval.tar.gz"

S = "${WORKDIR}/cg6x_6_0_16"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "6016"
PR = "r12"

do_install() {
	install -d ${D}/${prefix}/dvsdk/cg6x_6_0_16
    cp -pPrf ${S}/* ${D}/${prefix}/dvsdk/cg6x_6_0_16
	
	# Creates rules.make file
	mkdir -p ${STAGING_DIR_HOST}/ti-sdk-rules
	echo "# Where the TI C6x codegen tool is installed." >  ${STAGING_DIR_HOST}/ti-sdk-rules/cgt6x.Rules.make
	echo "CODEGEN_INSTALL_DIR=${prefix}/dvsdk/cg6x_6_0_16" >> ${STAGING_DIR_HOST}/ti-sdk-rules/cgt6x.Rules.make
  echo "" >> 	${STAGING_DIR_HOST}/ti-sdk-rules/cgt6x.Rules.make
}

INHIBIT_PACKAGE_STRIP = "1"
FILES_${PN} = "${prefix}/dvsdk/cg6x_6_0_16"
INSANE_SKIP_${PN} = True

