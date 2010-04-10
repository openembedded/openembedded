HOMEPAGE = "http://schrodinger.sourceforge.net/"
LICENSE = "MPL GPL LGPL MIT"
DEPENDS = "liboil gstreamer gst-plugins-base"

SRC_URI = "${SOURCEFORGE_MIRROR}/schrodinger/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${libdir}/gstreamer-0.10/libgstschro.so"


SRC_URI[md5sum] = "45f8d0efd9b76579a005e4ffe7f96ac3"
SRC_URI[sha256sum] = "0b01f9fb9c869ecb6e066993d59e34789f82d445438480ac0e2dc30f29d047a0"
