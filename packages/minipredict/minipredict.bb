inherit gpe pkgconfig

DESCRIPTION = "Minipredict is a app that sits above the dock, e.g. mbdock, and suggests words for completion."
DEPENDS = "libx11 libxext gtk+ libdictionary zlib"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI = "http://handhelds.org/~paxanima/files/${PN}.tar.gz \
	   file://fix-makefile.patch;patch=1 \
	   file://fix-include.patch;patch=1 \
	   file://minipredict.desktop \
	   file://minipredict.png"

S = ${WORKDIR}/${PN}

FILES_${PN} = "${bindir} ${datadir}/pixmaps ${datadir}/applications"

do_install() {
	install -d ${D}/${bindir}
	install -d ${D}/${datadir}/pixmaps
	install -d ${D}/${datadir}/applications
	install ${S}/minipredict ${D}/${bindir}/
	install ${WORKDIR}/minipredict.png ${D}/${datadir}/pixmaps/
	install ${WORKDIR}/minipredict.desktop ${D}/${datadir}/applications/
}
