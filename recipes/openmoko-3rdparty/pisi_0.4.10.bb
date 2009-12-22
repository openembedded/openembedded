DESCRIPTION = "PISI is synchronizing information"
AUTHOR = "Michael Pilgermann"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://projects.openmoko.org/projects/pisi/"
SRCNAME = "pisi"
DEPENDS = "python-native python"
RDEPENDS = "python-vobject python python-pygtk python-pygobject python-pycairo\
           python-gdata python-webdav python-ldap python-epydoc python-core\
           python-dateutil python-sqlite3 python-netserver python-netclient\
           python-misc"

PACKAGE_ARCH = "all"

PR = "r0"

SRC_URI = "http://projects.openmoko.org/frs/download.php/937/pisi-src-${PV}.tar.gz"

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
	rm -rf ${D}/opt/pisi/build/
	rm -rf ${D}/opt/pisi/patches/
}
