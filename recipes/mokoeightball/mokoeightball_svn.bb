DESCRIPTION = "Magic 8 Ball"
HOMEPAGE = "http://www.opkg.org/package_35.html"
AUTHOR = "Jakob Westhoff"
LICENSE = "GPLv2"
SECTION = "x11/game"
SRCREV = "45"
DEPENDS = "edje-native"
PV = "0.2+svnr${SRCPV}"
PR = "r1"
FILES_${PN} += ${datadir}/moko_eightball/Accelerometer/__init__.py
FILES_${PN} += ${datadir}/moko_eightball/themes/eightball.edj

SRC_URI = "svn://svn.pureenergy.cc/moko_eightball;module=python;proto=svn \
	   file://fixpath.patch"
S = "${WORKDIR}/python"

do_compile() {
        ${STAGING_BINDIR_NATIVE}/edje_cc -v -id src/data/images -fd src/data/fonts src/data/themes/eightball.edc -o eightball.edj
	# fix hardcoded path
	sed -i "s#/usr/share/moko_eightball#${datadir}/moko_eightball#g" src/eightball.py
	sed -i "s#/usr/bin/env#env#g" src/eightball.py
	# fix QA issues
	sed -i "/^Encoding/d; /^SingleInstance/d; s/Name=Moko Eightball/Name=Eightball/g; s/Categories=GTK;Application;Games;Fun;/Categories=Game;/g" ipk/usr/share/applications/eightball.desktop
}

do_install() {
	install -d 0755 ${D}${datadir}/moko_eightball
	install -d 0755 ${D}${datadir}/moko_eightball/Accelerometer
	install -d 0755 ${D}${datadir}/moko_eightball/themes
	install -d 0755 ${D}${datadir}/applications
	install -d 0755 ${D}${datadir}/pixmaps
	install -d 0755 ${D}${bindir}
	install -m 0755 src/eightball.py ${D}${bindir}/eightball
	install -m 0644 src/Accelerometer/__init__.py ${D}${datadir}/moko_eightball/Accelerometer/
	install -m 0644 eightball.edj ${D}${datadir}/moko_eightball/themes/eightball.edj
	install -m 0644 ipk/usr/share/applications/eightball.desktop ${D}${datadir}/applications/eightball.desktop
	install -m 0644 ipk/usr/share/pixmaps/eightball.png ${D}${datadir}/pixmaps/eightball.png
}
