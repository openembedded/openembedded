DESCRIPTION = "Simplified Python Distributed Indexing is a powerful engine \
to create distributed full text indexing systems and distributed search engines. \
It supports harvesting, crawling (pull methods), and push methods (via a Web \
interface or SPyRO Web services)."
HOMEPAGE = "http://www.spyron.org/spydi.html"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
PR = "ml1"

SRC_URI = "http://lsc.fie.umich.mx/%7esadit/spyro/download/SPyDI-${PV}.tar.gz"
S = "${WORKDIR}/SPyDI-${PV}"

inherit distutils

SRC_URI[md5sum] = "9ca1c604330643fca1e3847f77ac8f0a"
SRC_URI[sha256sum] = "67e939a8c3e0f33fd2de5945b9e1e50b522890df025560215d6ca56ea7204b15"
