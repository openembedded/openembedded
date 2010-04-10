LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "gtk+"
DESCRIPTION = "gcalctool is a powerful calculator"
PR = "r1"

SRC_URI = "http://download.gnome.org/sources/${PN}/5.7/${PN}-${PV}.tar.gz \
        file://makefile-fix.diff;patch=1"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gnome"

SRC_URI[md5sum] = "c4d4234f6951389027399e9c596a8abe"
SRC_URI[sha256sum] = "c232fc4b36d063b714d4470c603f462c9e6ccfcd9fb7c071e08356869376381e"
