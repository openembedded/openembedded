require matchbox-wm.inc

DEPENDS = "libmatchbox virtual/libx11 libxext libxcomposite libxfixes libxdamage libxrender startup-notification expat gconf "
RDEPENDS = ""

PR ="r3"


SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-window-manager/1.0/matchbox-window-manager-${PV}.tar.gz \
	   file://kbdconfig"

S = "${WORKDIR}/matchbox-window-manager-${PV}"

inherit autotools pkgconfig update-alternatives

FILES_${PN} = "${bindir}/* \
	       ${datadir}/matchbox \
	       ${sysconfdir}/matchbox \
	       ${datadir}/themes/blondie/matchbox \
	       ${datadir}/themes/Default/matchbox \
	       ${datadir}/themes/MBOpus/matchbox"

ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PATH = "${bindir}/matchbox-session"
ALTERNATIVE_PRIORITY = "10"

EXTRA_OECONF = " --enable-startup-notification --disable-xrm"

do_install_prepend() {
	install ${WORKDIR}/kbdconfig ${S}/data/kbdconfig
}


SRC_URI[md5sum] = "2a28fdcfd6c71a5edb1618b9449b7486"
SRC_URI[sha256sum] = "f54035309b2a4d45a90979c2b56ab2488546826862062bfc22cd7e7ed8b5ebf6"
