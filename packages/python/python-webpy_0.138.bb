DESCRIPTION = "A Lightweight Web Application Framework"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "PSF"
RDEPENDS = "python-netserver python-netclient python-pprint"

PR = "ml1"

SRC_URI = "file://web.py"
S = "${WORKDIR}"

inherit distutils-base

do_install() {
	install -d ${D}${libdir}/${PYTHON_DIR}
	install -m 0755 web.py ${D}${libdir}/${PYTHON_DIR}
}

