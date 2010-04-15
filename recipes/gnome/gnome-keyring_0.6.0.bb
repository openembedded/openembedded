LICENSE = "GPL"
SECTION = "x11/gnome"

inherit gnome

DEPENDS = "gtk+"

EXTRA_OECONF = "--disable-gtk-doc"

SRC_URI[archive.md5sum] = "1e3a3a12b19fc5ebe95363658c2256d8"
SRC_URI[archive.sha256sum] = "649f2a0d5298b896781d0ac563b8ea1be7f3fe07fd17ea43b0ec0562be47769f"
