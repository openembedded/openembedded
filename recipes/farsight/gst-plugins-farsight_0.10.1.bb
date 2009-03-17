DESCRIPTION = "FarSight is an audio/video conferencing framework specifically designed for Instant Messengers."
HOMEPAGE = "http://farsight.sf.net"
SRC_URI = "http://telepathy.freedesktop.org/releases/gst-plugins-farsight/${P}.tar.gz"


DEPENDS = "glib-2.0 libxml2 zlib dbus libjingle gstreamer gst-plugins-base"

inherit autotools pkgconfig

EXTRA_OECONF = " \
--disable-debug \
   --disable-jrtplib \
   --disable-mimic \
   --disable-gsm \
   --disable-jasper \
   --enable-jingle-p2p \
   --with-plugins=rtpdemux,rtpjitterbuffer"


FILES_${PN} += "${libdir}/gstreamer-0.10/*so"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.a ${libdir}/gstreamer-0.10/*.so.*"

do_stage() {
autotools_stage_all
}



