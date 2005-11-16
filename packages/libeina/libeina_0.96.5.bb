DESCRIPTION = "Multimedia library using gstreamer""
HOMEPAGE = "http://bolgo.cent.uji.es/proyectos/eina"
LICENSE = "GPL"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

DEPENDS = "file glib-2.0 gstreamer"

SRC_URI = "http://bolgo.cent.uji.es/files/libeina/${P}.tar.gz"

inherit autotools pkgconfig

do_stage() {
autotools_stage_all
}

