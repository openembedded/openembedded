DESCRIPTION = "itools is a python web technologies library"
SECTION = "devel/python"
HOMEPAGE = "http://www.ikaaro.org/itools"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "itools"
PR = "ml0"

SRC_URI = "http://download.ikaaro.org/itools/${SRCNAME}-${PV}.tar.gz"
SRC_URI[md5sum] = "3f511309cb9b46bc146b7ecb36e072c6"
SRC_URI[sha256sum] = "0a894a32a918c560a6c4d5ea8c2ef4b416e9e5c9a459737f6f06b1cd9f485e96"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
