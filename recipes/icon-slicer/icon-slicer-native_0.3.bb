LICENSE = "MIT"

SRC_URI = "http://freedesktop.org/software/icon-slicer/releases/icon-slicer-${PV}.tar.gz"

inherit autotools native

DEPENDS = "gdk-pixbuf-csource-native popt-native"

S = "${WORKDIR}/icon-slicer-${PV}"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}




SRC_URI[md5sum] = "5c5374d4f265b0abe4daef1d03f87104"
SRC_URI[sha256sum] = "05f0216dd0c25a17859de66357f64da5033375b6fbf5f31ca54867311160b64d"
