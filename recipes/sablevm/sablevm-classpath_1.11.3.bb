DESCRIPTION = "GNU Classpath modified to work with SableVM"
HOMEPAGE = "http://sablevm.org"
LICENSE = "Classpath"
PRIORITY = "optional"
SECTION = "libs"

DEPENDS = "glib-2.0 gtk+ libart-lgpl pango libxtst virtual/javac-native zip-native"
RDEPENDS_${PN} = "${PN}-native (>= ${PV})"

SRC_URI = "http://sablevm.org/download/release/${PV}/${PN}-${PV}.tar.gz \
           file://disable-automake-checks.patch;patch=1"

SRC_URI[md5sum] = "0aed850f5583199b3d1adb41ac2043ed"
SRC_URI[sha256sum] = "5235747132974dd99591f0986224a82205201ea959e5be62f128378d5dc31003"

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
