DESCRIPTION = "DMAI for TI ARM/DSP processors"
SECTION = "multimedia"

require ti-paths.inc
require ti-staging.inc
inherit module-base

#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "e"

# Yes, the xdc stuff still breaks with a '.' in PWD
PE = "1"
PV = "1.0+svnr${SRCPV}"

BRANCH = "branches/BRANCH_BRIJESH_DMAI_DEV_2_xx"
BRANCH_omapl138 = "trunk"
BRANCH_omapl137 = "trunk"
BRANCH_dm6467 = "branches/GITPSP_INT_101009"
BRANCH_dm355 = "branches/GITPSP_INT_101009"
BRANCH_dm365 = "branches/GITPSP_INT_101009"
BRANCH_omap3 = "trunk"

SRCREV = "423"
SRCREV_dm6467 = "424"
SRCREV_dm355 = "424"
SRCREV_dm365 = "424"

SRC_URI = "svn://gforge.ti.com/svn/dmai/;module=${BRANCH};proto=https;user=anonymous;pswd='' \
		file://loadmodules-ti-dmai-dm355_al.sh \
		file://loadmodules-ti-dmai-dm365_al.sh \
		file://loadmodules-ti-dmai-dm6446_al.sh \
		file://loadmodules-ti-dmai-dm6467_al.sh \
		file://loadmodules-ti-dmai-o3530_al.sh \
		file://loadmodules-ti-dmai-ol138_al.sh \
	"

S = "${WORKDIR}/${BRANCH}/davinci_multimedia_application_interface"

INHIBIT_PACKAGE_STRIP = "1"

# compile time dependencies
DEPENDS = "alsa-lib ti-framework-components ti-codec-engine ti-xdctools"

DEPENDS_append_omap3    = " ti-dspbios ti-cgt6x ti-codecs-omap3530 virtual/kernel ti-linuxutils"
DEPENDS_append_dm6446 	= " ti-dspbios ti-cgt6x ti-codecs-dm6446 virtual/kernel ti-linuxutils"
DEPENDS_append_dm6467 	= " ti-dspbios ti-cgt6x ti-codecs-dm6467 virtual/kernel ti-linuxutils"
DEPENDS_append_dm355  	= " ti-codecs-dm355 virtual/kernel"
DEPENDS_append_dm365    = " ti-codecs-dm365 virtual/kernel"
DEPENDS_append_omapl137 = " ti-dspbios ti-cgt6x ti-codecs-omapl137 virtual/kernel ti-linuxutils"
DEPENDS_append_omapl138 = " ti-dspbios ti-cgt6x ti-codecs-omapl138 virtual/kernel ti-linuxutils"

# Define DMAI build time variables
TARGET_omap3     = "o3530_al"
TARGET_dm6446    = "dm6446_al"
TARGET_dm6467    = "dm6467_al"
TARGET_omapl137 = "ol137_al"
TARGET_omapl138 = "ol138_al"
TARGET_dm355     = "dm355_al"
TARGET_dm365     = "dm365_al"
TARGET          ?= "all"

USER_XDC_PATH = "${CE_INSTALL_DIR}/examples"

PARALLEL_MAKE = ""

do_configure () {
	 sed -i -e 's:(LINK_INSTALL_DIR)/packages:(LINK_INSTALL_DIR):g' ${S}/dmai/packages/ti/sdo/dmai/apps/Makefile.app
	 sed -i -e 's:(LINK_INSTALL_DIR)/packages:(LINK_INSTALL_DIR):g' ${S}/dmai/packages/ti/sdo/dmai/Makefile

	# PSP kernel is based on older DSS. we need to replace linux/omapfb.h with
	# mach/omapfb.h 

    if ! [ -e ${STAGING_KERNEL_DIR}/include/linux/omapfb.h ] ; then 
        sed -i -e s:linux/omapfb:mach/omapfb:g ${S}/dmai/packages/ti/sdo/dmai/linux/Display_fbdev.c
        sed -i -e s:linux/omapfb:mach/omapfb:g ${S}/dmai/packages/ti/sdo/dmai/linux/priv/_Display.h
    fi
}


do_compile () {

	unset DMAI_INSTALL_DIR
	cd ${S}
	make XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" PLATFORM="${TARGET}" clean

	for dir in ${S}/dmai ${S}/tests ; do
		cd $dir
		#  TODO: Figure out how to pass the alsa require location, currently 
		#  LINUXLIBS_INSTALL_DIR is hard-coded for armv5te
		make CE_INSTALL_DIR="${CE_INSTALL_DIR}" \
			CODEC_INSTALL_DIR="${CODEC}" \
			FC_INSTALL_DIR="${FC_INSTALL_DIR}" \
			LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
			XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" \
			CODEGEN_INSTALL_DIR="${CODEGEN_INSTALL_DIR}" \
			BIOS_INSTALL_DIR="${BIOS_INSTALL_DIR}"\
			LINUXLIBS_INSTALL_DIR="${STAGING_DIR_TARGET}/usr" \
			USER_XDC_PATH="${USER_XDC_PATH}" \
			CROSS_COMPILE="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}" \
			VERBOSE="true" \
			XDAIS_INSTALL_DIR="${XDAIS_INSTALL_DIR}" \
			LINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
			CMEM_INSTALL_DIR="${CMEM_INSTALL_DIR}" \
			LPM_INSTALL_DIR="${LPM_INSTALL_DIR}" \	
			MVTOOL_PREFIX="${TARGET_PREFIX}" \
			PLATFORM="${TARGET}" 
	done
}

do_install () {
    unset DMAI_INSTALL_DIR
    # install dmai apps on target
    install -d ${D}/${installdir}/dmai-apps
    cd ${S}/dmai
    make PLATFORM="${TARGET}" EXEC_DIR=${D}/${installdir}/dmai-apps install 
    install -m 0755 ${WORKDIR}/loadmodules-ti-dmai-${TARGET}.sh ${D}/${installdir}/dmai-apps/loadmodule.sh 

    install -d ${D}/${installdir}/dmai-tests
    cd ${S}/tests
    make PLATFORM="${TARGET}" EXEC_DIR=${D}/${installdir}/dmai-tests install 
    install -m 0755 ${WORKDIR}/loadmodules-ti-dmai-${TARGET}.sh ${D}/${installdir}/dmai-tests/loadmodule.sh 

    install -d ${D}${DMAI_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/dmai/* ${D}${DMAI_INSTALL_DIR_RECIPE}
}

pkg_postinst_ti-dmai-apps () {
	ln -sf ${installdir}/codec-combo/* ${installdir}/dmai-apps/
}

# Disable QA check untils we figure out how to pass LDFLAGS in build
INSANE_SKIP_${PN} = True
INSANE_SKIP_ti-dmai-apps = True
INSANE_SKIP_ti-dmai-tests = True

PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_PACKAGE_STRIP = "1"
PACKAGES += "ti-dmai-apps ti-dmai-tests"
FILES_ti-dmai-apps = "${installdir}/dmai-apps/*"
FILES_ti-dmai-tests = "${installdir}/dmai-tests/*"

# run time dependencies 
RDEPENDS_ti-dmai-apps_dm355 += "ti-dm355mm-module ti-cmem-module ti-codecs-dm355"
RDEPENDS_ti-dmai-apps_dm365 += "ti-dm365mm-module ti-cmem-module ti-codecs-dm365"
RDEPENDS_ti-dmai-apps_dm6446 += "ti-cmem-module ti-dsplink-module ti-codecs-dm6446"
RDEPENDS_ti-dmai-apps_dm6467 += "ti-cmem-module ti-dsplink-module ti-codecs-dm6467"
RDEPENDS_ti-dmai-apps_omap3 += "ti-cmem-module ti-dsplink-module ti-codecs-omap3530 ti-lpm-module ti-sdma-module"
RDEPENDS_ti-dmai-apps_omapl137 += "ti-cmem-module ti-dsplink-module ti-codecs-omapl137"
RDEPENDS_ti-dmai-apps_omapl138 += "ti-cmem-module ti-dsplink-module ti-codecs-omapl138"

