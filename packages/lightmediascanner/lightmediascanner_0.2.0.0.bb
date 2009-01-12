DESCRIPTION = "Lightweight media scanner meant to be used in not-so-powerful devices"
SECTION = "libs/multimedia"
AUTHOR = "Profusion"
LICENSE = "LGPL"
DEPENDS = "sqlite3"
PE = "1"

SRC_URI = "https://garage.maemo.org/frs/download.php/4626/lightmediascanner-0.2.0.0.tar.bz2"

inherit autotools pkgconfig

FILES_${PN}-dbg += "${libdir}/${PN}/plugins/.debug"

do_stage() {
	autotools_stage_all
}
