LICENSE = GPL
SECTION = "x11/games"
DEPENDS = "gtk+"
DESCRIPTION = "Embedded version of a popular FreeCiv game"

SRC_URI = "ftp://ftp.freeciv.org/freeciv/stable/freeciv-1.14.1.tar.bz2 \
	http://gregorr.homelinux.org/plinciv/FC1.14.1-PC0.16.diff.gz;patch=1 \
	file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--enable-client=gtk2 --disable-esd --disable-winmm --disable-sdl-mixer"

S = "${WORKDIR}/freeciv-1.14.1"

FILES_${PN} = "${bindir} \
               ${datadir}/freeciv"
