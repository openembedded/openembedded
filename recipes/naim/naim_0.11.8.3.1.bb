DESCRIPTION = "A console AIM/IRC/ICQ and Lily client"
SECTION = "console/apps"
LICENSE = "GPL"
DEPENDS = "ncurses"

SRC_URI = "http://naim.googlecode.com/files/naim-0.11.8.3.1.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "239f8865b6f044aed26e3124a0721652"
SRC_URI[sha256sum] = "a629efbd182552712009b0636c7b8be0c190052a3303c8de66a3649a9df4f224"
