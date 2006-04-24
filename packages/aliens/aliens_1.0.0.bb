DESCRIPTION = "Classic Arcade Shooter for Qt/Embedded based palmtop environments"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
APPNAME = "aliens.sdl"
APPTYPE = "binary"
PR = "r4"

SRC_URI = "ftp://ftp.billsgames.com/unix/agenda/aliens/src/aliens_V${PV}.tar.gz"
S = "${WORKDIR}/aliens_V${PV}"

inherit opie

do_compile_prepend() {
	cd images && make && cd ..
}

do_install() {
	install -d ${D}${palmtopdir}/pics
	install -m 0644 aliens.png ${D}${palmtopdir}/pics/aliens.png
}
