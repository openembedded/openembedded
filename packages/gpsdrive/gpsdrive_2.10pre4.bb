require gpsdrive.inc

DEPENDS += "libwww-perl-native libart-lgpl libxml2 cairo mysql"
RDEPENDS_${PN} += "libwww-perl"

PR = "r2"

SRC_URI = "http://www.gpsdrive.de/packages/${PN}-${PV}.tar.gz \
           file://gpsdrive_2.10pre4.desktop \
           file://gpsdrive-remove-hardcoded-paths.patch;patch=1 \
           file://gpsdrive-ifdef-mapnik.patch;patch=1 \
           file://gpsdrive-2.10pre4-openstreetmap-download.patch;patch=1"

do_install_append () {
        mkdir -p  ${D}${datadir}/applications
        install -m 0644 ${WORKDIR}/gpsdrive_2.10pre4.desktop ${D}${datadir}/applications/gpsdrive.desktop
	mkdir -p ${D}${datadir}/pixmaps
	cp ${D}${datadir}/${PN}/pixmaps/gpsicon.png ${D}${datadir}/pixmaps
        # remove stuff we don't want to package
        rm ${D}${datadir}/${PN}/gpsdrive.desktop # we have our own one
        rm -rf ${D}${datadir}/${PN}/DSL # for Damn Small Linux
        rm -rf ${D}${datadir}/${PN}/gentoo # for Gentoo
}

PACKAGES += "gpsdrive-maps gpsdrive-map-icons-classic gpsdrive-map-icons-other gpsdrive-addons"

FILES_${PN} = "${bindir}/gpsdrive ${datadir}/applications ${datadir}/map-icons/icons.xml"
FILES_${PN} += "${datadir}/pixmaps ${datadir}/${PN}/pixmaps ${datadir}/${PN}/poi"
FILES_${PN}-addons = "${bindir}/*.pl ${bindir}/friendsd2 ${bindir}/geo* ${bindir}/*.sh ${bindir}/*.py ${bindir}/gpsreplay ${bindir}/gpssmswatch ${bindir}/wp* ${datadir}/mapnik ${datadir}/perl*/Geo ${datadir}/perl*/Utils"
FILES_${PN}-map-icons-classic = "${datadir}/map-icons/classic.small"
FILES_${PN}-map-icons-other = "${datadir}/map-icons/classic.big ${datadir}/map-icons/japan ${datadir}/map-icons/nickw ${datadir}/map-icons/square.big ${datadir}/map-icons/square.small ${datadir}/map-icons/svg"
FILES_${PN}-maps = "${datadir}/${PN}/maps ${datadir}/${PN}/map_koord.txt"
FILES_${PN}-doc = "${datadir}/man ${datadir}/${PN}/Documentation"
