DESCRIPTION = "Python Qt4 Bindings"
HOMEPAGE = "http://riverbankcomputing.co.uk"
AUTHOR = "Phil Thomson @ riverbank.co.uk"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "sip-native python-sip"
RDEPENDS = "python-core"
SRCNAME = "pyqt"
PR = "ml1"

SRC_URI = "\
  http://www.riverbankcomputing.com/Downloads/PyQt4/GPL/PyQt-x11-gpl-${PV}.tar.gz \
  file://cross-compile.patch;patch=1 \
  file://01_configure.dpatch;patch=1 \
  file://02_htmllinks.dpatch;patch=1 \
  file://03_qreal.dpatch;patch=1 \
  file://04_qreal_api_fixes.dpatch;patch=1 \
  file://assistantclient-fix.patch;patch=1"
S = "${WORKDIR}/PyQt-x11-gpl-${PV}"

inherit qt4x11 sip distutils-base

PARALLEL_MAKE = ""

QMAKE_PROFILES = "pyqt.pro"
# NOTE: match with qt version we have in OE
EXTRA_SIPTAGS = "-tWS_X11 -tQt_4_3_3 -xVendorID -xPyQt_SessionManager -xPyQt_Accessibility"
EXTRA_OEMAKE = " MAKEFLAGS= "

SIP_MODULES = "QtCore QtGui QtNetwork QtSql QtSvg QtXml QtAssistant"
EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${OE_QMAKE_INCDIR_QT}/Qt \
                         INCLUDEPATH+=${STAGING_INCDIR}/${PYTHON_DIR} \
                         DEFINES+=QT_NO_FPU"

FIX_QREAL = "\
  QtCore/qtimeline.sip \
  QtCore/qrect.sip \
  QtGui/qtransform.sip \
"

do_generate_prepend() {
    for i in ${FIX_QREAL}; do
        sed -i -e s,qreal,float,g sip/$i
    done
}

do_configure_prepend() {
    printf "TEMPLATE=subdirs\nSUBDIRS=${SIP_MODULES}\n" >pyqt.pro
}

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
	cp -pPR elementtree ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt4/
	cp __init__.py ${D}${libdir}/${PYTHON_DIR}/site-packages/PyQt4/
}

FILES_${PN} = "${libdir}/${PYTHON_DIR}/site-packages"
