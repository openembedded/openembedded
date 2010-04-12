LICENSE = "GPL"
DEPENDS = "libwnck orbit2 gtk+ libgnome libgnomeui gnome-desktop libglade gnome-menus"

inherit gnome pkgconfig

do_stage() {
autotools_stage_all
}

SRC_URI[archive.md5sum] = "a532717e8ac7f67b7198c256909cd7dd"
SRC_URI[archive.sha256sum] = "61a01f535b50ca0a4c35b4b59513287f17e0665c0b678952cae663b883b13827"
