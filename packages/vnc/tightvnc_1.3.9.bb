DESCRIPTION-${PN}-viewer = "A lightweight VNC viewer"
HOMEPAGE = "http://www.tightvnc.com/"
DEPENDS = "virtual/libx11 zlib libxmu libxaw"
LICENSE = "GPL"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/vnc-tight/${PN}-${PV}_unixsrc.tar.gz \
           file://Makefile"

S = "${WORKDIR}/vnc_unixsrc/vncviewer/"

PACKAGES = "${PN}-viewer-dbg ${PN}-viewer"
FILES_${PN}-viewer-dbg = "${bindir}/.debug"
FILES_${PN}-viewer = "${bindir}/${PN}viewer"

do_compile () {
	install ${WORKDIR}/Makefile ${S}
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install ${PN}viewer ${D}${bindir}
}
