DESCRIPTION = "Python Bindings to the XML libraries libxml2 and libxslt"
HOMEPAGE = "http://codespeak.net/lxml/"
AUTHOR = "http://codespeak.net/mailman/listinfo/lxml-dev"
LICENSE = "BSD"
DEPENDS = "libxml2 libxslt"
PR = "ml1"

SRC_URI = "http://codespeak.net/lxml/lxml-${PV}.tgz \
           file://use-pkgconfig-to-detect.patch;patch=1"
S = "${WORKDIR}/lxml-${PV}"

inherit distutils

