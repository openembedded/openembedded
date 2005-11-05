DESCRIPTION = "Python QWT Bindings, QtE edition"
HOMEPAGE = "http://www.vanille.de/projects/python.spy"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
RDEPENDS = "python-core python-sip python-pyqt (>=${PV}) python-numeric qwt"
DEPENDS = "virtual/libqte2 python-numeric python-pyqt qwt"
SRCNAME = "pyqwt"
PR = "ml3"

SRC_URI = "http://www.vanille.de/mirror/PyQwt-20040118.tar.gz \
           file://qt2.x-compat.patch;patch=1 \
           file://features"
S = "${WORKDIR}/PyQwt-20040118"

inherit qmake sip distutils-base

QMAKE_PROFILES = "pyqwt.pro"
EXTRA_SIPTAGS = "-tWS_QWS -tQtPE_1_6_0 -tQt_2_3_1"
SIP_MODULES = "qwt"
SIP_FEATURES = "${WORKDIR}/features"   
EXTRA_OEMAKE = " MAKEFLAGS= "

EXTRA_QMAKEVARS_POST += "CONFIG=qt CONFIG+=warn_on CONFIG+=release \
                         TARGET=qwt DESTDIR= VERSION=1.0.0 \
                         DEFINES=SIP_MAKE_DLL DEFINES+=SIP_QT_SUPPORT DEFINES+=HAS_NUMERIC DEFINES+=QWS \
                         INCLUDEPATH+=../numpy \
                         INCLUDEPATH+=${STAGING_INCDIR}/${PYTHON_DIR} \
                         INCLUDEPATH+=${STAGING_INCDIR} \
                         LIBS+=-L${STAGING_LIBDIR}/${PYTHON_DIR}/site-packages \
                         LIBS+=-L${QTDIR}/lib LIBS+=-lqte LIBS+=-lqpe "

do_generate_prepend() {
    echo -e "TEMPLATE=subdirs\nSUBDIRS=qwt\n" >pyqwt.pro
    
    echo "%Makefile qwt.pro.in" >>sip/qwtmod.sip
    echo "TEMPLATE=lib" >>sip/qwtmod.sip
    echo 'SOURCES = $B' >>sip/qwtmod.sip
    echo 'HEADERS = $H' >>sip/qwtmod.sip
    echo "%End" >>sip/qwtmod.sip

    mkdir -p sip/qwt/
    mv sip/*.* sip/qwt/
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
