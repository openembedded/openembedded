LICENSE = "GPL"
MAINTAINER = "Patrick Steiner <patrick.steiner@a1.net>"

DEPENDS = "gtk+"

inherit gnome pkgconfig

do_stage() {
autotools_stage_all
}
