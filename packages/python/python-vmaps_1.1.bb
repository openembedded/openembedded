DESCRIPTION = "Python Arrays on mmap()"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
SRCNAME = "vmaps"

SRC_URI = "http://snafu.freedom.org/Vmaps/Vmaps-${PV}.tgz"
S = "${WORKDIR}/Vmaps-${PV}"

inherit distutils
