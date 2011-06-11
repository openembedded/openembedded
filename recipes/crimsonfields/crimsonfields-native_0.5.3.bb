require crimsonfields.inc

DEPENDS = "libsdl-native"
PR = "${INC_PR}.0"
inherit autotools native

export SDL_CONFIG = "${STAGING_BINDIR}/sdl-config"

HOST_TOOLS = "cfed mkdatafile mklocale mktileset mkunitset"

do_compile() {
        cd tools && oe_runmake
}

do_install() {
        for binary in ${HOST_TOOLS}
        do
                install -m 0755 tools/$binary ${STAGING_BINDIR}
        done
        install -m 0644 tools/default.* ${STAGING_DATADIR}
        install -m 0644 tools/cf.dat ${STAGING_DATADIR}
}

