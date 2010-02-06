DESCRIPTION = "libcurl Python Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "curl"
SRCNAME = "pycurl"
PR = "ml2"

SRC_URI = "\
  http://${SRCNAME}.sourceforge.net/download/${SRCNAME}-${PV}.tar.gz;name=archive \
  file://no-static-link.patch;patch=1 \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"
SRC_URI[archive.md5sum] = "919d58fe37e69fe87ce4534d8b6a1c7b"
SRC_URI[archive.sha256sum] = "eb782dfcc5a7c023539a077462b83c167e178128ee9f7201665b9fbb1a8b0642"

inherit distutils

RDEPENDS = "python-core curl"
