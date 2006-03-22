DESCRIPTION = "FarSight is an audio/video conferencing framework specifically designed for Instant Messengers."
HOMEPAGE = "http://farsight.sf.net"
SRC_URI = "http://ewi546.ewi.utwente.nl/OE/source/${PN}_${PV}.tar.bz2"

MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"

DEPENDS = "glib-2.0 libxml2 zlib dbus libjingle gstreamer gst-plugins-base"

inherit autotools pkgconfig

S=  "${WORKDIR}/${PN}"
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



