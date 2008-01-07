DESCRIPTION = "Python Qt/Embedded + Qt/Palmtop Bindings"
HOMEPAGE = "http://www.vanille.de/projects/python.spy"
AUTHOR = "Phil Thomson @ riverbank.co.uk"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/libqte2 virtual/libqpe1"
RDEPENDS = "python-core python24-sip"
SRCNAME = "pyqt"
PR = "ml5"

SRC_URI = "http://www.vanille.de/mirror/PyQt-x11-gpl-${PV}.tar.gz \
           file://qt2-fix.patch;patch=1 \
           file://features"
S = "${WORKDIR}/PyQt-x11-gpl-${PV}"

inherit palmtop sip3 distutils-base

QMAKE_PROFILES = "pyqt.pro"
EXTRA_SIPTAGS = "-tWS_QWS -tQtPE_1_6_0 -tQt_2_3_1"
SIP_MODULES = "qt qtcanvas qttable qtpe"
SIP_FEATURES = "${WORKDIR}/features"
EXTRA_OEMAKE = " MAKEFLAGS= "

EXTRA_QMAKEVARS_POST += "QMAKE_UIC=${STAGING_BINDIR_NATIVE}/uic \
                         QMAKE_MOC=${STAGING_BINDIR_NATIVE}/moc \
                         QMAKE_RPATH=-Wl,-rpath-link, \
                         DESTDIR= \
                         VERSION=1.0.0 \
                         DEFINES+=SIP_MAKE_DLL \
                         DEFINES+=SIP_QT_SUPPORT \
                         INCLUDEPATH+=. \
                         INCLUDEPATH+=${STAGING_INCDIR}/${PYTHON_DIR} \
                         INCLUDEPATH+=${STAGING_INCDIR} \
                         LIBS+=-L${STAGING_LIBDIR}/${PYTHON_DIR}/site-packages"

do_configure_prepend() {
    printf "TEMPLATE=subdirs\nSUBDIRS=qt qtcanvas qttable qtpe\n" >pyqt.pro
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

FILES_${PN} += "${libdir}/${PYTHON_DIR}/site-packages"
FILES_${PN}-dbg += "${libdir}/python2.4/site-packages/.debug"
