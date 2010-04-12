DESCRIPTION = "Billiard Game for Qt/Embedded based palmtop environments w/ SDL."
HOMEPAGE = "http://www.chipx86.com/projects/billiardz/"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libsdl-qpe libsdl-image"
PR = "r2"

SRC_URI = "http://www.chipx86.com/packages/ipkg/billiardz-${PV}.tar.gz \
           file://gcc4.patch;patch=1"

SRC_URI[md5sum] = "21908ae1ee9e3cb96e9dda6f096ed13f"
SRC_URI[sha256sum] = "23b70f94a987af6be23108a772b927a2c02060c6137b9589484e28b55c2bdebd"

inherit palmtop

QMAKE_PROFILES = "billiardz.arm.pro"
EXTRA_QMAKEVARS_POST += "DEFINES-=FPM_INTEL"

do_install() {
        install -d ${D}${palmtopdir}/bin \
		   ${D}${palmtopdir}/apps/ \
		   ${D}${palmtopdir}/apps/Games \
		   ${D}${palmtopdir}/pics \
		   ${D}${palmtopdir}/pics/billiardz
        install -m 0755 billiardz ${D}${palmtopdir}/bin/billiardz
        install -m 0644 billiardz.png ${D}${palmtopdir}/pics/billiardz.png
	cp -pPR images/*.png ${D}${palmtopdir}/pics/billiardz

	echo "[Desktop Entry] " >${D}${palmtopdir}/apps/Games/billiardz.desktop
	echo "Comment=Billiards for Zaurus" >>${D}${palmtopdir}/apps/Games/billiardz.desktop
	echo "Exec=billiardz" >>${D}${palmtopdir}/apps/Games/billiardz.desktop
	echo "Icon=billiardz" >>${D}${palmtopdir}/apps/Games/billiardz.desktop
	echo "Type=Application" >>${D}${palmtopdir}/apps/Games/billiardz.desktop
	echo "Name=BilliardZ" >>${D}${palmtopdir}/apps/Games/billiardz.desktop
}
