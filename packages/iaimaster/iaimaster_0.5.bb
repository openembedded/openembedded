DESCRIPTION = "Pen action mini game. You fight evil Iai-Master and must survive. \
(Iai is a kind of the samurai fighting style)"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
SECTION = "opie/games"
LICENSE = "GPL"
APPNAME = "${PN}"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}"

SRC_URI = "http://www.urban.ne.jp/home/kanemori/zaurus/IaiMaster_${PV}.tar.gz \
           file://iaimaster.desktop \
           file://iaimaster.png"
S = "${WORKDIR}/IaiMaster"

inherit opie

EXTRA_QMAKEVARS_POST = "TARGET=${PN}"

do_configure_prepend() {
	qmake -project
}

do_install() {
	install -d ${D}${palmtopdir}/pics/
	install -m 0644 ${WORKDIR}/iaimaster.png ${D}${palmtopdir}/pics/
}

