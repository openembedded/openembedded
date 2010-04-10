DESCRIPTION = "Python Bindings for Google's Gmail Service"
SECTION = "devel/python"
HOMEPAGE = "http://libgmail.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "libgmail"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils-base

do_install() {
	install -d ${D}${libdir}/${PYTHON_DIR}
	for file in *.py
	do
		install -m 0755 ${file} ${D}${libdir}/${PYTHON_DIR}
	done
}

RDEPENDS = "\
  python-core \
  python-netclient \
  python-email \
  python-mime \
  python-pprint \
  python-re \
  python-pickle \
"


SRC_URI[md5sum] = "247477ac98b39658fdcdee8d65639e51"
SRC_URI[sha256sum] = "2d94f1230f591dfa6d1b726338063f28b89b2f82ba5b866ab077c86c598de43e"
