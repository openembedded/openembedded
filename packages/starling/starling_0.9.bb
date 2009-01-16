DESCRIPTION = "Starling audio player for GPE"
SECTION = "gpe/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ gstreamer gst-plugins-good gst-plugins-bad esound sqlite libsoup libhandoff"
PR = "r0"

inherit gpe autotools

SRC_URI = "http://gpe.linuxtogo.org/download/source/starling-${PV}.tar.bz2"

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
