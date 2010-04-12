DESCRIPTION = "TeXmaker is a free cross-platform LaTeX editor"
HOMEPAGE = "http://www.xm1math.net/texmaker"
SECTION = "x11/applications"
LICENSE = "GPL"

SRC_URI = "http://www.xm1math.net/texmaker/texmaker-${PV}.tar.bz2"

inherit qt4x11

do_install() {
	install -d ${D}${bindir}
	install -m 0755 texmaker ${D}${bindir}/texmaker
}


SRC_URI[md5sum] = "17f91175a32827e9c9f45dc7a20a0c2b"
SRC_URI[sha256sum] = "6ae8157bbec2b36957bbee6895b4cd3f82406fa90fa7d597235c58ea19307be7"
