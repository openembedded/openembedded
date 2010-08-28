DESCRIPTION = "Command line interface for Network Manager"
HOMEPAGE = "http://vidner.net/martin/software/cnetworkmanager/"
LICENSE = "GPL"
SECTION = "console/network"
RDEPENDS_${PN} = "python-core python-crypt python-dbus python-math python-pygobject python-re python-textutils python-xml"
PR = "r2"
PV = "0.8+git"

SRC_URI = "git://repo.or.cz/r/cnetworkmanager.git;protocol=http;tag=801f95b5fd856cd8ec25dc56839f47c1a12e6041"

S = "${WORKDIR}/git"

do_compile() {
}

do_install(){
	install -d ${D}${bindir}
	install -m 755 cnetworkmanager ${D}${bindir}
	install -d ${D}${sysconfdir}/dbus-1/system.d
	install -m 644 cnetworkmanager.conf ${D}${sysconfdir}/dbus-1/system.d
}
