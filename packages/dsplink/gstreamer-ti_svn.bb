DEPENDS = "codec-engine dmai gstreamer gst-plugins-base gst-plugins-good gst-plugins-ugly libid3tag liboil libmad"

SRC_URI = "svn://omapzoom.org/svn/gstreamer_ti/trunk;module=gstreamer_ti;proto=https"
SRCREV = "43"

# Again, no '.' in PWD allowed :(
PV = "0+svnr${SRCREV}"

S = "${WORKDIR}/gstreamer_ti/ti_build/ticodecplugin"

inherit autotools

require ti-paths.inc

CPPFLAGS_append = " -DPlatform_${PLATFORM}"

PACKAGE_ARCH = "${MACHINE_ARCH}"


