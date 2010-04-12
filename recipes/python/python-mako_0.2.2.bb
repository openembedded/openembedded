DESCRIPTION = "A super-fast templating language that borrows the best ideas from the existing templating languages"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
HOMEPAGE = "http://www.makotemplates.org/"
SRCNAME = "Mako"
PR = "ml1"

SRC_URI = "http://pypi.python.org/packages/source/M/Mako/Mako-${PV}.tar.gz" 
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

SRC_URI[md5sum] = "ffeb24b3ee71b2e6354efad1136898bd"
SRC_URI[sha256sum] = "858b2ad7850db5e477ab81d7f355f82df33d90e4ed23a235184f380a925f2813"
