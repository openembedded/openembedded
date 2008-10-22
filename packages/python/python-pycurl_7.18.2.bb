DESCRIPTION = "libcurl Python Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "curl-${PV}"
SRCNAME = "pycurl"
PR = "ml0"

SRC_URI = "\
  http://${SRCNAME}.sourceforge.net/download/${SRCNAME}-${PV}.tar.gz \
  file://no-static-link.patch;patch=1 \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_install_append() {
	mv -f ${D}${datadir}/share/* ${D}${datadir}/
}

RDEPENDS = "python-core curl (>=${PV})"
