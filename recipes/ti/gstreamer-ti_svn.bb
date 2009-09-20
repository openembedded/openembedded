DESCRIPTION = "Gstreamer plugin for TI Davinci and OMAP processors"

require ti-paths.inc

inherit autotools

DEPENDS = "ti-dmai gstreamer gst-plugins-base gst-plugins-good gst-plugins-ugly"

# Fetch source from svn repo
SRCREV = "335"
SRC_URI = "svn://gforge.ti.com/svn/gstreamer_ti/trunk;module=gstreamer_ti;proto=https;user=anonymous;pswd='' \
           file://gstreamer-ti-tracker-824.patch;patch=1 \
           file://gstreamer-ti-tracker-462.patch;patch=1 \
           file://gstreamer-ti-remove-mp3-decode-support-from-auddec1.patch;patch=1 \
"

SRC_URI_append_armv7a = " \
           file://gstreamer-ti-add-omapfb.patch;patch=1 \
"

# Again, no '.' in PWD allowed :(
PR = "r36"
PV = "svnr${SRCREV}"

S = "${WORKDIR}/gstreamer_ti/ti_build/ticodecplugin"

XDC_TARGET  				= gnu.targets.arm.GCArmv5T
XDC_PLATFORM_dm355-evm 		= ti.platforms.evmDM355
XDC_PLATFORM_dm6446-evm 	= ti.platforms.evmDM6446
XDC_PLATFORM_da830-omapl137-evm 	= ti.platforms.omapl137
PLATFORM_XDC				= ${XDC_PLATFORM}

export XDC_TARGET
export XDC_PLATFORM
export PLATFORM_XDC 

PLATFORM_dm355-evm 			= "dm355"
PLATFORM_dm6446-evm 		= "dm6446"
PLATFORM_da830-omapl137-evm = "ol137"

CPPFLAGS_append 			= " -DPlatform_${PLATFORM}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# export codec combo (or server) locations
export HMJCP_COMBO  = "${installdir}/codec-combo/hmjcp.accel"
export CODEC_SERVER = "${installdir}/codec-combo/cs.x64P"
export ENCODE_COMBO = "${installdir}/codec-combo/encodeCombo.x64P" 
export DECODE_COMBO = "${installdir}/codec-combo/decodeCombo.x64P"

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

RDEPENDS_${PN} = " \
gst-plugins-base-meta \
gst-plugins-good-meta \
gst-plugins-bad-meta \
gst-plugins-ugly-meta \
ti-dmai-apps"

FILES_${PN} += "${libdir}/gstreamer-0.10/*.so"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.a ${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"

