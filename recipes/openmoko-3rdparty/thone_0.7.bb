DESCRIPTION = "Terminal phone for OpenMoko/FSO"
HOMEPAGE = "http://code.google.com/p/thone/"
LICENSE = "GPLv3"
AUTHOR = "pike"
RDEPENDS = "bash python python-dbus"
PACKAGE_ARCH = "all"

SRC_URI = "http://thone.googlecode.com/files/${P}.tgz;name=archive"
SRC_URI[archive.md5sum] = "ddf90638ac279b359e9081e0271fe881"
SRC_URI[archive.sha256sum] = "e3eadb050b29385b9ffd2347bcc6cdbc75a681aba93efff4fee954cd6e39bb1e"

S = "${WORKDIR}/usr"

do_install() {
  install -d ${D}/usr
  cp -ra ${S}/bin ${D}/usr
  cp -ra ${S}/share ${D}/usr
}
