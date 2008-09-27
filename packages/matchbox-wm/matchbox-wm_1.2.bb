require matchbox-wm.inc

DEPENDS = "libmatchbox virtual/libx11 libxext libxcomposite libxfixes libxdamage libxrender startup-notification expat gconf gconf-native "
RDEPENDS = ""

PR ="r4"

SRC_URI = "http://matchbox-project.org/sources/matchbox-window-manager/1.2/matchbox-window-manager-${PV}.tar.bz2 \
           file://configure_fix.patch;patch=1 \
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
	       ${datadir}/themes/MBOpus/matchbox \
               /var/lib/*"

ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PATH = "${bindir}/matchbox-window-manager"
ALTERNATIVE_PRIORITY = "10"

EXTRA_OECONF = " \
                --enable-startup-notification\
		--enable-gconf \
		 --with-expat-lib=${STAGING_LIBDIR} \
		 --with-expat-includes=${STAGING_INCDIR} \
		--disable-xrm"

do_configure_prepend () {
    cp ${WORKDIR}/gconf-2.m4 ${S}/
}

do_install_prepend() {
    install -d ${D}/var/lib/dbus
    install ${WORKDIR}/kbdconfig ${S}/data/kbdconfig
}
