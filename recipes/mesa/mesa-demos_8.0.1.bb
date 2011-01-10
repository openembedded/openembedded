DESCRIPTION = "mesa demo applications"
HOMEPAGE = "http://mesa3d.org"
SECTION = "x11"

LICENSE = "MIT & PD"

DEPENDS = "virtual/libx11 virtual/libgl libglew"

PR = "r0"

SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/demos/${PV}/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig

SRC_URI[md5sum] = "320c2a4b6edc6faba35d9cb1e2a30bf4"
SRC_URI[sha256sum] = "4bc7f2b20d17e3eebfec288f2367a435cd2db71fc5ac9ece2c14827e290d77d1"
