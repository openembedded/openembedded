DESCRIPTION = "Gstreamer plugin for TI Davinci and OMAP processors"
DEPENDS = "ti-dmai gstreamer gst-plugins-base gst-plugins-good gst-plugins-ugly"

SRCREV = "459"
# Again, no '.' in PWD allowed :(
PV = "svnr${SRCREV}"
PR = "r37"

GST_TI_RC_SCRIPT_omap3 = "gstreamer-ti-omap3530-rc.sh"
GST_TI_RC_SCRIPT_dm6446="gstreamer-ti-dm6446-rc.sh"
GST_TI_RC_SCRIPT_dm355="gstreamer-ti-dm355-rc.sh"

SRC_URI = "svn://gforge.ti.com/svn/gstreamer_ti/trunk;module=gstreamer_ti;proto=https;user=anonymous;pswd='' \
           file://gstreamer-ti-tracker-462.patch;patch=1 \
           file://gstreamer-ti-remove-mp3-decode-support-from-auddec1.patch;patch=1 \
           file://${GST_TI_RC_SCRIPT} \
"

SRC_URI_append_omap3 = " \
           file://gstreamer-ti-add-omapfb.patch;patch=1 \
"

S = "${WORKDIR}/gstreamer_ti/ti_build/ticodecplugin"

inherit autotools update-rc.d

require ti-paths.inc

XDC_TARGET = "gnu.targets.arm.GCArmv5T"
XDC_PLATFORM_dm6446 = "ti.platforms.evmDM6446"
XDC_PLATFORM_omapl137 = "ti.platforms.omapl137"
PLATFORM_XDC = "${XDC_PLATFORM}"
PLATFORM_dm6446 = "dm6446"
PLATFORM_omapl137 = "ol137"

export XDC_TARGET
export XDC_PLATFORM
export PLATFORM_XDC
# export codec combo (or server) locations
export HMJCP_COMBO  = "${installdir}/codec-combo/hmjcp.accel"
export CODEC_SERVER = "${installdir}/codec-combo/cs.x64P"
export ENCODE_COMBO = "${installdir}/codec-combo/encodeCombo.x64P"
export DECODE_COMBO = "${installdir}/codec-combo/decodeCombo.x64P"

CPPFLAGS_append = " -DPlatform_${PLATFORM}"

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
        install -d ${D}${sysconfdir}/init.d/
        install -m 0755  ${WORKDIR}/${GST_TI_RC_SCRIPT} ${D}${sysconfdir}/init.d/gstti-init
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGES += "gstreamer-ti-demo-script"

RDEPENDS_gstreamer-ti-demo-script = "${PN}"
RRECOMMENDS_${PN} = " \
gst-plugins-base-meta \
gst-plugins-good-meta \
gst-plugins-bad-meta \
gst-plugins-ugly-meta \
ti-dmai-apps"

FILES_gstreamer-ti-demo-script = "${installdir}/gst/*"
FILES_${PN} += "${libdir}/gstreamer-0.10/*.so ${sysconfdir}"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.a ${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"

pkg_postinst_gstreamer-ti-demo-script () {
        ln -sf ${installdir}/codec-combo/* ${installdir}/gst/${PLATFORM}/
}

INITSCRIPT_NAME = "gstti-init"
INITSCRIPT_PARAMS = "start 30 5 2 . stop 40 0 1 6 ."

