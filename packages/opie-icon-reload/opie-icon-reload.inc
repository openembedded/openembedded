DESCRIPTION = "Reload .desktop files on the fly"
SECTION = "opie/settings"
PRIORITY = "optional"
LICENSE = "GPL"

PACKAGE_ARCH = "all"

SRC_URI = "file://icon-reload.desktop \
	   file://icon-reload.sh \
	   file://reload.png"

FILES_${PN} += "${palmtopdir}"

do_install() {		
	install -d ${D}${palmtopdir}/apps/Settings
	install -d ${D}${bindir}
	install -d ${D}${palmtopdir}/pics
	
	install -m 0644 ${WORKDIR}/icon-reload.desktop ${D}${palmtopdir}/apps/Settings
	install -m 0755 ${WORKDIR}/icon-reload.sh ${D}${bindir}
	sed -i -e 's,@bindir@,${bindir},g' ${D}${bindir}/icon-reload.sh
	install -m 0644 ${WORKDIR}/reload.png ${D}${palmtopdir}/pics	
}

