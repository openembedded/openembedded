DESCRIPTION = "Starling audio player for GPE"
SECTION = "gpe/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ gstreamer gst-plugins-good gst-plugins-bad esound sqlite libsoup libhandoff"
PV = "0.2+svnr${SRCREV}"
PR = "r1"

inherit gpe autotools

SRC_URI = "${GPE_EXTRA_SVN}"
S = "${WORKDIR}/${PN}"

RDEPENDS = "\
  esd \
  gst-plugin-audioconvert \
  gst-plugin-esd \
  gst-plugin-typefindfunctions \
  gst-plugin-decodebin \
  gst-plugin-volume \
"
RRECOMMENDS = "\
  gst-plugin-mad \
  gst-plugin-modplug \
  gst-plugin-ivorbis \
  gst-plugin-tcp \
"
