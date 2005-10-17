DESCRIPTION = "A full fledged pluggable content management system with integrated web server and much more"
SECTION = "console/network"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "python"
RDEPENDS = "python-core python-shell"
LICENSE = "ZPL"
PR = "ml1"

SRC_URI = "http://zope.org/Products/Zope/${PV}/Zope-${PV}.tgz"
S = "${WORKDIR}/Zope-${PV}-0"

do_configure() {
	./configure --with-python=${STAGING_BINDIR}/python --prefix=${prefix} --optimize --ignore-zlib
}

do_compile() {
	oe_runmake HOST_SYS=${HOST_SYS} BUILD_SYS=${BUILD_SYS}
}

do_install() {
	oe_runmake install PREFIX=${D}${prefix} HOST_SYS=${HOST_SYS} BUILD_SYS=${BUILD_SYS}
}

FILES_${PN} = "${prefix}"
FILES_${PN}_doc = "${prefix}/doc"
