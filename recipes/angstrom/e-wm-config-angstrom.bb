DESCRIPTION = "Enlightenment DR17 theme for Angstrom"
LICENSE = "MIT/BSD"
DEPENDS = "edje-native eet-native"
RDEPENDS = "e-wm"
RRECOMMENDS_${PN} = "places systray"

PR = "r6"

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

# [09:16:17] * koen mumbles something about binary config file
# [09:16:19] <raster> eet -d e.cfg config e.src
# [09:16:29] <raster> will get u a test dump of it (as e.src)
# [09:17:09] <raster> eet -e e.cfg config e.src 1
# [09:17:12] <raster> will re-encode 

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

