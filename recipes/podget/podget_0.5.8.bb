DESCRIPTION = "A simple podcast aggregator."
HOMEPAGE = "http://podget.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS += "virtual/libiconv"
RDEPENDS = "bash sed wget"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/podget/podget_${PV}.tar.gz \
           file://busybox_df.patch;patch=1"

S = "${WORKDIR}/podget"

do_install () {
  install -d ${D}/usr/bin
  install -m 0755 ${WORKDIR}/podget/podget ${D}/usr/bin
}
