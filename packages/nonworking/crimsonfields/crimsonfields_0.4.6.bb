DESCRIPTION = "Crimson Fields is a tactical war game in the tradition of Battle Isle."
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl libsdl-mixer libsdl-ttf"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"

SRC_URI = "http://crimson.seul.org/files/crimson-${PV}.tar.bz2"
S = "${WORKDIR}/crimson-${PV}"

inherit autotools 

do_configure() {
	gnu-configize
	oe_runconf
}

do_compile() {
	cd tools && oe_runmake \
		CC="${BUILD_CC}" CXX="${BUILD_CXX}" LD="${BUILD_CCLD}" \
		CFLAGS="${BUILD_CFLAGS}" CXXFLAGS="${BUILD_CXXFLAGS}" LDFLAGS="${BUILD_LDFLAGS}"
	cd ${S} && oe_runmake
}

# FIXME: Add .desktop file for Opie/Qtopia
