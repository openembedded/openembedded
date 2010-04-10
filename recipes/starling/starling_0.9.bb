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

SRC_URI[md5sum] = "1c9cab1e49819dbe4e876c3be26cca6b"
SRC_URI[sha256sum] = "63ed3e239c79a5913e9542b7023586c51a592e33d2ec0256dafa34cbae20c497"
