DESCRIPTION = "ZRally is a top view race game which offers the player mulitple \
tracks and multiple skill levels."
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
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

