DESCRIPTION = "Multimedia library using gstreamer"
HOMEPAGE = "http://bolgo.cent.uji.es/proyectos/eina"
LICENSE = "GPL"
PR = "r2"

DEPENDS = "glib-2.0 gstreamer"

SRC_URI = "http://bolgo.cent.uji.es/files/libeina/${P}.tar.gz \
		  file://nomagic.diff;patch=1"

EXTRA_OECONF = "--disable-magic"

inherit autotools pkgconfig

do_stage() {
autotools_stage_all
}


SRC_URI[md5sum] = "72fade0fea5b67e92c2e1ff9e2c07f52"
SRC_URI[sha256sum] = "d4fda4fc89cc5492f3cdf0445e84ab93311f9e1b22e487f3d95f3f86c90fe4f5"
