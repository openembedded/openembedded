DESCRIPTION = "GPS navigation/map display software"
LICENSE = "GPL"
DEPENDS = "sqlite3 gtk+ gnome-vfs dbus bluez-libs"
RDEPENDS = "bluez-utils"
SRCDATE = "20061114"
PV = "1.2.4+svn${SRCDATE}"
PR = "r1"

# Only works with SRCDATE_maemo-mapper-nohildon = "20061114"
SRC_URI = "svn://garage.maemo.org/svn/maemo-mapper;proto=https;module=trunk \
           http://home.tal.org/%7Emilang/n770/maemo-mapper-desktop-20061114-001.patch;patch=1;pnum=0;name=mapperPatch \
	   file://fix_segfault.patch;patch=1"

S = "${WORKDIR}/trunk"

inherit autotools pkgconfig

do_install_append () {
	install -d ${D}${datadir}/applications/
	mv ${D}/maemo-mapper.desktop ${D}${datadir}/applications/
}

#FILES_${PN} += "${datadir}/icons"


SRC_URI[mapperPatch.md5sum] = "b391fd0d13f5cabbcb2aba3237156f32"
SRC_URI[mapperPatch.sha256sum] = "7701fa20a835f3ae504a6e04d2e449b0be2d2380e7522fa5736791a55abacf4c"
