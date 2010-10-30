DESCRIPTION = "feh is a fast, lightweight image viewer which uses imlib2."
SECTION = "x11/utils"
LICENSE = "MIT"
DEPENDS = "virtual/imlib2 giblib jpeg virtual/libx11 libxext libxt"

SRC_URI = "https://derf.homelinux.org/projects/feh/feh-${PV}.tar.bz2 \
	   file://noxinerama.patch"

S = "${WORKDIR}/feh-${PV}"

inherit autotools

do_install() {
    oe_runmake 'DESTDIR=${D}' PREFIX=/usr install-bin
}

SRC_URI[md5sum] = "a27d4bdd470099dcd3d59b7c39227162"
SRC_URI[sha256sum] = "506e4f833a9c5c1eff55c20784b08aee36540c0643d822dbb76fcdbee729812c"
