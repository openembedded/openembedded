DESCRIPTION = "Elementary based client for Remember the Milk written in Python. "
AUTHOR = "Michael Pilgermann"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://freshmeat.net/projects/rtmom"
SRCNAME = "rtmom"
DEPENDS = "python python-elementary"
RDEPENDS = "python-core pyrtm"
RSUGGESTS_${PN} = "python-simplejson"

PACKAGE_ARCH = "all"

PR = "r0"

SRC_URI = "http://cloud.github.com/downloads/kichkasch/rtmom/rtmom-src-${PV}.tar.gz"

FILES_${PN} += "/opt/rtmom \
                ${datadir}/pixmaps \
                ${datadir}/applications \
                ${datadir}/doc/rtmom"
CONFFILES_${PN} += "/usr/share/doc/${PN}/rtmom.conf.example"

do_compile() {
	${STAGING_BINDIR_NATIVE}/python ${S}/setup.py build ${D}
}

do_install() {
	${STAGING_BINDIR_NATIVE}/python ${S}/setup.py install ${D}
	rm -rf ${D}/opt/rtmom/build/
	rm -rf ${D}/opt/rtmom/patches/
}

SRC_URI[md5sum] = "c4a1012fc0e00d2b64d8d794166bf893"
SRC_URI[sha256sum] = "9227e503a90054dd643364272d48b3eae8dae3a9c6c4a42a2859395a8786398f"
