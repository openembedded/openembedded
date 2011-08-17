DESCRIPTION = "Lightweight media scanner meant to be used in not-so-powerful devices"
AUTHOR = "ProFUSION"
HOMEPAGE = "http://lms.garage.maemo.org/"
SECTION = "libs/multimedia"
LICENSE = "LGPLv2.1+"
DEPENDS = "sqlite3"

PE = "1"
PR = "r3"

SRC_URI = "https://garage.maemo.org/frs/download.php/4626/lightmediascanner-${PV}.tar.bz2"

inherit autotools pkgconfig

FILES_${PN}-dbg += "${libdir}/${PN}/plugins/.debug"

SRC_URI[md5sum] = "ee1494b6dff3a50be64a3266819056d5"
SRC_URI[sha256sum] = "98f980e8971fa4d04a589215c3b90d2eaf317ed70fd0d4988089e0fe5808c853"
