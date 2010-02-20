require cornucopia.inc
# Seems like bitbake cannot find dynamicaly created package names in
# gst-plugins.inc. Image creation usually fail with missing RDEPENDS for
# gst-plugin-mad gst-plugin-flac gst-plugin-wavparse gst-plugin-sid
# so add recipes needed for runtime dependencies manually here

DEPENDS += "gstreamer gst-plugins-base gst-plugins-good gst-plugins-bad ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'gst-plugins-ugly', d)}"
PV = "0.0.1+gitr${SRCREV}"
PR = "${INC_PR}.3"

RDEPENDS += "\
#gst-plugins-base
  gst-plugin-volume \
  gst-plugin-alsa \
"
RRECOMMENDS += "\
#gst-plugins-base
  gst-plugin-ogg \
  gst-plugin-audioconvert \
#gst-plugins-good
  gst-plugin-flac \
  gst-plugin-wavparse \
  gst-plugin-souphttpsrc \
#gst-plugins-bad
  gst-plugin-ivorbis \
  gst-plugin-mms \
  gst-plugin-modplug \
#gst-plugins-ugly
  ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'gst-plugin-mad', d)} \
  ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'gst-plugin-sid', d)} \
  "
