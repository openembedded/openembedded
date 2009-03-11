DESCRIPTION = "Codec combos for omap3530"
DEPENDS = "ti-codec-engine"
LICENCE = "unknown"

require ti-paths.inc

SRC_URI = "http://software-dl.ti.com/sdo/sdo_apps_public_sw/omap3530_dvsdk_combos_tspa/omap3530_dvsdk_combos_tspa-3_16-Linux-x86.bin \
    "

S = "${WORKDIR}/omap3530_dvsdk_combos_3_16"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "316"
PR = "r12"

TARGET = "all"

export CE_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/packages;${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"

# Needed for now since makefile in latest package assumes this is set
export CODEC_INSTALL_DIR="${S}"

# Helper function to run the binary installer and unpack the tar.gz in the same place as it was before - this could be optimised later
do_accept_license() {
        export HOME="${WORKDIR}"
	chmod +x ${WORKDIR}/omap3530_dvsdk_combos_tspa-3_16-Linux-x86.bin
        ${WORKDIR}/omap3530_dvsdk_combos_tspa-3_16-Linux-x86.bin --mode silent --prefix ${S}_install
        cd "${S}_install"
	tar -xzvf omap3530_dvsdk_combos_tspa_3_16.tar.gz
	if [ -d ${S} ] ; then 
            rm -rf ${S}
        fi
        mv omap3530_dvsdk_combos_tspa_3_16 ${S}
}

addtask accept_license after do_unpack before do_configure

do_compile() {

        # For now, remove the reference to Rules.make and swap prod for eval, since this only has eval libs included
        sed -i \
        -e '/Rules.make/d' \
        -e s:prod:eval:g \
        ${S}/Makefile

        # Fix-up config.bld to swap out hardcoded references to tools paths
	sed -i -e s:/opt/dmsw/cg6x_6_0_16:${TITOOLSDIR}/${TICGTOOLSDIR}:g \
	${S}/config.bld

	oe_runmake clean
	oe_runmake
}

do_install () {
	echo oe_runmake install

	install -d ${D}/${datadir}/ti-codec-combos

	cd ${S}

	# grab the server executables
	for i in $(find . -name "*.x64P") ; do
		install ${i} ${D}/${datadir}/ti-codec-combos
	done
	
	# copy the generated data sheets as well for reference
        for i in $(find . -name "*.DataSheet.*") ; do
                install ${i} ${D}/${datadir}/ti-codec-combos
        done
}

do_stage () {
	install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combos
	cp -pPrf ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combos
}

FILES_ti-codec-combos = "${datadir}/ti-codec-combos/*"

INHIBIT_PACKAGE_STRIP = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

