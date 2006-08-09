LICENSE = "GPL"
MAINTAINER = "Koen Kooi <koen@linuxtogo.org>"
DEPENDS = "libwnck orbit2 gtk+ libgnome libgnomeui gnome-desktop libglade gnome-menus"

inherit gnome pkgconfig

do_stage() {
autotools_stage_all
}
