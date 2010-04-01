DESCRIPTION = "Xoo is a GTK2 based graphical wrapper around a windowed X Server. \
It is intended for embedded developers that want to simulate a target device \
(with an accurate display size, working hardware buttons, etc) on a desktop machine."
HOMEPAGE = "http://projects.o-hand.com/xoo"
LICENSE = "GPL"
DEPENDS = "virtual/libx11 libxtst gtk+ libglade expat"
SRCREV = "1971"
PV = "0.7+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=Xoo;proto=http \
           file://*.png \
           file://*.xml"
S = "${WORKDIR}/Xoo"

inherit autotools

do_install_append() {
	for i in ${WORKDIR}/*.png ${WORKDIR}/*.xml; do
		install -m 0644 $i ${D}${datadir}/${PN}/
	done
}

