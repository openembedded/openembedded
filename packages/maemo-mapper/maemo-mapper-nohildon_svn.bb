DESCRIPTION = "GPS navigation/map display software"
LICENSE = "GPL"
DEPENDS = "sqlite3 gtk+ gnome-vfs-dbus dbus bluez-libs"
PV = "1.2.4+svn${SRCDATE}"

#only works with SRCDATE_maemo-mapper-nohildon = "20061114"
SRC_URI = "svn://garage.maemo.org/svn/maemo-mapper;proto=https;module=trunk \
           http://home.tal.org/%7Emilang/n770/maemo-mapper-desktop-20061114-001.patch;patch=1;pnum=0"

S = "${WORKDIR}/trunk"

inherit autotools pkgconfig

#FILES_${PN} = "${bindir}/gpsdrive ${bindir}/wpcvt ${bindir}/wpget ${datadir}/pixmaps ${datadir}/applications"
