DESCRIPTION = "Neuros qt-plugins"
LICENSE = "GPL"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "9988829eab1428f03f5f5dba8866b2f4da267d67"
SRC_URI = "git://git.neurostechnology.com/git/lib-widgets;protocol=git"
S = "${WORKDIR}/git/"

do_install() {
	install -d ${D}/${libdir}/
	install -m 0755 ${S}/build/lib* ${D}/${libdir}
}


