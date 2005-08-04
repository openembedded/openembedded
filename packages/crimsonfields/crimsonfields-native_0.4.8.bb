include crimsonfields_${PV}.bb
inherit native

DEPENDS = "libsdl-native libsdl-ttf-native"
export SDL_CONFIG = "${STAGING_BINDIR}/sdl-config-native"

do_configure() {
	gnu-configize
	oe_runconf
}

do_compile() {
	cd tools && oe_runmake
}

do_stage() {
	for binary in ${HOST_TOOLS}
	do
		install -m 0755 tools/$binary ${STAGING_BINDIR}
	done
	install -m 0644 tools/default.* ${STAGING_DATADIR}
}

do_install() {
	:
}
