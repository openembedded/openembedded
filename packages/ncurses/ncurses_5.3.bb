BaseV := "${PV}"
SnapV := "20030906"
PV = "${BaseV}.${SnapV}"
PR = "r1"

SRC_URI = "${GNU_MIRROR}/ncurses/ncurses-${BaseV}.tar.gz \
	   file://${SnapV}.patch;patch=1 \
	   file://configure.patch;patch=1"
S = "${WORKDIR}/ncurses-${BaseV}"

include ncurses.inc
