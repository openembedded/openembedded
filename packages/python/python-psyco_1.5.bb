DESCRIPTION = "Psyco lets you run your existing Python software much faster, with no change in your source."
HOMEPAGE = "http://psyco.sourceforge.net"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "dkm@kataplop.net"
LICENSE = "PSF"
RDEPENDS = "python-core"
SRCNAME = "psyco"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}-src.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

COMPATIBLE_HOST = 'i.86.*-linux'

inherit distutils
