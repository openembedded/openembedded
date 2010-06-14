DESCRIPTION = "PISI is synchronizing information"
AUTHOR = "Michael Pilgermann"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://freshmeat.net/projects/pisiom"
SRCNAME = "pisi"
DEPENDS = "python-native"
RDEPENDS_${PN} = "python-vobject python-core python-pygtk python-pygobject python-pycairo\
           python-gdata python-webdav python-ldap python-epydoc python-core\
           python-dateutil python-sqlite3 python-netserver python-netclient\
           python-misc python-ctypes libsyncml"
PR = "r1"

PACKAGE_ARCH = "all"

SRC_URI = "http://github.com/downloads/kichkasch/pisi/pisi-src-${PV}.tar.gz"
SRC_URI[md5sum] = "c416b316668575f8506dc54e19475795"
SRC_URI[sha256sum] = "a27603662747aee9a0440acc6472fe274c0724fcc66ad05849eb186bfb24868e"

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
