DESCRIPTION = "libcurl Python Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "curl-${PV}"
SRCNAME = "pycurl"
PR = "ml2"

SRC_URI = "\
  http://${SRCNAME}.sourceforge.net/download/${SRCNAME}-${PV}.tar.gz \
  file://no-static-link.patch;patch=1 \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

RDEPENDS = "python-core curl (>=${PV})"

SRC_URI[md5sum] = "39210d56f1d5a75ac8dd6a2866a93dd5"
SRC_URI[sha256sum] = "95d21bd61e03d22ee4ac18fc0b9040c163cb504c4b2cf1dc43c18f32508f6736"
