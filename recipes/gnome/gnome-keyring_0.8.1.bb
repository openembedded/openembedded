LICENSE = "GPL"
SECTION = "x11/gnome"

inherit autotools gnome pkgconfig

DEPENDS = "gtk+"

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
        autotools_stage_all
}

SRC_URI[archive.md5sum] = "24b15dedcf40c1c60d0fb989370d80ff"
SRC_URI[archive.sha256sum] = "ad28558e2c0e5496cdfec3f8badf84d64af3aebc3fc9f5632066591e20ce3943"
