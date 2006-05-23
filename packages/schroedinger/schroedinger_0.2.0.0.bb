HOMEPAGE = "http://schrodinger.sourceforge.net/
LICENSE = "MPL/GPL/LGPL and MIT" 
DEPENDS = "liboil gstreamer gst-plugins-base"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"

SRC_URI = "${SOURCEFORGE_MIRROR}/schrodinger/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${libdir}/gstreamer-0.10/libgstschro.so"

