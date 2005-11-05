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
