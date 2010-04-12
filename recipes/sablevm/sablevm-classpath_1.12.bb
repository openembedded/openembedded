DESCRIPTION = "GNU Classpath modified to work with SableVM"
HOMEPAGE = "http://sablevm.org"
LICENSE = "Classpath"
PRIORITY = "optional"
SECTION = "libs"

DEPENDS = "glib-2.0 gtk+ libart-lgpl pango libxtst virtual/javac-native zip-native"
RDEPENDS_${PN} = "${PN}-native (>= ${PV})"

SRC_URI = "${SOURCEFORGE_MIRROR}/sablevm/sablevm-classpath-${PV}.tar.gz \
           file://disable-automake-checks.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-compressed-classes=zip"

PACKAGES += " ${PN}-native"

FILES_${PN} = "${datadir}/${PN} \
               ${libdir}/sablevm"
FILES_${PN}-native = "${libdir}/${PN}"

do_install() {
	autotools_do_install
	mv ${D}${libdir}/security ${D}${libdir}/${PN}
}

SRC_URI[md5sum] = "938602a0648660f13357115b6f1fbd60"
SRC_URI[sha256sum] = "3e7b039a188ce5b2f74c86309936e193ea5d5eefcbdcaa92b38bc3f7e1e9fec4"
