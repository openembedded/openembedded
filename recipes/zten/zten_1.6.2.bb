DESCRIPTION = "EB*/EPWING dictionary browser for Linux Zaurus"
AUTHOR = "Yuuichi Teranishi <teranisi@gohome.org>"
HOMEPAGE = "http://www.gohome.org/zten"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "eb kakasi"
RDEPENDS = "virtual-japanese-font"
RCONFLICTS = "ztenv"
PR = "r1"

SRC_URI = "http://www.gohome.org/cgi-bin/viewcvs.cgi/zten.tar.gz;md5sum=d24f03c8df5c98d510590bd9a63dc932 \
           file://zten.patch;patch=1"

S = "${WORKDIR}/zten"

inherit palmtop

CXXFLAGS += " -DQWS"

do_install() {
        install -d ${D}${palmtopdir}/bin
        install -d ${D}${palmtopdir}/apps/Applications
        install -d ${D}${palmtopdir}/pics
        install -m 0755 zten ${D}${palmtopdir}/bin/zten
	install -m 0644 zten.desktop ${D}${palmtopdir}/apps/Applications/
	install -m 0644 Zten.png ${D}${palmtopdir}/pics
}


SRC_URI[md5sum] = "d24f03c8df5c98d510590bd9a63dc932"
SRC_URI[sha256sum] = "7fa88dcb6da482bc20fc4916f191e9c35d01b3c0f45c9bcd66067029c49cc0b4"
