require vala.inc

MAJV = "${@bb.data.getVar('PV',d,1)[:3]}"

SRC_URI = "http://download.gnome.org/sources/vala/${MAJV}/vala-${PV}.tar.bz2"

