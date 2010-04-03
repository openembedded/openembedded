DESCRIPTION = "PISI is synchronizing information"
AUTHOR = "Michael Pilgermann"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://freshmeat.net/projects/pisiom"
SRCNAME = "pisi"
DEPENDS = "python-native"
RDEPENDS = "python-vobject python python-pygtk python-pygobject python-pycairo\
           python-gdata python-webdav python-ldap python-epydoc python-core\
           python-dateutil python-sqlite3 python-netserver python-netclient\
           python-misc python-ctypes libsyncml"

PACKAGE_ARCH = "all"

PR = "r0"

SRC_URI = "http://github.com/downloads/kichkasch/pisi/pisi-src-${PV}.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "a1c241a56cb786025a79df92aef2dcd1"
SRC_URI[archive.sha256sum] = "b46f11a570904bf550558ba4a5cc99e42dd950f0aec88745752b994757392c18"

FILES_${PN} += "/opt/${PN} \
                ${datadir}/pixmaps \
                ${datadir}/applications \
                ${datadir}/doc/${PN}"
CONFFILES_${PN} += "/usr/share/doc/${PN}/conf.example"

do_compile() {
	${STAGING_BINDIR_NATIVE}/python ${S}/setup.py build ${D}
}

do_install() {
	${STAGING_BINDIR_NATIVE}/python ${S}/setup.py install ${D}
	rm -rf ${D}/opt/pisi/build/
	rm -rf ${D}/opt/pisi/patches/
}
