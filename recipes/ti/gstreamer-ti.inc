DESCRIPTION = "GSTREAMER Plugin (gstreamer-ti) for TI ARM/DSP processors"
HOMEPAGE = "https://gforge.ti.com/gf/project/gstreamer_ti/"
SECTION = "multimedia"
LICENSE = "LGPL"

# TODO :: Replace omapl137 with official support in GST (currently linking to omapl138)
# TODO :: Codec Server Environment Variables shouldn't be required
# TODO :: Add (and check) rc scripts for all targets (just copied for now) (365,6467,omapl137)
# TODO :: Check if CPPFLAGS_append is still required
# TODO :: Remove ENCODE/DECODE combo exports - these are not used anymore (check?)

inherit autotools
inherit update-rc.d
require ti-paths.inc
require ti-staging.inc

# Rebuild on kernel change since it links statically to ti-dmai, ti-codec-engine, etc
PR = "r83+${MACHINE_KERNEL_PR}"

DEPENDS = "ti-dmai gstreamer gst-plugins-base"

# enable c6accel elements on omapl138 and omap3
DEPENDS_append_omapl138 = " ti-c6accel "
EXTRA_OECONF_omapl138 = "--enable-c6accel"
DEPENDS_append_omap3 = " ti-c6accel "
EXTRA_OECONF_omap3 = "--enable-c6accel"
export C6ACCEL_INSTALL_DIR

# gstreamer_ti picks up some config variables from the environment
# - variables are used in the gstreamer makefile
#   - PLATFORM, XDC_PLATFORM, XDC_TARGET, MVTOOL_DIR  
# - others used by config.bld (which it gets from the dmai config.bld)
#   - CROSS_COMPILE, PLATFORM_XDC

PLATFORM_dm6446        = "dm6446"
PLATFORM_dm6467        = "dm6467"
PLATFORM_dm6467t       = "dm6467t"
PLATFORM_omap3         = "omap3530"
PLATFORM_dm355         = "dm355"
PLATFORM_dm365         = "dm365"
PLATFORM_omapl137      = "omapl137"
PLATFORM_omapl138      = "omapl138"
PLATFORM              ?= "<UNDEFINED_PLATFORM>"
GST_TI_PLATFORM = ${PLATFORM}

XDC_PLATFORM_dm6446    = "ti.platforms.evmDM6446"
XDC_PLATFORM_dm6467    = "ti.platforms.evmDM6467"
XDC_PLATFORM_omap3     = "ti.platforms.evm3530"
XDC_PLATFORM_dm355     = "ti.platforms.evmDM355"
XDC_PLATFORM_dm365     = "ti.platforms.evmDM365"
XDC_PLATFORM_omapl137  = "ti.platforms.evmOMAPL137"
XDC_PLATFORM_omapl138  = "ti.platforms.evmOMAPL138"
XDC_PLATFORM          ?= "<UNDEFINED_XDC_PLATFORM>"

export PLATFORM
export GST_TI_PLATFORM
export XDC_PLATFORM
export XDC_TARGET      = "gnu.targets.arm.GCArmv5T"
export PLATFORM_XDC    = ${XDC_PLATFORM}
export MVTOOL_DIR      = "${TOOLCHAIN_PATH}"
export CROSS_COMPILE   = "${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}"
export LINK_XDC_ROOT   = "${LINK_INSTALL_DIR}"

# export codec combo (or server) locations
# Why do we need to do this?? - These will get picked up from CODEC_INSTALL_DIR?
# Sould only need this if we change from default server

export CODEC_SERVER  = "${installdir}/ti-codecs-server/cs.x64P"
CPPFLAGS_append = " -DPlatform_${PLATFORM}"

# We are still using encode/decode combo for DM6446
export ENCODE_COMBO    = "${installdir}/ti-codecs-server/encodeCombo.x64P"
export DECODE_COMBO    = "${installdir}/ti-codecs-server/decodeCombo.x64P"
# Makefile also expects to be able to find the kernel headers from the envirionment
export LINUXKERNEL_INSTALL_DIR = "${STAGING_KERNEL_DIR}"

do_configure_prepend() {
	# PSP kernel is based on older DSS. we need to replace linux/omapfb.h with mach/omapfb.h
	if ! [ -e ${STAGING_KERNEL_DIR}/include/linux/omapfb.h ] ; then
		sed -i -e s:linux/omapfb:mach/omapfb:g ${S}/src/omapfb.h || true
	fi

	# Angstrom 2008 breaks with -Wl,-T, while angstrom 2010 needs it
	if [ $(${TARGET_PREFIX}gcc -dumpversion | awk -F. '{print $2}') -gt 3 ] ; then
		# Fix up linkerscripts, recent toolchains need -T to prepend the default script to the custom one 
		for makefile in $(find ${S} -name "Makefile.am") ; do
			sed -i -e 's:-Wl,$(XDC_CONFIG_BASENAME)/linker.cmd:-Wl,-T,$(XDC_CONFIG_BASENAME)/linker.cmd:g' $makefile
		done
	fi
}

do_compile() {
	# Recent kernel headers warn against inclusion from userspace
	for makefile in $(find ${S} -name "Makefile") ; do
		sed -i -e s:-Werror::g $makefile
	done

    oe_runmake
}

do_install_prepend () {

    install -d ${D}/${installdir}/gst/${PLATFORM}

    # copy gstreamer demo scripts
    cp -R ${WORKDIR}/gstreamer_ti/gstreamer_demo/shared ${D}/${installdir}/gst

    # If we have loadmodules.sh in WORKDIR then give preference to this over
    # the default gst-ti loadmdules.sh
    if [ -f ${WORKDIR}/loadmodules.sh ]; then
       cp ${WORKDIR}/loadmodules.sh ${D}/${installdir}/gst/${PLATFORM}
    else
       cp -R ${WORKDIR}/gstreamer_ti/gstreamer_demo/${PLATFORM} ${D}/${installdir}/gst
    fi   

    # delete .svn files
    find ${D}/${installdir}/gst -name .svn -type d | xargs rm -rf
    chmod 0755 ${D}/${installdir}/gst -R

    install -d ${D}${sysconfdir}/init.d/
    install -m 0755  ${WORKDIR}/gstreamer-ti-rc.sh ${D}${sysconfdir}/init.d/gstti-init

    sed -i -e 's|<platform>|${PLATFORM}|g' ${D}${sysconfdir}/init.d/gstti-init
}

RRECOMMENDS_${PN}_append_dm6446    += "ti-codecs-dm6446-server   ti-cmem-module ti-dsplink-module"
RRECOMMENDS_${PN}_append_dm6467    += "ti-codecs-dm6467          ti-cmem-module ti-dsplink-module"
RRECOMMENDS_${PN}_append_omap3     += "ti-codecs-omap3530-server ti-cmem-module ti-dsplink-module ti-lpm-module ti-sdma-module"
RRECOMMENDS_${PN}_append_dm355     += "ti-codecs-dm355           ti-cmem-module ti-dm355mm-module"
RRECOMMENDS_${PN}_append_dm365     += "ti-codecs-dm365           ti-cmem-module ti-dm365mm-module ti-edma-module ti-irq-module"
RRECOMMENDS_${PN}_append_omapl137  += "ti-codecs-omapl137-server ti-cmem-module ti-dsplink-module"
RRECOMMENDS_${PN}_append_omapl138  += "ti-codecs-omapl138-server ti-cmem-module ti-dsplink-module"

FILES_${PN}     += "${libdir}/gstreamer-0.10/*.so ${sysconfdir} ${installdir}"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.a ${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"

pkg_postinst_${PN} () {
	if [ -d ${installdir}/ti-codecs-server/ ]; then
        ln -sf ${installdir}/ti-codecs-server/* ${installdir}/gst/${PLATFORM}/
	fi
}

INITSCRIPT_NAME = "gstti-init"
INITSCRIPT_PARAMS = "start 30 5 2 . stop 40 0 1 6 ."

