DESCRIPTION = "The Libcroco project is an effort to build a generic Cascading Style Sheet (CSS) parsing and manipulation toolkit"
SECTION = "x11/utils"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
DEPENDS = "glib-2.0 libxml2"
LICENSE = "LGPL"
PR = "r0"

inherit autotools pkgconfig gnome

do_stage() {
	autotools_stage_all
}
