require gstreamer-ti.inc

PV = "svnr${SRCREV}"

S = "${WORKDIR}/gstreamer_ti/ti_build/ticodecplugin"

SRCREV = "811"

SRC_URI = "svn://gforge.ti.com/svn/gstreamer_ti/trunk;module=gstreamer_ti;proto=https;user=anonymous;pswd='' \
  file://gstreamer-ti-rc.sh \
"

# use local loadmodules.sh for these platform
# TODO: must be removed onces these loadmodules goes in gstreamer.ti.com
SRC_URI_append_dm365 = " file://loadmodules.sh"
SRC_URI_append_omapl137 = " file://loadmodules.sh"
SRC_URI_append_omapl138 = " file://loadmodules.sh "
SRC_URI_append_omap3 = " file://loadmodules.sh "

# apply omapdmaifbsink patch on omap3 platform
# NOTE: this patch need's X11 header/libs
#SRC_URI_append_omap3 = " file://0001-add-omapdmaifbsink.patch"

