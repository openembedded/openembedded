DESCRIPTION = "KDE Web Browser Konqueror, QtE based Palmtop Environments Edition"
SECTION = "opie/applications"
PRIORITY = "optional"
DEPENDS = "libqpe-opie openssl pcre"
LICENSE = "LGPL/GPL"
PR = "r3"

SRC_URI = "http://devel-home.kde.org/~hausmann/snapshots/konqueror-embedded-snapshot-${PV}.tar.gz \
           file://opie1.patch;patch=1 \
           file://packing.patch;patch=1 \
	   file://include_qconfig.patch;patch=1 \
	   file://useragent.patch;patch=1 \
	   file://kcookiejar-merge.patch;patch=1 \
	   file://malformed.patch;patch=1 \
	   file://cachepath.patch;patch=1 \
	   file://konq-embedrc \
	   file://vit.patch;patch=1"
S = "${WORKDIR}/konqueror-embedded-snapshot-${PV}"

inherit autotools

FILES_${PN} = "${palmtopdir}"

export QMAKE = "${STAGING_BINDIR}/qmake"
export MOC = "${STAGING_BINDIR}/moc"
export UIC = "${STAGING_BINDIR}/uic"
export exec_prefix = "${STAGING_LIBDIR}/.."

EXTRA_OECONF = '--prefix=${palmtopdir} --exec-prefix=${palmtopdir}                              \
                --enable-static --disable-shared --disable-debug                                \
                --with-javascript=static --enable-qpe --enable-qt-embedded                      \
                --with-extra-includes=${STAGING_INCDIR} --with-extra-libs=${STAGING_LIBDIR}     \
                --with-ssl-version=0.9.7c --with-ssl-dir=${STAGING_LIBDIR}/..                   \
                --with-qt-dir=${QTDIR} --with-qtopia-dir=${OPIEDIR}                             \
		--enable-libsuffix=""							        '

CXXFLAGS += "-DOPIE_NO_ERASE_RECT_HACKFIX -DOPIE_NEW_MALLOC"

do_compile_prepend() {
	perl admin/am_edit
}

do_install() {
    install -d ${D}${palmtopdir}/share/
    install -d ${D}${palmtopdir}/share/config/
    
    install -m 0644 ${WORKDIR}/konq-embedrc ${D}${palmtopdir}/share/config/
    
    autotools_do_install
}