require matchbox-wm.inc

DEPENDS = "libmatchbox virtual/libx11 libxext libxcomposite libxfixes libxdamage libxrender startup-notification expat gconf gconf-native "
RDEPENDS = ""

PR ="r5"

SRC_URI = "http://matchbox-project.org/sources/matchbox-window-manager/1.2/matchbox-window-manager-${PV}.tar.bz2 \
           file://configure_fix.patch;patch=1 \
           file://select-client-crash.patch;patch=1 \
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

SRC_URI[md5sum] = "3e158dcf57823b55c926d95b245500fb"
SRC_URI[sha256sum] = "81a23a4af797cf350759fd5ac738797015a66dd5dba2f3d9f3c6908506c1ceff"
