DESCRIPTION = "Billiard Game for Qt/Embedded based palmtop environments w/ SDL."
HOMEPAGE = "http://www.chipx86.com/projects/billiardz/"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "libsdl-qpe libsdl-image"
PR = "r1"

SRC_URI = "http://www.chipx86.com/packages/ipkg/billiardz-${PV}.tar.gz"

inherit palmtop

QMAKE_PROFILES = "billiardz.arm.pro"
EXTRA_QMAKEVARS_POST = "DEFINES-=FPM_INTEL" 

do_install() {
        install -d ${D}${palmtopdir}/bin \
		   ${D}${palmtopdir}/apps/ \
		   ${D}${palmtopdir}/apps/Games \
		   ${D}${palmtopdir}/pics \
		   ${D}${palmtopdir}/pics/billiardz
        install -m 0755 billiardz ${D}${palmtopdir}/bin/billiardz
        install -m 0644 billiardz.png ${D}${palmtopdir}/pics/billiardz.png
	cp -a images/*.png ${D}${palmtopdir}/pics/billiardz

	echo "[Desktop Entry] " >${D}${palmtopdir}/apps/Games/billiardz.desktop
	echo "Comment=Billiards for Zaurus" >>${D}${palmtopdir}/apps/Games/billiardz.desktop
	echo "Exec=billiardz" >>${D}${palmtopdir}/apps/Games/billiardz.desktop
	echo "Icon=billiardz" >>${D}${palmtopdir}/apps/Games/billiardz.desktop
	echo "Type=Application" >>${D}${palmtopdir}/apps/Games/billiardz.desktop
	echo "Name=BilliardZ" >>${D}${palmtopdir}/apps/Games/billiardz.desktop
}
