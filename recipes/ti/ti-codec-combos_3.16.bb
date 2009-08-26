DESCRIPTION = "Codec combos for omap3530"
DEPENDS = "ti-codec-engine"
LICENCE = "unknown"

require ti-paths.inc

# Tar-Up Codec Combos from the OMAP DVSDK (http://www.ti.com/dvevmupdates) and drop in files/
SRC_URI = "file://omap3530_dvsdk_combos_3_16.tar.gz \
    "

S = "${WORKDIR}/omap3530_dvsdk_combos_3_16"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "316"
PR = "r15"

TARGET = "all"

export CE_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/packages;${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"

# Needed for now since makefile in latest package assumes this is set
export CODEC_INSTALL_DIR="${S}"

do_compile() {

        # For now, remove the reference to Rules.make and swap prod for eval, since this only has eval libs included
        sed -i \
        -e '/Rules.make/d' \
        -e 's:$(FC_INSTALL_DIR)/packages;::g' \
        -e 's:$(XDAIS_INSTALL_DIR)/packages;::g' \
        -e 's:$(FC_INSTALL_DIR)/fctools/packages;::g' \
        -e 's:$(BIOSUTILS_INSTALL_DIR)/packages;::g' \
        -e 's:$(CMEM_INSTALL_DIR)/packages;::g' \
        -e 's:$(LINK_INSTALL_DIR)/packages;::g' \
        -e 's:$(LPM_INSTALL_DIR)/packages;::g' \
        -e s:prod:eval:g \
        ${S}/Makefile

        # Fix-up config.bld to swap out hardcoded references to tools paths
	sed -i -e s:/opt/dmsw/cg6x_6_0_16:${TITOOLSDIR}/${TICGTOOLSDIR}:g \
	${S}/config.bld

	# Add make target to allow package to be prepared for building (normally this package is a binary release)
        echo "makebuildable:
	\$(XDC) .make -PR .
" >> ${S}/Makefile

        oe_runmake makebuildable
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
        #for i in $(find . -name "*.DataSheet.*") ; do

        # infact, just copy all the html files (including the server datasheets) from the distro
        #  - this includes top level html (with codec versions) + some qualiTI codec test reports
        for i in $(find . -name "*.html") ; do
                install ${i} ${D}/${datadir}/ti-codec-combos
        done

}

do_stage () {
	install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combos
	cp -pPrf ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combos
	for codec in encode decode ; do
		mkdir -p  ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combos/packages/ti/sdo/servers/$codec/package/info/${datadir}/ti-codec-combos
		ln -sf ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combos/packages/ti/sdo/servers/$codec/package/info/$codec* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combos/packages/ti/sdo/servers/$codec/package/info/${datadir}/ti-codec-combos
	done
}

FILES_ti-codec-combos = "${datadir}/ti-codec-combos/*"

INHIBIT_PACKAGE_STRIP = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

