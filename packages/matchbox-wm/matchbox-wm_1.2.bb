require matchbox-wm.inc

DEPENDS = "libmatchbox virtual/libx11 libxext libxcomposite libxfixes libxdamage libxrender startup-notification expat gconf gconf-native "
RDEPENDS = ""

PR="r3"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-window-manager/1.2/matchbox-window-manager-${PV}.tar.bz2 \
           file://gconf-2.m4 \
           file://kbdconfig"

S = "${WORKDIR}/matchbox-window-manager-${PV}"

inherit autotools pkgconfig update-alternatives

FILES_${PN} = "${bindir}/* \
	       ${datadir}/matchbox \
	       ${sysconfdir}/matchbox \
	       ${sysconfdir}/gconf/ \
	       ${datadir}/themes/blondie/matchbox \
	       ${datadir}/themes/Default/matchbox \
	       ${datadir}/themes/MBOpus/matchbox"

ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PATH = "${bindir}/matchbox-window-manager"
ALTERNATIVE_PRIORITY = "10"

EXTRA_OECONF = " \
                --enable-startup-notification\
		--enable-gconf \
		--enable-expat \
		--disable-xrm"

do_configure_prepend () {
    cp ${WORKDIR}/gconf-2.m4 ${S}/
}

do_install_prepend() {
    install ${WORKDIR}/kbdconfig ${S}/data/kbdconfig
}

