DESCRIPTION = "PISI is synchronizing information"
AUTHOR = "Michael Pilgermann"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://freshmeat.net/projects/pisiom"
SRCNAME = "pisi"
DEPENDS = "python-native"
RDEPENDS = "python-vobject python-core python-pygtk python-pygobject python-pycairo\
           python-gdata python-webdav python-ldap python-epydoc python-core\
           python-dateutil python-sqlite3 python-netserver python-netclient\
           python-misc python-ctypes libsyncml"

PACKAGE_ARCH = "all"

SRC_URI = "http://github.com/downloads/kichkasch/pisi/pisi-src-${PV}.tar.gz"
SRC_URI[md5sum] = "bc565875420cae99d23c2d062bb4d317"
SRC_URI[sha256sum] = "2862ffe42f42d9d42bc87a9facfb1c3323f67af4b0db338d8a657df4a604f465"

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
