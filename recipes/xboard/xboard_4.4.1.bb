DESCRIPTION = "A GUI frontend for playing various chess engines and from the internet"
HOMEPAGE = "http://www.tim-mann.org/xboard.html"
SECTION = "games"
LICENSE = "GPL"
DEPENDS = "libxaw libsm libx11 libxt libxmu libxext libice"
SRC_URI = "http://ftp.gnu.org/gnu/xboard/xboard-${PV}.tar.gz \
	   file://no-strip.patch;patch=1;pnum=2"

inherit autotools

do_configure() {
  oe_runconf --exec-prefix=${prefix} --prefix=${D}/${prefix} --bindir=${bindir} --mandir=${D}/${mandir}
}
