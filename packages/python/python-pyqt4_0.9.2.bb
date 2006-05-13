DESCRIPTION = "Python Qt4 Bindings"
HOMEPAGE = "http://riverbankcomputing.co.uk"
AUTHOR = "Phil Thomson @ riverbank.co.uk"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
RDEPENDS = "python-core"
SRCNAME = "pyqt"
PR = "ml2"

SRC_URI = "http://www.riverbankcomputing.com/Downloads/PyQt4/GPL/PyQt4-gpl-4.0beta1.tar.gz \
           file://cross-compile.patch;patch=1 \
           file://optional-features.patch;patch=1"
S = "${WORKDIR}/PyQt4-gpl-4.0beta1"

inherit qmake qt4x11 sip4 distutils-base

PARALLEL_MAKE = ""

QMAKE_PROFILES = "pyqt.pro"
EXTRA_SIPTAGS = "-tWS_X11 -tQt_4_1_2 -xVendorID -xSessionManager -xAccessibility"
EXTRA_OEMAKE = " MAKEFLAGS= "

SIP_MODULES = "QtCore QtGui QtNetwork QtSql QtSvg QtXml"
# SIP_MODULES += "QtAssistant"
EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${OE_QMAKE_INCDIR_QT}/Qt \
                         INCLUDEPATH+=${STAGING_INCDIR}/${PYTHON_DIR}"

#EXTRA_QMAKEVARS_POST += "QMAKE_UIC=${STAGING_BINDIR}/uic \
#                         QMAKE_MOC=${STAGING_BINDIR}/moc \
#                         QMAKE_RPATH=-Wl,-rpath-link, \
#                         DESTDIR= \
#                         VERSION=1.0.0 \
#                         DEFINES+=SIP_MAKE_DLL \
#                         DEFINES+=SIP_QT_SUPPORT \
#                         INCLUDEPATH+=. \
#                         INCLUDEPATH+=${STAGING_INCDIR}/${PYTHON_DIR} \
#                         INCLUDEPATH+=${STAGING_INCDIR} \
#                         LIBS+=-L${STAGING_LIBDIR}/${PYTHON_DIR}/site-packages"

do_configure_prepend() {
    echo -e "TEMPLATE=subdirs\nSUBDIRS=${SIP_MODULES}\n" >pyqt.pro
}

#do_configure() {
#    echo "yes" | python configure.py -w -q ${OE_QMAKE_QMAKE}
#}

do_stage() {
    install -d ${STAGING_SIPDIR}/qt/
    install -d ${STAGING_LIBDIR}/${PYTHON_DIR}/site-packages
    for module in ${SIP_MODULES}
    do
        install -m 0644 ${S}/sip/${module}/*.sip ${STAGING_SIPDIR}/qt/
	install -m 0755 ${module}/lib${module}.so ${STAGING_LIBDIR}/${PYTHON_DIR}/site-packages/${module}.so
    done
}

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt4
    for module in ${SIP_MODULES}
    do
		echo "from PyQt4.${module} import *\n" >> ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt4/Qt.py
		install -m 0755 ${module}/lib${module}.so ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt4/${module}.so
    done
	cp -a elementtree ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt4/
	cp __init__.py ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt4/
}

FILES_${PN} = "${libdir}/${PYTHON_DIR}/site-packages"
