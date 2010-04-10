DESCRIPTION = "FarSight is an audio/video conferencing framework specifically designed for Instant Messengers."
HOMEPAGE = "http://farsight.sf.net"
SRC_URI = "http://farsight.freedesktop.org/releases/farsight2/${P}.tar.gz"

DEPENDS = "libnice glib-2.0 libxml2 zlib dbus gstreamer gst-plugins-base"

inherit autotools_stage
AUTOTOOLS_STAGE_PKGCONFIG = "1"

EXTRA_OECONF = " \
  --disable-debug \
  --disable-gtk-doc \
  --disable-python \
"

FILES_${PN} += "${libdir}/*/*.so"
FILES_${PN}-dev += "${libdir}/*/*a"
FILES_${PN}-dbg += "${libdir}/*/.debug"





SRC_URI[md5sum] = "f2d4fad95009bc7eae29f97c6f560dcd"
SRC_URI[sha256sum] = "84553ff12c5245705806107448e85c96950b4b7a5eaf85461c89987be8ea644d"
