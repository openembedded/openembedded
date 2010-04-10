DESCRIPTION = "ZRally is a top view race game which offers the player mulitple \
tracks and multiple skill levels."
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Kevin Greenhaw <kevin_greenhaw@email.com>"
HOMEPAGE = "http://zrally.sourceforge.net/zrally.html"
APPNAME = "zrally"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}"

SRC_URI = "${SOURCEFORGE_MIRROR}/zrally/zrally_0.90_src.tar.gz \
file://dir.patch;patch=1;pnum=0"

S = "${WORKDIR}"

inherit opie

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/track_pics/
	install -m 0644 track_pics/*.png ${D}${palmtopdir}/pics/${APPNAME}/track_pics/
	install -m 0644 track_pics/ZRallyIcon.png ${D}${palmtopdir}/pics/
}


SRC_URI[md5sum] = "7084c0d2b28108563ca45e5ec1533ba1"
SRC_URI[sha256sum] = "c4fb0477fdc110b63d867ae2a46cca7913fa6a0ca8bf574c7189329bea91dcdf"
