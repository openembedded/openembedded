require ti-dmai.inc
require ti-paths.inc

inherit module-base

#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "b"

# compile time dependencies
DEPENDS_omap3evm  += "alsa-lib ti-codec-engine ti-xdctools-native ti-dspbios-native ti-cgt6x-native ti-cs1-omap3530 virtual/kernel ti-dsplink-module"
DEPENDS_armv7a	+= "alsa-lib  ti-codec-engine ti-xdctools-native ti-dspbios-native ti-cgt6x-native ti-cs1-omap3530 virtual/kernel ti-dsplink-module "
DEPENDS_dm6446-evm 	+= "alsa-lib  ti-codec-engine ti-xdctools-native ti-dspbios-native ti-cgt6x-native ti-codec-combo-dm6446 virtual/kernel ti-dsplink-module "
DEPENDS_dm355-evm  	+= "alsa-lib ti-codec-engine ti-xdctools-native ti-codec-combo-dm355 virtual/kernel"
DEPENDS_da830-omapl137-evm 	+= "alsa-lib  ti-codec-engine ti-xdctools-native ti-dspbios-native ti-cgt6x-native ti-codec-combo-omapl137 virtual/kernel ti-dsplink-module "

# Define DMAI build time variables
TARGET 			?= "all"
TARGET_armv7a 	?= "o3530_al"
TARGET_dm355-evm 	?= "dm355_al"
TARGET_dm6446-evm 	?= "dm6446_al"
TARGET_da830-omapl137-evm 	?= "ol137_al"

DSPBIOS_DIR = "${STAGING_DIR_NATIVE}/ti-dspbios-native"
CGT6x_DIR = "${STAGING_DIR_NATIVE}/ti-cgt6x-native"
XDCTOOLS_DIR = "${STAGING_DIR_NATIVE}/ti-xdctools-native"
USER_XDC_PATH = "${CE_INSTALL_DIR}/examples"

PARALLEL_MAKE = ""

do_configure () {

	# PSP kernel is based on older DSS. we need to replace linux/omapfb.h with
	# mach/omapfb.h 

    if [ ${MACHINE} == "omap3evm" ] ; then
        sed -i -e s:linux/omapfb:mach/omapfb:g ${S}/dmai/packages/ti/sdo/dmai/linux/Display_fbdev.c
        sed -i -e s:linux/omapfb:mach/omapfb:g ${S}/dmai/packages/ti/sdo/dmai/linux/priv/_Display.h
    fi
}


do_compile () {

	unset DMAI_INSTALL_DIR
	cd ${S}
	make XDC_INSTALL_DIR="${XDCTOOLS_DIR}" clean

	#  TODO: Figure out how to pass the alsa include location, currently 
    #  LINUXLIBS_INSTALL_DIR is hard-coded for armv5te
	make CE_INSTALL_DIR="${CE_INSTALL_DIR}" \
		CODEC_INSTALL_DIR="${CODEC}" \
		FC_INSTALL_DIR="${FC_INSTALL_DIR}" \
		LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
		XDC_INSTALL_DIR="${XDCTOOLS_DIR}" \
		CODEGEN_INSTALL_DIR="${CGT6x_DIR}" \
		BIOS_INSTALL_DIR="${DSPBIOS_DIR}"\
		LINUXLIBS_INSTALL_DIR="${STAGING_DIR_HOST}/usr" \
		USER_XDC_PATH="${USER_XDC_PATH}" \
		CROSS_COMPILE="${CROSS_DIR}/bin/${TARGET_PREFIX}" \
		VERBOSE="true" \
		XDAIS_INSTALL_DIR="${CE_INSTALL_DIR}/cetools" \
		LINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
		CMEM_INSTALL_DIR="${CE_INSTALL_DIR}/cetools" \
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
RDEPENDS_ti-dmai-apps_dm355-evm += "ti-dm355mm-module ti-cmem-module ti-codec-combo-dm355"
RDEPENDS_ti-dmai-apps_dm6446-evm += "ti-cmem-module ti-dsplink-module ti-codec-combo-dm6446"
RDEPENDS_ti-dmai-apps_omap3evm += "ti-cmem-module ti-dsplink-module ti-cs1-omap3530 ti-lpm-module ti-sdma-module"
RDEPENDS_ti-dmai-apps_armv7a += "ti-cmem-module ti-dsplink-module ti-cs1-omap3530 ti-lpm-module ti-sdma-module"
RDEPENDS_ti-dmai-apps_da830-omapl137-evm += "ti-cmem-module ti-dsplink-module ti-codec-combo-ol137"

