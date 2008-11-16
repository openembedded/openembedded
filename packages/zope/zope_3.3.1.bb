DESCRIPTION = "A full fledged pluggable content management system with integrated web server and much more."
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "python"
RDEPENDS = "python-core python-shell"
LICENSE = "ZPL"
PR = "r5"

SRC_URI = "http://www.zope.org/Products/Zope3/${PV}/Zope-${PV}.tgz"
S = "${WORKDIR}/Zope-${PV}"

inherit distutils-base

do_configure() {
	./configure --with-python=${STAGING_BINDIR_NATIVE}/python --prefix=${prefix} --force
}

do_compile() {
	oe_runmake HOST_SYS=${HOST_SYS} BUILD_SYS=${BUILD_SYS} STAGING_INCDIR=${STAGING_INCDIR}
}

do_install() {
	install -d ${D}${libdir}/${PYTHON_DIR}
	oe_runmake install prefix=${D}${prefix} HOST_SYS=${HOST_SYS} BUILD_SYS=${BUILD_SYS}
	mv ${D}${libdir}/python/* ${D}${libdir}/${PYTHON_DIR} 
}

PACKAGES =+ "python-zopeinterface python-zopeinterface-dbg"

FILES_${PN} = "${prefix}"
FILES_${PN}_doc = "${prefix}/doc"
FILES_${PN}-dbg += "\
${libdir}/${PYTHON_DIR}/BTrees/.debug \
${libdir}/${PYTHON_DIR}/persistent/.debug \
${libdir}/${PYTHON_DIR}/zope/proxy/.debug \
${libdir}/${PYTHON_DIR}/zope/thread/.debug \
${libdir}/${PYTHON_DIR}/zope/security/.debug \
${libdir}/${PYTHON_DIR}/zope/hookable/.debug \
${libdir}/${PYTHON_DIR}/zope/app/container/.debug \
${libdir}/${PYTHON_DIR}/zope/i18nmessageid/.debug \
${libdir}/${PYTHON_DIR}/ZODB/.debug"
FILES_python-zopeinterface-dbg += "${libdir}/${PYTHON_DIR}/zope/interface/.debug "

FILES_python-zopeinterface = "${libdir}/${PYTHON_DIR}/zope/interface/*.* ${libdir}/${PYTHON_DIR}/zope/interface/common"
