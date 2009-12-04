require ti-dmai.inc
require ti-paths.inc

inherit module-base

#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "c"

# compile time dependencies
DEPENDS = "alsa-lib ti-framework-components ti-codec-engine ti-xdctools-native"

DEPENDS_append_omap3    = " ti-dspbios-native ti-cgt6x-native ti-codecs-omap3530 virtual/kernel ti-linuxutils"
DEPENDS_append_dm6446 	= " ti-dspbios-native ti-cgt6x-native ti-codecs-dm6446 virtual/kernel ti-linuxutils"
DEPENDS_append_dm355  	= " ti-codecs-dm355 virtual/kernel"
DEPENDS_append_dm365    = " ti-codecs-dm365 virtual/kernel"
DEPENDS_append_omapl137 = " ti-dspbios-native ti-cgt6x-native ti-codecs-omapl137 virtual/kernel ti-linuxutils"
DEPENDS_append_omapl138 = " ti-dspbios-native ti-cgt6x-native ti-codecs-omapl138 virtual/kernel ti-linuxutils"

# Define DMAI build time variables
TARGET_omap3     = "o3530_al"
TARGET_dm6446    = "dm6446_al"
TARGET_omapl137 = "ol137_al"
TARGET_omapl138 = "ol138_al"
TARGET_dm355     = "dm355_al"
TARGET_dm365     = "dm365_al"
TARGET          ?= "all"

CGT6x_DIR = "${STAGING_DIR_NATIVE}/ti-cgt6x-native"
XDCTOOLS_DIR = "${STAGING_DIR_NATIVE}/ti-xdctools-native"
USER_XDC_PATH = "${CE_INSTALL_DIR}/examples"

PARALLEL_MAKE = ""

do_configure () {

	# PSP kernel is based on older DSS. we need to replace linux/omapfb.h with
	# mach/omapfb.h 

    if ![ -e ${STAGING_KERNEL_DIR}/include/linux/omapfb.h ] ; then 
        sed -i -e s:linux/omapfb:mach/omapfb:g ${S}/dmai/packages/ti/sdo/dmai/linux/Display_fbdev.c
        sed -i -e s:linux/omapfb:mach/omapfb:g ${S}/dmai/packages/ti/sdo/dmai/linux/priv/_Display.h
    fi
}


do_compile () {

	unset DMAI_INSTALL_DIR
	cd ${S}
	make XDC_INSTALL_DIR="${XDCTOOLS_DIR}" PLATFORM="${TARGET}" clean

	#  TODO: Figure out how to pass the alsa require location, currently 
    #  LINUXLIBS_INSTALL_DIR is hard-coded for armv5te
	make CE_INSTALL_DIR="${CE_INSTALL_DIR}" \
		CODEC_INSTALL_DIR="${CODEC}" \
		FC_INSTALL_DIR="${FC_INSTALL_DIR}" \
		LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
		XDC_INSTALL_DIR="${XDCTOOLS_DIR}" \
		CODEGEN_INSTALL_DIR="${CGT6x_DIR}" \
		BIOS_INSTALL_DIR="${BIOS_INSTALL_DIR}"\
		LINUXLIBS_INSTALL_DIR="${STAGING_DIR_HOST}/usr" \
		USER_XDC_PATH="${USER_XDC_PATH}" \
		CROSS_COMPILE="${CROSS_DIR}/bin/${TARGET_PREFIX}" \
		VERBOSE="true" \
		XDAIS_INSTALL_DIR="${XDAIS_INSTALL_DIR}" \
		LINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
		CMEM_INSTALL_DIR="${CMEM_INSTALL_DIR}" \
		LPM_INSTALL_DIR="${CE_INSTALL_DIR}/cetools" \	
		PLATFORM="${TARGET}"
}

do_install () {
	unset DMAI_INSTALL_DIR
	# install dmai apps on target
    cd ${S}/dmai
    make PLATFORM="${TARGET}" EXEC_DIR=${D}/${installdir}/dmai-apps install 
	install -m 0755 ${WORKDIR}/loadmodules-ti-dmai-${TARGET}.sh ${D}/${installdir}/dmai-apps/loadmodule.sh 

    cd ${S}/tests
    make PLATFORM="${TARGET}" EXEC_DIR=${D}/${installdir}/dmai-tests install 
	install -m 0755 ${WORKDIR}/loadmodules-ti-dmai-${TARGET}.sh ${D}/${installdir}/dmai-tests/loadmodule.sh 
}

pkg_postinst_ti-dmai-apps () {
	ln -sf ${installdir}/codec-combo/* ${installdir}/dmai-apps/
}

do_stage () {
	install -d ${DMAI_INSTALL_DIR}
	cp -pPrf ${S}/dmai/* ${DMAI_INSTALL_DIR}
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
RDEPENDS_ti-dmai-apps_dm6446 += "ti-cmem-module ti-dsplink-module ti-codecs-dm6446"
RDEPENDS_ti-dmai-apps_omap3 += "ti-cmem-module ti-dsplink-module ti-codecs-omap3530 ti-lpm-module ti-sdma-module"
RDEPENDS_ti-dmai-apps_omapl137 += "ti-cmem-module ti-dsplink-module ti-codecs-omapl137"
RDEPENDS_ti-dmai-apps_omapl138 += "ti-cmem-module ti-dsplink-module ti-codecs-omapl138"

