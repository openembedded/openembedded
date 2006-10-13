DESCRIPTION = "FarSight is an audio/video conferencing framework specifically designed for Instant Messengers."
HOMEPAGE = "http://farsight.sf.net"
SRC_URI = "http://telepathy.freedesktop.org/releases/farsight/${P}.tar.gz"


DEPENDS = "glib-2.0 libxml2 zlib dbus libjingle gstreamer gst-plugins-base"

inherit autotools pkgconfig

EXTRA_OECONF = " \
--disable-debug \
  --disable-gtk-doc \
  --disable-sequence-diagrams \
  --disable-sofia-sip \
  --enable-jingle-p2p \
  --disable-gnet \
  --disable-msnwebcam \
  --disable-msnavconf \
  --disable-yahoowebcam \
  --enable-rtp"

FILES_${PN} += "${libdir}/farsight-0.1/*so"
FILES_${PN}-dev += "${libdir}/farsight-0.1/*.a ${libdir}/farsight-0.1/*.so.*"

do_stage() {
autotools_stage_all
}



