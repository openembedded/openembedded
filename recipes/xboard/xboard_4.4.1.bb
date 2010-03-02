DESCRIPTION = "A GUI frontend for playing various chess engines and from the internet"
HOMEPAGE = "http://www.tim-mann.org/xboard.html"
SECTION = "games"
LICENSE = "GPL"
DEPENDS = "libxaw libsm libx11 libxt libxmu libxext libice"
SRC_URI = "http://ftp.gnu.org/gnu/xboard/xboard-${PV}.tar.gz;name=archive \
	   file://no-strip.patch;patch=1;pnum=2"

SRC_URI[archive.md5sum] = "4623a83fdd43f410bfcc8a20e2eb1474"
SRC_URI[archive.sha256sum] = "74184fa7d5ea4ce963f7108e01256e6eb7bb2269ff6f780599fdaaf2d913950e"

inherit autotools

do_configure() {
  oe_runconf --exec-prefix=${prefix} --prefix=${D}/${prefix} --bindir=${bindir} --mandir=${D}/${mandir}
}
