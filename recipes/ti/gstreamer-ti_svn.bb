require gstreamer-ti.inc

PV = "svnr${SRCREV}"

S = "${WORKDIR}/gstreamer_ti/ti_build/ticodecplugin"

SRCREV = "822"

# apply patches from tracker 1208 to get zero copy support.
# https://gstreamer.ti.com/gf/project/gstreamer_ti/tracker/?action=TrackerItemEdit&tracker_item_id=1208&start=175

SRC_URI = "svn://gforge.ti.com/svn/gstreamer_ti/trunk;module=gstreamer_ti;proto=https;user=anonymous;pswd='' \
file://gstreamer-ti-rc.sh \
file://0003-Support-setting-the-display-framerate-directly-when-.patch;striplevel=4 \
file://0004-Cosmetic-cleanup-clarify-some-comments.patch;striplevel=4 \
file://0005-Enable-setting-the-framerate-directly-on-DM365.patch;striplevel=4 \
file://0006-Remove-the-repeat_with_refresh-feature.patch;striplevel=4 \
file://0007-Add-support-for-pad-allocated-buffers-in-TIDmaiVideo.patch;striplevel=4 \
file://0008-Add-support-for-pad-allocated-buffers-in-TIViddec2.patch;striplevel=4 \
file://0009-update-dm365-cfg-to-work-with-platinum-codecs.patch \
file://0010-replace-omap3530_dv400-platform-support-with-omap353.patch \
"

# use local loadmodules.sh for these platform
# TODO: must be removed onces these loadmodules goes in gstreamer.ti.com
SRC_URI_append_dm365 = " file://loadmodules.sh"
SRC_URI_append_omapl137 = " file://loadmodules.sh"
SRC_URI_append_omapl138 = " file://loadmodules.sh "
SRC_URI_append_omap3 = " file://loadmodules.sh "

# apply omapdmaifbsink patch on omap3 platform
# NOTE: this patch need's X11 header/libs
SRC_URI_append_omap3 = " file://0001-add-omapdmaifbsink.patch"

