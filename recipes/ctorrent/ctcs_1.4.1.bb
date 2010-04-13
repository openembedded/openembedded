require ctorrent.inc

DESCRIPTION += "This is the controller of the enhanced version"
RDEPENDS = "perl perl-module-strict perl-module-socket perl-module-tcntl \
            perl-module-errno perl-module-sys-hostname"

SRC_URI = "${SOURCEFORGE_MIRROR}/dtorrent/ctcs-${PV}.tar.gz"

do_install () {
  install -d ${D}/usr/bin
  install -m 0755 ${S}/ctcs ${D}/usr/bin/
}

SRC_URI[md5sum] = "7dfe725e558eb75258a2199f2aa9fdbc"
SRC_URI[sha256sum] = "9614e88d07c6b128677d4d2638a4a05ae00812ec5157ae0788012abed3172355"
