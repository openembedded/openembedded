DESCRIPTION = "Psyco lets you run your existing Python software much faster, with no change in your source."
HOMEPAGE = "http://psyco.sourceforge.net"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
RDEPENDS = "python-core"
SRCNAME = "psyco"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}-src.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

COMPATIBLE_HOST = 'i.86.*-linux'

inherit distutils

SRC_URI[md5sum] = "8816fca8ba521e05d18dde3e1a11b0bd"
SRC_URI[sha256sum] = "529de83d76bc71e3334dc5e0b9f5eb8bb5cd095f8ac6dd3154771d50a7373718"
