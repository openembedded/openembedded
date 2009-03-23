DESCRIPTION = "Runtime helper for sip-generated python wrapper libraries"
SECTION = "devel/python"
HOMEPAGE = "http://www.riverbankcomputing.co.uk/sip"
AUTHOR = "Phil Thompson"
LICENSE = "GPL"
DEPENDS = "python"
RDEPENDS = "python-core"

SRC_URI = "http://www.riverbankcomputing.com/static/Downloads/sip4/sip-${PV}.tar.gz"

S = "${WORKDIR}/sip-${PV}/siplib"

inherit qt4x11 distutils-base

EXTRA_QMAKEVARS_POST += " TEMPLATE=lib \
                         CONFIG=console \
                         DESTDIR= \
                         VERSION=1.0.0 \
                         TARGET=sip \
                         DEFINES=SIP_QT_SUPPORT \
                         INCLUDEPATH+=. \
                         INCLUDEPATH+=${STAGING_INCDIR}/${PYTHON_DIR} \
                         INCLUDEPATH+=${STAGING_INCDIR}"


do_configure_prepend() {
	cat siplib.sbf | sed s,target,TARGET, | sed s,sources,SOURCES, | sed s,headers,HEADERS, > siplib.pro
}

do_stage() {
	install -d ${STAGING_LIBDIR_NATIVE}/${PYTHON_DIR}/site-packages/
	# sipconfig.py sipdistutils.py
	install -m 0644 sip.h ${STAGING_INCDIR}/sip.h
}

do_install() {
	install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/
	install -m 0755 libsip.so.1.0.0 ${D}${libdir}/${PYTHON_DIR}/site-packages/sip.so
}

FILES_${PN} = "${libdir}/${PYTHON_DIR}/site-packages/sip.so"

