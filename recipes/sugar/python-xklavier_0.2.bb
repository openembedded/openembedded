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
