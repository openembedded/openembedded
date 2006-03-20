DESCRIPTION = "KDE Web Browser Konqueror, QtE based Palmtop Environments Edition"
BROKEN = "1"
SECTION = "applications"
PRIORITY = "optional"
HOMEPAGE = "http://www.cirulla.net/kdenox-snapshots/"
DEPENDS = "openssl pcre"
LICENSE = "LGPL/GPL"
PR = "r3"

# Note if this .bb files fails with the error:
# "No rule to make target `-lpcre', needed by `konqueror'.  Stop."
# a workaround is to install the libpcre3-dev package onto your build
# machine (Ubuntu/Debain) or your distro's equivalent (FC = pcre-devel).

SRC_URI = "http://www.cirulla.net/kdenox-snapshots/snapshots/konqueror3-embedded-0.2-${PV}.tar.bz2 \
           file://qt-embedded.patch;patch=1"
S = "${WORKDIR}/konqueror3-embedded-0.2-${PV}"

DEFAULT_PREFERENCE = "-1"

inherit autotools

FILES_${PN} = "${palmtopdir}"

export QMAKE = "${STAGING_BINDIR}/qmake"
export MOC = "${STAGING_BINDIR}/moc"
export UIC = "${STAGING_BINDIR}/uic"
export exec_prefix = "${STAGING_LIBDIR}/.."

EXTRA_OECONF  = '--prefix=${palmtopdir} --exec-prefix=${palmtopdir}'
EXTRA_OECONF += '--with-extra-includes=${STAGING_INCDIR} --with-extra-libs=${STAGING_LIBDIR}'
EXTRA_OECONF += '--enable-static --disable-shared --disable-debug'
EXTRA_OECONF += '--enable-qt-embedded --enable-embedded --without-arts'
EXTRA_OECONF += '--with-javascript=static --with-gui=kiosk'
EXTRA_OECONF += '--disable-selection --disable-scrollbars --disable-bookmarks'
EXTRA_OECONF += '--with-ssl-version=0.9.7e --with-ssl-dir=${STAGING_LIBDIR}/..'
EXTRA_OECONF += '--with-qt-includes=${STAGING_INCDIR}/qt3'
EXTRA_OECONF += '--with-qt-libraries=${STAGING_LIBDIR}'

MOC = "${STAGING_BINDIR}/moc3"
UIC = "${STAGING_BINDIR}/uic3"

do_compile_prepend() {
	perl admin/am_edit
}

do_install() {
    install -d ${D}${palmtopdir}/share/
    install -d ${D}${palmtopdir}/share/config/
    
    install -m 0644 ${WORKDIR}/konq-embedrc ${D}${palmtopdir}/share/config/
    
    autotools_do_install
}
