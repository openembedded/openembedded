DESCRIPTION = "Simplified Python Distributed Indexing is a powerful engine \
to create distributed full text indexing systems and distributed search engines. \
It supports harvesting, crawling (pull methods), and push methods (via a Web \
interface or SPyRO Web services)."
HOMEPAGE = "http://www.spyron.org/spydi.html"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
PR = "ml0"

SRC_URI = "http://lsc.fie.umich.mx/%7esadit/spyro/SPyDI-${PV}.tar.gz"
S = "${WORKDIR}/SPyDI-${PV}"

inherit distutils
