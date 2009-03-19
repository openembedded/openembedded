DESCRIPTION = "Enlightenment DR17 theme for Angstrom"
LICENSE = "MIT/BSD"
DEPENDS = "edje-native eet-native"
RDEPENDS = "e-wm"
RRECOMMENDS_${PN} = "places"

PR = "r4"

SRC_URI = " \
          file://e.src \
          file://icon.png \
          file://*.src \
          file://profile.desktop \
          "
S = "${WORKDIR}/angstrom"

do_configure() {
	cp ${WORKDIR}/*.src ${WORKDIR}/*.desktop ${WORKDIR}/*.png ${S}/
}


do_compile() {
	for i in *.src ; do
		eet -e $(echo $i | sed s:src:cfg:g) config $i 1
	done
}

do_install() {
    install -d ${D}${datadir}/enlightenment/data/config/angstrom/
    
    install -m 0644 ${S}/*.cfg ${D}${datadir}/enlightenment/data/config/angstrom/
    install -m 0644 ${S}/*.desktop ${D}${datadir}/enlightenment/data/config/angstrom/
    install -m 0644 ${S}/*.png ${D}${datadir}/enlightenment/data/config/angstrom/
}

FILES_${PN} = "${datadir}/enlightenment"

PACKAGE_ARCH_${PN} = "all"

