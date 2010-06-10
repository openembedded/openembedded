DESCRIPTION = "blackbox configuration for xqtlauncher which integrates X/Qt2 nicely into opie."
HOMEPAGE = "http://angstrom-distribution.org/"
LICENSE = "GPL"
PR = "r1"

RDEPENDS_${PN} = "blackbox xqtlauncher"

SRC_URI = "file://blackboxrc \
           file://defaultwm"
        
do_install() {
	cd ${WORKDIR}
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/X11
	install -m 0666 blackboxrc ${D}${sysconfdir}
	install -m 0666 defaultwm ${D}${sysconfdir}/X11/
}
