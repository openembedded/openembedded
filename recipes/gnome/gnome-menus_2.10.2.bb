DEPENDS = "gnome-vfs libxml2 gconf popt gtk+"
LICENSE = "GPL"


inherit gnome pkgconfig

do_stage() {
autotools_stage_all
}

FILES_${PN} += "${datadir}"

SRC_URI[archive.md5sum] = "97b0ad03ea219cc8f5c02585db1d237e"
SRC_URI[archive.sha256sum] = "0968a399590d94cf9e1640b647cc10f972a3a802cbd9602c0839f56fd2864193"
