require matchbox-wm.inc

DEPENDS = "libmatchbox virtual/libx11 libxext libxcomposite libxfixes libxdamage libxrender startup-notification expat gconf "
RDEPENDS = ""
PR ="r2"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-window-manager/0.9/matchbox-window-manager-${PV}.tar.gz \
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


SRC_URI[md5sum] = "7343855f03e962307a350c1cfd03c740"
SRC_URI[sha256sum] = "4580fe7345b57268da624f38c2797bd7171f84fa93bc5b1c9827f8adb7b74f54"
