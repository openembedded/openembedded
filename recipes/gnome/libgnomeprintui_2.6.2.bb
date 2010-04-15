LICENSE = "GPL"
SECTION = "x11/gnome/libs"

PR = "r2"

DEPENDS = "libgnomeprint gtk+ libgnomecanvas gnome-icon-theme gnome-common"

inherit gnome pkgconfig

SRC_URI += "file://configure.patch;patch=1"

SRC_URI[archive.md5sum] = "b26f7f70eb67fe29f20f6312d4f3085e"
SRC_URI[archive.sha256sum] = "7869603bbda88f35652d9b70af178836ca7612119ab36084ccc35f2d51c83f13"
