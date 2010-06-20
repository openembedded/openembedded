SECTION = "x11/utils"
DESCRIPTION = "feh is a fast, lightweight image viewer which uses imlib2."
LICENSE = "MIT"
DEPENDS = "virtual/imlib2 giblib jpeg virtual/libx11 libxext libxt"

SRC_URI = "https://derf.homelinux.org/projects/feh/feh-${PV}.tar.bz2 \
	   file://noxinerama.patch"
S = "${WORKDIR}/feh-${PV}"

inherit autotools

do_install() {
    oe_runmake 'DESTDIR=${D}' PREFIX=/usr install-bin
}

SRC_URI[md5sum] = "59181976384d1f5bddae016b39334e2e"
SRC_URI[sha256sum] = "13cd57ac8e97430ea7875d9e5d642166df4f1fb5884cc4523da84bcfe4fa6c56"
