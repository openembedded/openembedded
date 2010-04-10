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

SRC_URI[md5sum] = "6619557b02559ac3191d4cc2054bf325"
SRC_URI[sha256sum] = "ab6e33b09bfbd407ee444ef37d769658e651cfe6eee96ce7aac5be8860e069e5"
