DESCRIPTION = "Lightweight media scanner meant to be used in not-so-powerful devices"
SECTION = "libs/multimedia"
HOMEPAGE = "http://lms.garage.maemo.org/"
AUTHOR = "Gustavo Barbieri"
LICENSE = "LGPL"
DEPENDS = "sqlite3"
PV = "0.1.0+svnr${SRCREV}"
PE = "1"

SRC_URI = "svn://garage.maemo.org/svn/lms/;module=lightmediascanner;proto=https"
S = "${WORKDIR}/lightmediascanner"

inherit autotools pkgconfig

FILES_${PN}-dbg += "${libdir}/${PN}/plugins/.debug"

do_stage() {
	autotools_stage_all
}

