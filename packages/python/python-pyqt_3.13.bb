DESCRIPTION = "Python Qt/Embedded + Qt/Palmtop Bindings"
HOMEPAGE = "http://www.vanille.de/projects/python.spy"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
RDEPENDS = "python-core python-sip"
DEPENDS = "virtual/libqte2 virtual/libqpe"
SRCNAME = "pyqt"
PR = "ml3"

SRC_URI = "http://www.vanille.de/mirror/PyQt-x11-gpl-${PV}.tar.gz \
           file://qt2-fix.patch;patch=1 \
           file://features"
S = "${WORKDIR}/PyQt-x11-gpl-${PV}"

inherit qmake sip distutils-base

QMAKE_PROFILES = "pyqt.pro"
EXTRA_SIPTAGS = "-tWS_QWS -tQtPE_1_6_0 -tQt_2_3_1"
SIP_MODULES = "qt qtcanvas qttable qtpe"
SIP_FEATURES = "${WORKDIR}/features"
EXTRA_OEMAKE = " MAKEFLAGS= "

EXTRA_QMAKEVARS_POST = " QMAKE_UIC=${STAGING_BINDIR}/uic QMAKE_MOC=${STAGING_BINDIR}/moc QMAKE_RPATH=-Wl,-rpath-link, \
                         CONFIG=qt CONFIG+=warn_on CONFIG+=release \
                         DESTDIR= VERSION=1.0.0 \
                         DEFINES=SIP_MAKE_DLL DEFINES+=SIP_QT_SUPPORT DEFINES+=QWS \
                         INCLUDEPATH=. \
                         INCLUDEPATH+=${STAGING_INCDIR}/${PYTHON_DIR} \
                         INCLUDEPATH+=${STAGING_INCDIR} \
                         LIBS+=-L${STAGING_LIBDIR}/${PYTHON_DIR}/site-packages \
                         LIBS+=-L${QTDIR}/lib LIBS+=-lqte LIBS+=-lqpe "

do_configure_prepend() {
    echo -e "TEMPLATE=subdirs\nSUBDIRS=qt qtcanvas qttable qtpe\n" >pyqt.pro
}

do_stage() {
    install -d ${STAGING_SIPDIR}/qt/
    for module in ${SIP_MODULES}
    do
        install -m 0644 ${S}/sip/${module}/*.sip ${STAGING_SIPDIR}/qt/
	install -m 0755 ${module}/lib${module}.so ${STAGING_LIBDIR}/${PYTHON_DIR}/site-packages/${module}.so
    done
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/
    for module in ${SIP_MODULES}
    do
	install -m 0755 ${module}/lib${module}.so ${D}${libdir}/${PYTHON_DIR}/site-packages/${module}.so
    done
}

FILES_${PN} = "${libdir}/${PYTHON_DIR}/site-packages"
