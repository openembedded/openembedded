DESCRIPTION = "Simplified Python Remote Objects is a multilingual object request broker. \
SPyRO uses the most efficient (or available) connection between peers to minimize costs \
of transport and parsing in the communication."
HOMEPAGE = "http://www.spyron.org/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
PR = "ml0"

SRC_URI = "http://lsc.fie.umich.mx/%7esadit/spyro/download/SPyRO-${PV}.tar.gz"
S="${WORKDIR}/SPyRO-${PV}"

inherit distutils
