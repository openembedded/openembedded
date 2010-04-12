DESCRIPTION-${PN}-viewer = "A lightweight VNC viewer"
HOMEPAGE = "http://www.tightvnc.com/"
DEPENDS = "virtual/libx11 zlib libxmu libxaw"
LICENSE = "GPL"

PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/vnc-tight/${PN}-${PV}_unixsrc.tar.gz \
           file://Makefile \
           file://Vncviewer"

S = "${WORKDIR}/vnc_unixsrc/vncviewer/"

PACKAGES = "${PN}-viewer-dbg ${PN}-viewer"
FILES_${PN}-viewer-dbg = "${bindir}/.debug"
FILES_${PN}-viewer = "${bindir}/${PN}viewer ${sysconfdir}"

do_compile () {
	install ${WORKDIR}/Makefile ${S}
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install ${PN}viewer ${D}${bindir}
	install -d ${D}${sysconfdir}/X11/app-defaults
	install -m 644 ${WORKDIR}/Vncviewer ${D}${sysconfdir}/X11/app-defaults/Vncviewer
}

pkg_postinst_${PN}-viewer () {
        update-alternatives --install ${bindir}/vncviewer vncviewer tightvncviewer 100
}


pkg_prerm_${PN}-viewer () {
        update-alternatives --remove ${bindir}/vncviewer vncviewer tightvncviewer 100
}

SRC_URI[md5sum] = "80b904d4a10fccee9045d0feeaa65df8"
SRC_URI[sha256sum] = "56062708bb547425f8e8f0f9c571d4fa06fcc89a11146a5b15c608fd8debdb80"
