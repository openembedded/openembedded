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

SRC_URI[md5sum] = "61eed8ed819688663e399b5e79ed006f"
SRC_URI[sha256sum] = "6a19418a074a7dec6fd67f00df74f3335e85eb38d2d2a17bd0e91cf8010537e3"
