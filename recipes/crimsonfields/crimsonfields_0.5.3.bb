require crimsonfields.inc

DEPENDS = "crimsonfields-native virtual/libsdl libsdl-mixer libsdl-ttf"
SRC_URI += "file://native-tools.patch;apply=yes"
PR = "${INC_PR}.0"

inherit autotools

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"

HOST_TOOLS = "cfed mkdatafile mklocale mktileset mkunitset"

do_configure_prepend() {
	for binary in ${HOST_TOOLS}
	do
		install -m 0755 ${STAGING_BINDIR_NATIVE}/$binary tools/
	done
	install -m 0644 ${STAGING_DATADIR_NATIVE}/default.* tools/
	install -m 0644 ${STAGING_DATADIR_NATIVE}/cf.dat tools/
}

do_install_append() {
	install -m 0644 tools/default.* ${D}${datadir}/crimson/
	install -m 0644 tools/cf.dat ${D}${datadir}/crimson/
}

FILES_${PN} += "${datadir}/crimson/"
