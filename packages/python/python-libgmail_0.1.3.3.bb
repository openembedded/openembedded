DESCRIPTION = "Python Bindings for Google's Gmail Service"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
RDEPENDS = "python-core python-netclient python-email python-mime python-pprint python-re python-pickle"
SRCNAME = "libgmail"

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
