PR = "r2"
LICENSE= "MIT"
DESCRIPTION = "X Server Nokia 770 extensions library"
SECTION = "x11/libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 libxext xpext"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/x/xsp/${PN}_${PV}.tar.gz \
           file://xsp-fix-pc.patch;patch=1"
S = "${WORKDIR}/Xsp"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "2a0d8d02228d4cbd28b6e07bb7c17cf5"
SRC_URI[sha256sum] = "8b722b952b64841d996c70c3278499886c81bb5012991beed5f66f4158418f59"
