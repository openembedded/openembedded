DESCRIPTION = "Abuse-SDL is a port of Abuse by Crack Dot Com to Linux - SDL edition."
SECTION = "games"
LICENSE = "GPLv2"
HOMEPAGE = "http://abuse.zoy.org/"
APPIMAGE = "${S}/${PN}.png"

PR="r0"

inherit autotools sdl

SRC_URI = "http://abuse.zoy.org/raw-attachment/wiki/Downloads/${P}.tar.gz \
           file://no-host-libdir.patch;apply=yes \
          "

EXTRA_OECONF = " --x-libraries=${STAGING_LIBDIR}"

FILES_${PN} += "${datadir}/games"

SRC_URI[md5sum] = "439b607f291560a8f9698a2f09cffa63"
SRC_URI[sha256sum] = "1516a19efc1b89715a8549109a0d87b71502d94fd8b782942e335b6782a1dd57"
