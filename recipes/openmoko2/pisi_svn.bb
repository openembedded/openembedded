DESCRIPTION = "PISI is synchronizing information"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://projects.openmoko.org/projects/pisi/"
SRCNAME = "pisi"
DEPENDS = "python-native python"
RDEPENDS = "python-vobject python python-pygtk python-pygobject python-pycairo\
           python-gdata python-webdav python-ldap python-epydoc python-core\
           python-dateutil python-sqlite3 python-netserver python-netclient\
           python-misc"

PV = "0.4.6+svnr${SRCPV}"

PACKAGE_ARCH = "all"

PR = "r0"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/pisi;module=trunk;proto=https \
          "

S = "${WORKDIR}/trunk"

FILES_${PN} += "/opt/pisi \
                ${datadir}/pixmaps \
                ${datadir}/applications \
                /home"
CONFFILES_${PN} += "/home/root/.${PN}/conf.default"

do_compile() {
	${STAGING_BINDIR_NATIVE}/python ${S}/setup.py build ${D}
}

do_install() {
	${STAGING_BINDIR_NATIVE}/python ${S}/setup.py install ${D}
}

do_install_append() {
	rm -rf ${D}/opt/pisi/Makefile
	rm -rf ${D}/opt/pisi/build/
	rm -rf ${D}/opt/pisi/deps/
	rm -rf ${D}/opt/pisi/.svn/
	rm -rf ${D}/opt/pisi/deps/.svn/
	rm -rf ${D}/opt/pisi/build/.svn/
	rm -rf ${D}/opt/pisi/tests/
	rm -rf ${D}/opt/pisi/scripts/.svn/
	rm -rf ${D}/opt/pisi/thirdparty/.svn/
	rm -rf ${D}/opt/pisi/thirdparty/conduit/.svn/
	rm -rf ${D}/opt/pisi/modules/.svn/
	rm -rf ${D}/opt/pisi/contacts/.svn/
	rm -rf ${D}/opt/pisi/events/.svn/
}
