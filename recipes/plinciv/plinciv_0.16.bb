LICENSE = "GPL"
SECTION = "x11/games"
DEPENDS = "gtk+"
DESCRIPTION = "Embedded version of a popular FreeCiv game"
HOMEPAGE = "http://www.handhelds.org/moin/moin.cgi/PlinCiv"

SRC_URI = "ftp://ftp.freeciv.org/freeciv/stable/freeciv-1.14.1.tar.bz2 \
	file://FC1.14.1-PC0.16.diff.gz;patch=1 \
	file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--enable-client=gtk2 --disable-esd --disable-winmm --disable-sdl-mixer"

S = "${WORKDIR}/freeciv-1.14.1"

FILES_${PN} = "${bindir} \
               ${datadir}/freeciv"

SRC_URI[md5sum] = "d328f65e7fca5252f27161f5f9e97a03"
SRC_URI[sha256sum] = "8a963570e5c4ea432b0e31d77d3605705bda91a9f97ff377c5c3204ca768e342"
