SECTION = "opie/settings"
DESCRIPTION = "Reload .desktop files on the fly"
PRIORITY = "optional"
MAINTAINER = "Matthias 'CoreDump' Hentges <coredump@handhelds.org>"
LICENSE = "GPL"

SRC_URI = "file://icon-reload.desktop \
	   file://icon-reload.sh \
	   file://reload.png"

FILES_${PN} += "/opt"

do_install() {		
	install -d ${D}${palmtopdir}/apps/Settings
	install -d ${D}${palmtopdir}/bin
	install -d ${D}${palmtopdir}/pics
	
	install -m 0644 ${WORKDIR}/icon-reload.desktop ${D}${palmtopdir}/apps/Settings
	install -m 0755 ${WORKDIR}/icon-reload.sh ${D}${palmtopdir}/bin
	install -m 0644 ${WORKDIR}/reload.png ${D}${palmtopdir}/pics	
}

