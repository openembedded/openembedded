LICENSE = "GPL"
MAINTAINER = "Patrick Steiner <patrick.steiner@a1.net>"

DEPENDS = "gtk+ libgnomeprint"

inherit gnome pkgconfig

do_stage() {
autotools_stage_all
}
