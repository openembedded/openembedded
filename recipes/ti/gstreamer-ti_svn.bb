DESCRIPTION = "GSTREAMER Plugin (gstreamer-ti) for TI ARM/DSP processors"
HOMEPAGE = "https://gforge.ti.com/gf/project/gstreamer_ti/"
SECTION = "multimedia"

# TODO :: Replace omapl137 with official support in GST (currently linking to omapl138)
# TODO :: Codec Server Environment Variables shouldn't be required
# TODO :: Add (and check) rc scripts for all targets (just copied for now) (365,6467,omapl137)
# TODO :: Check if CPPFLAGS_append is still required
# TODO :: Remove ENCODE/DECODE combo exports - these are not used anymore (check?)

inherit autotools
inherit update-rc.d

require ti-paths.inc
require ti-staging.inc

PROVIDES += "gstreamer-ti-demo-script"

PV = "svnr${SRCREV}"
# Rebuild on kernel change since it links statically to ti-dmai, ti-codec-engine, etc
PR = "r49+${MACHINE_KERNEL_PR}"


S = "${WORKDIR}/gstreamer_ti/ti_build/ticodecplugin"

GST_TI_RC_SCRIPT_dm6446   = "gstreamer-ti-dm6446-rc.sh"
GST_TI_RC_SCRIPT_dm6467   = "gstreamer-ti-dm6467-rc.sh"
GST_TI_RC_SCRIPT_omap3    = "gstreamer-ti-omap3530-rc.sh"
GST_TI_RC_SCRIPT_dm355    = "gstreamer-ti-dm355-rc.sh"
GST_TI_RC_SCRIPT_dm365    = "gstreamer-ti-dm365-rc.sh"
GST_TI_RC_SCRIPT_omapl137 = "gstreamer-ti-omapl137-rc.sh"
GST_TI_RC_SCRIPT_omapl138 = "gstreamer-ti-omapl138-rc.sh"

SRCREV = "573"

SRC_URI = "svn://gforge.ti.com/svn/gstreamer_ti/trunk;module=gstreamer_ti;proto=https;user=anonymous;pswd='' \
           file://gstreamer-ti-tracker-462.patch;patch=1 \
           file://gstreamer-ti-remove-mp3-decode-support-from-auddec1.patch;patch=1 \
           file://${GST_TI_RC_SCRIPT} \
"

SRC_URI_append_omap3 = " \
           file://gstreamer-ti-add-omapfb.patch;patch=1 \
"

SRC_URI_append_omapl137 = " \
           file://gstreamer-ti-omapl137.patch;patch=1 \
"

SRC_URI_append_omapl138 = " \
           file://gstreamer-ti-omapl138.patch;patch=1 \
"

SRC_URI_append_dm6467 = " \
           file://gstreamer-ti-dm6467-usesinglecsserver.patch;patch=1 \
"

DEPENDS = "ti-dmai gstreamer gst-plugins-base gst-plugins-good gst-plugins-ugly"

# gstreamer_ti picks up some config variables from the environment
# - variables are used in the gstreamer makefile
#   - PLATFORM, XDC_PLATFORM, XDC_TARGET, MVTOOL_DIR  
# - others used by config.bld (which it gets from the dmai config.bld)
#   - CROSS_COMPILE, PLATFORM_XDC

PLATFORM_dm6446        = "dm6446"
PLATFORM_dm6467        = "dm6467"
PLATFORM_omap3         = "omap3530"
PLATFORM_dm355         = "dm355"
PLATFORM_dm365         = "dm365"
PLATFORM_omapl137      = "omapl137"
PLATFORM_omapl138      = "omapl138"
PLATFORM              ?= "<UNDEFINED_PLATFORM>"

XDC_PLATFORM_dm6446    = "ti.platforms.evmDM6446"
XDC_PLATFORM_dm6467    = "ti.platforms.evmDM6467"
XDC_PLATFORM_omap3     = "ti.platforms.evm3530"
XDC_PLATFORM_dm355     = "ti.platforms.evmDM355"
XDC_PLATFORM_dm365     = "ti.platforms.evmDM365"
XDC_PLATFORM_omapl137  = "ti.platforms.evmOMAPL137"
XDC_PLATFORM_omapl138  = "ti.platforms.evmOMAPL138"
XDC_PLATFORM          ?= "<UNDEFINED_XDC_PLATFORM>"

export PLATFORM
export XDC_PLATFORM
export XDC_TARGET      = "gnu.targets.arm.GCArmv5T"
export PLATFORM_XDC    = ${XDC_PLATFORM}
export MVTOOL_DIR      = "${TOOLCHAIN_PATH}"
export CROSS_COMPILE   = "${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}"

# Makefile also expects to be able to find the kernel headers from the envirionment
export LINUXKERNEL_INSTALL_DIR = ${STAGING_KERNEL_DIR} 

# export codec combo (or server) locations
# Why do we need to do this?? - These will get picked up from CODEC_INSTALL_DIR?
# Sould only need this if we change from default server

export HMJCP_COMBO     = "${installdir}/ti-codecs-server/hmjcp.accel"
export CODEC_SERVER    = "${installdir}/ti-codecs-server/cs.x64P"

# TODO :: These 2 can be removed now since dm6467 uses single CS server (like omap/omapl)
export ENCODE_COMBO    = "${installdir}/ti-codecs-server/encodeCombo.x64P"
export DECODE_COMBO    = "${installdir}/ti-codecs-server/decodeCombo.x64P"

CPPFLAGS_append = " -DPlatform_${PLATFORM}"

do_configure_prepend() {
    sed -i -e 's:(LINK_INSTALL_DIR)/packages:(LINK_INSTALL_DIR):g' ${S}/src/Makefile.am

    # TODO :: Is this still true?
    # PSP kernel is based on older DSS. we need to replace linux/omapfb.h with mach/omapfb.h
    if ! [ -e ${STAGING_KERNEL_DIR}/include/linux/omapfb.h ] ; then
         sed -i -e s:linux/omapfb:mach/omapfb:g ${S}/src/omapfb.h || true
    fi
}

do_install_prepend () {

    # install gstreamer demo scripts
    install -d ${D}/${installdir}/gst
    cp -r ${WORKDIR}/gstreamer_ti/gstreamer_demo/shared ${D}/${installdir}/gst

    if [ -d ${WORKDIR}/gstreamer_ti/gstreamer_demo/${PLATFORM} ] ; then
        cp -r ${WORKDIR}/gstreamer_ti/gstreamer_demo/${PLATFORM} ${D}/${installdir}/gst
        
        # default loadmodules script is hard-coded for insmod, change to modprobe
        sed -i 's/insmod/modprobe/g' ${D}/${installdir}/gst/${PLATFORM}/loadmodules.sh
        sed -i 's/.ko//g' ${D}/${installdir}/gst/${PLATFORM}/loadmodules.sh

        if [ "${PLATFORM}" = "omap3530" ]; then
            echo "modprobe sdmak" >> ${D}/${installdir}/gst/${PLATFORM}/loadmodules.sh
        fi
    fi

    chmod 0755 ${D}/${installdir}/gst -R
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755  ${WORKDIR}/${GST_TI_RC_SCRIPT} ${D}${sysconfdir}/init.d/gstti-init
}

RRECOMMENDS_${PN}_append_dm6446    += "ti-codecs-dm6446-server   ti-cmem-module ti-dsplink-module"
RRECOMMENDS_${PN}_append_dm6467    += "ti-codecs-dm6467          ti-cmem-module ti-dsplink-module"
RRECOMMENDS_${PN}_append_omap3     += "ti-codecs-omap3530-server ti-cmem-module ti-dsplink-module ti-lpm-module ti-sdma-module"
RRECOMMENDS_${PN}_append_dm355     += "ti-codecs-dm355           ti-cmem-module ti-dm355mm-module"
RRECOMMENDS_${PN}_append_dm365     += "ti-codecs-dm365           ti-cmem-module ti-dm365mm-module ti-edma-module ti-irq-module"
RRECOMMENDS_${PN}_append_omapl137  += "ti-codecs-omapl137-server ti-cmem-module ti-dsplink-module"
RRECOMMENDS_${PN}_append_omapl138  += "ti-codecs-omapl138-server ti-cmem-module ti-dsplink-module"

FILES_${PN}     += "${libdir}/gstreamer-0.10/*.so ${sysconfdir}"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.a ${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"

PACKAGES += "gstreamer-ti-demo-script"
RDEPENDS_gstreamer-ti-demo-script = "${PN}"

FILES_gstreamer-ti-demo-script = "${installdir}/gst/*"

pkg_postinst_gstreamer-ti-demo-script () {
        ln -sf ${installdir}/ti-codecs-server/* ${installdir}/gst/${PLATFORM}/
}

INITSCRIPT_NAME = "gstti-init"
INITSCRIPT_PARAMS = "start 30 5 2 . stop 40 0 1 6 ."

