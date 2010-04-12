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




SRC_URI[md5sum] = "578ef83efd03124e7085abe719513bac"
SRC_URI[sha256sum] = "623e187f87037a690b5d0beef5991b3f2a58bb5058fad8c75329f48f0b07da4b"
