DESCRIPTION = "Classic Arcade Shooter for Qt/Embedded based palmtop environments"
SECTION = "opie/games"
PRIORITY = "optional"
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

SRC_URI[md5sum] = "9d7cde75aecf4b85478c0e47343d4293"
SRC_URI[sha256sum] = "0aa0084a74f912f4002f1c40a815ce62ac13331ec84787a954d8bea06e1c96c5"
