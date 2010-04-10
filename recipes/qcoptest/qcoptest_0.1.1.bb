DESCRIPTION = "QCop test"
SECTION = "opie/applications"
AUTHOR = "Ikezawa Masakazu <ikezawa@gol.com>"
HOMEPAGE = "http://www2.gol.com/users/ikezawa/zaurus/qcoptest.html"
LICENSE = "GPL"

APPNAME = "qcoptest"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}"

SRC_URI = "http://www2.gol.com/users/ikezawa/zaurus/qcoptest_0.1.1.tar.gz \
file://qcoptest.png \
file://qcoptest.desktop"

S = "${WORKDIR}"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/
        install -m 0644 ${WORKDIR}/${APPNAME}.png ${D}${palmtopdir}/pics/
}

SRC_URI[md5sum] = "a31f12647c5bb5f93c81465b4e5ff25a"
SRC_URI[sha256sum] = "5795b9d619142e2d01016130c7ac71298aa1cabda4806f11762bb8fd489293af"
