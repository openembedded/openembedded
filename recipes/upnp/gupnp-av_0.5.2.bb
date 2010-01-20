LICENSE = "LGPL"
DEPENDS = "gupnp"

SRC_URI = "http://gupnp.org/sources/${PN}/${PN}-${PV}.tar.gz \
           file://nodoc.patch;patch=1"

inherit autotools_stage pkgconfig
