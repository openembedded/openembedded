DESCRIPTION = "openmoko-libs is a set of libraries implementing a Gtk+ based application framework for mobile communication applications"
SECTION = "openmoko/libs"
LICENSE = "LGPL"
DEPENDS += "gtk+"
PV = "0.0.1+svn${SRCDATE}"
PR = "r1"

inherit openmoko

do_configure_prepend() {
	touch libmokocore/Makefile.in
	touch libmokopim/Makefile.in
	touch libmokonet/Makefile.in
}

do_stage() {
	autotools_stage_all
}

