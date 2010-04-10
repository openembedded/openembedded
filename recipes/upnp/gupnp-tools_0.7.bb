LICENSE = "GPL"
DEPENDS = "gupnp gtk+ libglade gnome-icon-theme"

SRC_URI = "http://gupnp.org/sources/${PN}/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "a96674de9bfdc42c70e8b9f801e2822e"
SRC_URI[sha256sum] = "cd085871881f6c10d6ddc1206787ff692eb6b37a746a53b64f55aa9e91defeae"
