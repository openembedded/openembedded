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

SRC_URI[md5sum] = "ee1494b6dff3a50be64a3266819056d5"
SRC_URI[sha256sum] = "98f980e8971fa4d04a589215c3b90d2eaf317ed70fd0d4988089e0fe5808c853"
