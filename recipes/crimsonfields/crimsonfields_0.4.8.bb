DESCRIPTION = "Crimson Fields is a tactical war game in the tradition of Battle Isle."
SECTION = "games"
DEPENDS = "crimsonfields-native virtual/libsdl libsdl-mixer libsdl-ttf"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://crimson.seul.org/files/crimson-${PV}.tar.bz2 \
           file://native-tools.patch;patch=1"
S = "${WORKDIR}/crimson-${PV}"

inherit autotools

HOST_TOOLS = "cfed mkdatafile mklocale mktileset mkunitset"

do_configure() {
	gnu-configize
	oe_runconf
	for binary in ${HOST_TOOLS}
	do
		install -m 0755 ${STAGING_BINDIR_NATIVE}/$binary tools/
	done
	install -m 0644 ${STAGING_DATADIR_NATIVE}/default.* tools/
}

do_install() {
	autotools_do_install
	install -d ${D}${palmtopdir}/apps/Games/
	install -d ${D}${palmtopdir}/pics/
	install -m 0644 ${D}${datadir}/applications/crimson.desktop ${D}${palmtopdir}/apps/Games/
	install -m 0644 ${D}${datadir}/pixmaps/*.png ${D}${palmtopdir}/pics/
}

FILES_${PN} = "${bindir} ${datadir} ${palmtopdir}"

SRC_URI[md5sum] = "460920e64b07ea0ef139a0f5d51bd2d9"
SRC_URI[sha256sum] = "95784b14539dec30565b0bf1da8a3b1d51636142bbf1207c6d87256c92172aa7"
