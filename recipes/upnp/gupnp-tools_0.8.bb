LICENSE = "GPL"
DEPENDS = "gupnp gtk+ libglade gnome-icon-theme"

SRC_URI = "http://gupnp.org/sources/${PN}/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "e2122d273d8ae6bf1cbca94fc4659e90"
SRC_URI[sha256sum] = "799537244812ad5c923572df177bd62a06b5917dcdf0590531111e2d4730ce71"
