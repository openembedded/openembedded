DESCRIPTION = "Xoo is a GTK2 based graphical wrapper around a windowed X Server. \
It is intended for embedded developers that want to simulate a target device \
(with an accurate display size, working hardware buttons, etc) on a desktop machine."
HOMEPAGE = "http://projects.o-hand.com/xoo"
LICENSE = "GPL"
DEPENDS = "virtual/libx11 libxtst gtk+ libglade"
SRCDATE = 20070204
PV = "0.7+svn${SRCDATE}"
PR = "r3"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=Xoo;proto=http \
           file://gpephone-vm.patch;patch=1;pnum=0"

S = "${WORKDIR}/Xoo"

inherit autotools

FILES_${PN} += "${datadir}/xoo"
