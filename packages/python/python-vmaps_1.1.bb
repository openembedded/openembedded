DESCRIPTION = "Python Arrays on mmap()"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "vmaps"

SRC_URI = "http://snafu.freedom.org/Vmaps/Vmaps-${PV}.tgz"
S = "${WORKDIR}/Vmaps-${PV}"

inherit distutils
