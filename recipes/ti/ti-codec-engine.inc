DESCRIPTION = "Codec Engine for TI ARM/DSP processors"

require ti-paths.inc

# compile time dependencies
DEPENDS = "ti-framework-components ti-xdais ti-xdctools ti-cgt6x ti-biosutils ti-edma3lld"

DEPENDS_append_dm6446 	= " ti-dspbios ti-linuxutils ti-dsplink-module"
DEPENDS_append_omap3   	= " ti-dspbios ti-linuxutils ti-dsplink-module ti-lpm-module"
DEPENDS_append_omapl138 = " ti-dspbios ti-linuxutils ti-dsplink-module"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/ce/${PV}/exports/codec_engine_${PV},lite.tar.gz;name=cetarball"

# Set the source directory
S = "${WORKDIR}/codec_engine_${PV}"

# Define Device variable
DEVICES           = ""
DEVICES_dm6446 	 ?= "DM6446"
DEVICES_dm6467   ?= "DM6467"
DEVICES_omap3    ?= "OMAP3530"
DEVICES_dm355    ?= "DM355"
DEVICES_dm365    ?= "DM365"
DEVICES_omapl137 ?= "OMAPL137"
DEVICES_omapl138 ?= "OMAPL138"

#define PROGRAM variables
#TODO - should we build APP_LOCAL for SOCs as well?? - probably?
PROGRAMS         ?= "APP_CLIENT DSP_SERVER"
PROGRAMS_dm355    = "APP_LOCAL"
PROGRAMS_dm365    = "APP_LOCAL"

CGT6x_DIR = "${CODEGEN_INSTALL_DIR}"
XDCTOOLS_DIR = "${XDC_INSTALL_DIR}"
CE_INSTALL_DIR = "${S}"

do_compile () {

	# No way to pass this via ENV?
	sed -i  \
		-e s:arm-none-linux-gnueabi-:${TARGET_PREFIX}:g \
		${S}/examples/xdcpaths.mak

        for i in codecs extensions servers apps ; do
                cd ${S}/examples/ti/sdo/ce/examples/$i
                make DEVICES="${DEVICES}" \
                     GPPOS="${GPPOS}" \
                     PROGRAMS="${PROGRAMS}" \
                     CE_INSTALL_DIR="${CE_INSTALL_DIR}" \
                     XDC_INSTALL_DIR="${XDCTOOLS_DIR}" \
                     BIOS_INSTALL_DIR="${BIOS_INSTALL_DIR}" \
                     BIOSUTILS_INSTALL_DIR="${BIOSUTILS_INSTALL_DIR}" \
		     DSPLINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
                     XDAIS_INSTALL_DIR="${XDAIS_INSTALL_DIR}" \
                     FC_INSTALL_DIR="${FC_INSTALL_DIR}" \
                     CMEM_INSTALL_DIR="${CMEM_INSTALL_DIR}" \
                     LPM_INSTALL_DIR="${LPM_INSTALL_DIR}" \
                     EDMA3_LLD_INSTALL_DIR="${EDMA3_LLD_INSTALL_DIR}" \
                     CGTOOLS_V5T="${TOOLCHAIN_PATH}" \
                     CGTOOLS_C64P="${CGT6x_DIR}" \
                     CGTOOLS_C674="${CGT6x_DIR}" \
                     clean all
        done
}

do_install() {

	install -d ${D}/${installdir}/codec-engine-apps
	cp ${S}/examples/apps/system_files/${DEVICES}/loadmodules.sh ${D}/${installdir}/codec-engine-apps

	cd ${S}/examples/ti/sdo/ce/examples

	# Install the apps, servers and test data, mirroring the source directory structure
	#  - Put the servers inside the same folder as the executable
	#  - TODO - Check nested dirs (e.g. dualcpu_separateconfig)

        # Put all servers in separate tree.
        for i in $(find . -name "*.${DSPSUFFIX}"); do
                install -d ${D}/${installdir}/codec-engine-apps/servers/`dirname ${i} | cut -f3 -d /`
                install ${i} ${D}/${installdir}/codec-engine-apps/servers/`dirname ${i} | cut -f3 -d /`
        done

	for i in $(find . -name "*.xv5T"); do
		install -d ${D}/${installdir}/codec-engine-apps/`dirname ${i} | cut -f3 -d /`
		install ${i} ${D}/${installdir}/codec-engine-apps/`dirname ${i} | cut -f3 -d /`
	done

	for i in $(find . -name "*.dat"); do
		install -d ${D}/${installdir}/codec-engine-apps/`dirname ${i} | cut -f3 -d /`
		install ${i} ${D}/${installdir}/codec-engine-apps/`dirname ${i} | cut -f3 -d /`
        done

	# For each directory, softlink to the app server, except special cases
	cd ${D}/${installdir}/codec-engine-apps
	for i in $(find . -type d | grep -v servers); do
		{
		pwd
		cd ${D}/${installdir}/codec-engine-apps/$i
		if [ $(basename $i) == "audio1_ires" ] ; then 
			ln -s ../servers/audio1_ires/audio1_ires.${DSPSUFFIX}
		elif [ $(basename $i) == "server_api_example" ] ; then
			ln -s ../servers/server_api_example/audio_copy.${DSPSUFFIX}
                elif [ $(basename $i) != "." ] ; then
			ln -s ../servers/all_codecs/all.${DSPSUFFIX}
		else
			echo Skipping $i
		fi
		}
	done
}


# We can't use CE_INSTALL_DIR directly since we redefined it earlier on
do_stage() {
    install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${CE_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${CE_INSTALL_DIR_RECIPE}
}


RDEPENDS_ti-codec-engine-apps = "ti-cmem-module"
RDEPENDS_append_dm6446   = " ti-dsplink-module"
RDEPENDS_append_omap3    = " ti-dsplink-module"
RDEPENDS_append_omapl138 = " ti-dsplink-module"

PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_PACKAGE_STRIP = "1"
PACKAGES += "ti-codec-engine-apps"
FILES_ti-codec-engine-apps = "${installdir}/codec-engine-apps/*"
INSANE_SKIP_ti-codec-engine-apps = True

