inherit gpe pkgconfig

DESCRIPTION = "Minipredict is a app that sits above the dock, e.g. mbdock, and suggests words for completion."
DEPENDS = "virtual/libx11 libxext gtk+ libdictionary zlib"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI = "http://handhelds.org/~paxanima/files/${PN}.tar.gz \
	   file://fix-makefile.patch;patch=1 \
	   file://fix-include.patch;patch=1 \
	   file://minipredict.desktop \
	   file://minipredict.png"

S = "${WORKDIR}/${PN}"

FILES_${PN} = "${bindir}/* ${datadir}/pixmaps ${datadir}/applications"

do_install() {
	install -d ${D}/${bindir}
	install -d ${D}/${datadir}/pixmaps
	install -d ${D}/${datadir}/applications
	install ${S}/minipredict ${D}/${bindir}/
	install ${WORKDIR}/minipredict.png ${D}/${datadir}/pixmaps/
	install ${WORKDIR}/minipredict.desktop ${D}/${datadir}/applications/
}

SRC_URI[md5sum] = "d6793818b10c9af0f1c424a2e81009e1"
SRC_URI[sha256sum] = "73edd3f8e7c36c81c895ea723e7faefd3ee5a3671d0b1e0ea7b3a960b169231e"
