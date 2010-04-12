DESCRIPTION = "Python libxklavier Bindings"
HOMEPAGE = "http://lists.sugarlabs.org/archive/sugar-devel/2009-August/018480.html"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libxklavier"
PR = "r0"

SRC_URI = "http://download.sugarlabs.org/sources/external/python-xklavier/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig distutils-base

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"

SRC_URI[md5sum] = "5b3cd1832f4d37dfa48490759f3bd3be"
SRC_URI[sha256sum] = "b71096448ca9d7933fbc4aff13cef95a5878f49e4c25f20f815dd1f8f635b6d6"
