DESCRIPTION = "Terminal phone for OpenMoko/FSO"
HOMEPAGE = "http://code.google.com/p/thone/"
LICENSE = "GPLv3"
AUTHOR = "pike"
RDEPENDS = "bash python python-dbus"
PACKAGE_ARCH = "all"

SRC_URI = "http://thone.googlecode.com/files/${P}.tgz;name=archive"
SRC_URI[archive.md5sum] = "a0ab91b7ec6c4b59a9e718724497882a"
SRC_URI[archive.sha256sum] = "93a6bad45f0a6abd66cc7529b01d159a2cd257904632d15689e658c9a0b885e9"

S = "${WORKDIR}/usr"

do_install() {
  install -d ${D}/usr
  cp -ra ${S}/bin ${D}/usr
  cp -ra ${S}/share ${D}/usr
}
