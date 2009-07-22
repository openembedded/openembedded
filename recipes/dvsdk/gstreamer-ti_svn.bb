DESCRIPTION = "Gstreamer plugin for TI Davinci and OMAP processors"

inherit autotools

DEPENDS = "ti-dmai gstreamer gst-plugins-base gst-plugins-good gst-plugins-ugly"

# Fetch source from svn repo
SRCREV = "308"
SRC_URI = "svn://gforge.ti.com/svn/gstreamer_ti/trunk;module=gstreamer_ti;proto=https;user=anonymous;pswd='' \
file://codec_combo_directory_fix.patch;patch=1 \
	"

# Again, no '.' in PWD allowed :(
PR = "r24"
PV = "svnr${SRCREV}"

S = "${WORKDIR}/gstreamer_ti/ti_build/ticodecplugin"

installdir = "${datadir}/ti"

META_SDK_PATH ?= "${CROSS_DIR}"

DMAI_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-dmai"
CE_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine"
FC_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"
CODEC_INSTALL_DIR_dm355-evm="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combo-dm355"
CODEC_INSTALL_DIR_dm6446-evm="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combo-dm6446"
CODEC_INSTALL_DIR_omap3evm="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combo-omap3530"
CODEC_INSTALL_DIR_beagleboard="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combo-omap3530"
XDC_INSTALL_DIR="${STAGING_DIR}/${BUILD_SYS}/ti-xdctools-native"
CODEGEN_INSTALL_DIR="${STAGING_DIR}/${BUILD_SYS}/ti-cgt6x-native"

export DMAI_INSTALL_DIR
export CE_INSTALL_DIR
export FC_INSTALL_DIR
export CODEC_INSTALL_DIR
export XDC_INSTALL_DIR
export CODEGEN_INSTALL_DIR

XDC_TARGET  				= gnu.targets.arm.GCArmv5T
XDC_PLATFORM_dm355-evm 		= ti.platforms.evmDM355
XDC_PLATFORM_dm6446-evm 	= ti.platforms.evmDM6446
XDC_PLATFORM_omap3evm  		= ti.platforms.evm3530
XDC_PLATFORM_beagleboard	= ti.platforms.evm3530
PLATFORM_XDC				= ${XDC_PLATFORM}

export XDC_TARGET
export XDC_PLATFORM
export PLATFORM_XDC 

PLATFORM_dm355-evm 			= "dm355"
PLATFORM_dm6446-evm 		= "dm6446"
PLATFORM_omap3evm 			= "omap3530"
PLATFORM_beagleboard		= "omap3530"

export PLATFORM

CROSS_COMPILE=${META_SDK_PATH}/bin/${TARGET_PREFIX}
CSTOOL_DIR=${META_SDK_PATH}
MVTOOL_DIR=${META_SDK_PATH}
export CROSS_COMPILE
export CSTOOL_DIR
export MVTOOL_DIR

CPPFLAGS_append 			= " -DPlatform_${PLATFORM}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install_prepend () {
	# install gstreamer demo scripts
	install -d ${D}/${installdir}/gst
	cp -r ${WORKDIR}/gstreamer_ti/gstreamer_demo/shared ${D}/${installdir}/gst
	cp -r ${WORKDIR}/gstreamer_ti/gstreamer_demo/${PLATFORM} ${D}/${installdir}/gst

	# default loadmodule script is hard-coded for insmod, change to modprobe
	sed -i 's/insmod/modprobe/g' ${D}/${installdir}/gst/${PLATFORM}/loadmodules.sh
	sed -i 's/.ko//g' ${D}/${installdir}/gst/${PLATFORM}/loadmodules.sh
	if [ "${PLATFORM}" = "omap3530" ]; then
		echo "modprobe sdmak" >> ${D}/${installdir}/gst/${PLATFORM}/loadmodules.sh
	fi
	chmod 0755 ${D}/${installdir}/gst -R
}

pkg_postinst_gstreamer-ti-demo-script () {
	ln -sf ${installdir}/codec-combo/* ${installdir}/gst/${PLATFORM}/
}

PACKAGES += "gstreamer-ti-demo-script"
FILES_gstreamer-ti-demo-script = "${installdir}/gst/*"
RDEPENDS_gstreamer-ti-demo-script = "gstreamer-ti"

RDEPENDS_${PN} = "ti-dmai-apps"
FILES_${PN} += "${libdir}/gstreamer-0.10/*.so"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.a ${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"

