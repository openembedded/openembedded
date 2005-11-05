DESCRIPTION = "Runtime helper for sip-generated python wrapper libraries"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "virtual/libqte2 python"
RDEPENDS = "python-core"
PR = "ml3"

SRC_URI = "http://www.vanille.de/mirror/sip-${PV}.tar.gz"
S = "${WORKDIR}/sip-${PV}/siplib"

inherit qmake distutils-base

EXTRA_QMAKEVARS_POST = " TEMPLATE=lib \
                         CONFIG=qt \
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
	install -d ${STAGING_LIBDIR}/${PYTHON_DIR}/site-packages/
	oe_libinstall -so libsip ${STAGING_LIBDIR}/${PYTHON_DIR}/site-packages/
	install -m 0644 sip.h ${STAGING_INCDIR}/sip.h
}

do_install() {
	install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/
	install libsip.so.1.0.0 ${D}${libdir}/${PYTHON_DIR}/site-packages/sip.so
}

FILES_${PN} = "${libdir}/${PYTHON_DIR}/site-packages/sip.so"

