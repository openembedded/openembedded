DEPENDS = "codec-engine dmai gstreamer gst-plugins-base gst-plugins-good gst-plugins-ugly libid3tag liboil libmad"

SRC_URI = "svn://omapzoom.org/svn/gstreamer_ti/trunk;module=gstreamer_ti;proto=https"
SRCREV = "87"

# Again, no '.' in PWD allowed :(
PV = "0+svnr${SRCREV}"

S = "${WORKDIR}/gstreamer_ti/ti_build/ticodecplugin"

inherit autotools

require ti-paths.inc

export DMAI_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/dmai"
export CE_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/codecengine/cetools"
export CODEC_INSTALL_DIR = ""

export XDC_TARGET = "gnu.targets.arm.GCArmv5T"

XDC_PLATFORM = "foo"
# Assume every TI armv7a cpu is a 3530
XDC_PLATFORM_armv7a = "ti.platforms.evm3530"
export XDC_PLATFORM

# We need to add this to config.bld:
#GCArmv5T.cc.$unseal("opts");
#GCArmv5T.cc.opts = "SEDME_CCARCH";
#GCArmv5T.cc.$seal("opts");

do_compile_prepend() {
	for i in $(find ${S} -name "config.bld") ; do
		    sed -i -e s:SEDME_CCARCH:'${TARGET_CCARCH}': $i
	done
}

CPPFLAGS_append = " -DPlatform_${PLATFORM}"

PACKAGE_ARCH = "${MACHINE_ARCH}"


