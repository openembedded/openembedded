require pkgconfig.inc
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/pkgconfig-${PV}"

SRC_URI = "http://pkgconfig.freedesktop.org/releases/pkg-config-${PV}.tar.gz \
           file://autofoo.patch;patch=1 \
           file://sysrootfix.patch;patch=1 \
           file://glibconfig-sysdefs.h"

S = "${WORKDIR}/pkg-config-${PV}/"
inherit sdk
DEPENDS = ""
