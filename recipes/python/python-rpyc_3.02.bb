DESCRIPTION = "RPyC is a Remote Procedure Call Package for Python"
SECTION = "devel/python"
HOMEPAGE = "http://rpyc.wikizone.com"
LICENSE = "GPL"
SRCNAME = "rpyc"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/rpyc/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "4e855372c4a533b9ed605503156e6e04"
SRC_URI[sha256sum] = "3dbd653b27fc855bf86dfe0ac06ed9bf59c8b85c9bcb4b5488528b30c59970f4"
