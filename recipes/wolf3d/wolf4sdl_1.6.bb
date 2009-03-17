LICENSE = "Various"
DESCRIPTION = "Wolfenstein3d game engine"
DEPENDS = "virtual/libsdl libsdl-mixer"

SRC_URI = "http://www.stud.uni-karlsruhe.de/~uvaue/chaos/bins/Wolf4SDL-${PV}-src.zip"

S = "${WORKDIR}/Wolf4SDL-1.6-src"

TARGET_CFLAGS_append = " -lSDL -lSDL_mixer -I${STAGING_INCDIR} -I${STAGING_INCDIR}/SDL"

do_compile() {
	oe_runmake -e Q= PREFIX=${prefix}
}

do_install() {
	oe_runmake -e Q= PREFIX=${D}/${prefix} install
}
