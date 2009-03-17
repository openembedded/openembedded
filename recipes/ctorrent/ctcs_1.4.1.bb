require ctorrent.inc

DESCRIPTION +=  This is the controller of the enhanced version"
RDEPENDS = "perl perl-module-strict perl-module-socket perl-module-tcntl \
            perl-module-errno perl-module-sys-hostname"

SRC_URI = "${SOURCEFORGE_MIRROR}/dtorrent/ctcs-${PV}.tar.gz"

do_install () {
  install -d ${D}/usr/bin
  install -m 0755 ${S}/ctcs ${D}/usr/bin/
}
