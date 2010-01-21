DESCRIPTION = "Magic 8 Ball"
HOMEPAGE = "http://www.opkg.org/package_35.html"
AUTHOR = "Jakob Westhoff"
LICENSE = "GPLv2"
SECTION = "x11/game"
SRCREV = "45"
PV = "0.2+svnr${SRCPV}"
PR = "r0"
S = "${WORKDIR}/"
FILES_${PN} += /usr/share/moko_eightball/Accelerometer/__init__.py
FILES_${PN} += /usr/share/moko_eightball/themes/eightball.edj

SRC_URI = "svn://svn.pureenergy.cc/moko_eightball;module=.;proto=svn \
	   file://files/fixpath.patch;patch=1"

do_compile() {
	cd python/src/data/themes
	./maketheme.sh
}

do_install() {
	cd python
	install -d 0755 ${D}/usr/share/moko_eightball
	install -d 0755 ${D}/usr/share/moko_eightball/Accelerometer
	install -d 0755 ${D}/usr/share/moko_eightball/themes
	install -d 0755 ${D}/usr/share/applications
	install -d 0755 ${D}/usr/share/pixmaps
	install -d 0755 ${D}/usr/bin
	install -m 0755 src/eightball.py ${D}/usr/bin/eightball
	install -m 0644 src/Accelerometer/__init__.py ${D}/usr/share/moko_eightball/Accelerometer/
	install -m 0644 src/data/themes/eightball.edj ${D}/usr/share/moko_eightball/themes/eightball.edj
	install -m 0644 ipk/usr/share/applications/eightball.desktop ${D}/usr/share/applications/eightball.desktop
	install -m 0644 ipk/usr/share/pixmaps/eightball.png ${D}/usr/share/pixmaps/eightball.png
}
