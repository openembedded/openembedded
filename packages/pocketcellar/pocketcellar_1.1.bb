DESCRIPTION = "Wine cellar manager. Allows you to record details of wines and \
those you have in your cellar. The Food Assistant will make suggestions of wines \
suitable for your meal, and indicate those in your cellar that match."
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "http://www.staikos.net/~staikos/pocketcellar/pocketcellar-${PV}.tar.gz \
           file://winedb.patch;patch=1 \
           file://cellardb.patch;patch=1 \
           file://pocketcellar.patch;patch=1 \
           file://gcc3.patch;patch=1"

inherit palmtop

EXTRA_QMAKEVARS_POST = " DESTDIR=pkg-cellar/home/QtPalmtop/bin/"

do_install() {
        install -d ${D}${palmtopdir}/bin \
        	   ${D}${palmtopdir}/apps/Applications \
        	   ${D}${palmtopdir}/pics \
		   ${D}${palmtopdir}/data/PocketCellar
			   
	install -m 644 pkg-pcellar/home/QtPalmtop/data/PocketCellar/* ${D}${palmtopdir}/data/PocketCellar/
        install -m 755 pkg-cellar/home/QtPalmtop/bin/pocketcellar ${D}${palmtopdir}/bin/
        install -m 644 pocketcellar.desktop ${D}${palmtopdir}/apps/Applications/
        install -m 644 pocketcellar.png ${D}${palmtopdir}/pics/
        install -m 644 pkg-pcellar/home/root/Settings/foodassist.conf ${D}${palmtopdir}/data/PocketCellar/
}

FILES_${PN} = "/"
