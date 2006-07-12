DESCRIPTION = "Python Bindings to the XML libraries libxml2 and libxslt"
HOMEPAGE = "http://codespeak.net/lxml/"
AUTHOR = "http://codespeak.net/mailman/listinfo/lxml-dev"
LICENSE = "BSD"
DEPENDS = "libxml2 libxslt"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "ml0"

SRC_URI = "http://codespeak.net/lxml/lxml-${PV}.tgz"
S = "${WORKDIR}/lxml-${PV}"

inherit distutils

