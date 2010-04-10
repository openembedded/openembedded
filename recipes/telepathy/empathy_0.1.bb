DESCRIPTION = "Empathy: a Telepathy based IM client"
HOMEPAGE = "http://blogs.gnome.org/view/xclaesse/2007/04/26/0"
LICENSE = "GPL"
DEPENDS = "telepathy-mission-control libtelepathy gtk+ gconf libglade"
RDEPENDS = "telepathy-mission-control"
RRECOMMENDS = "telepathy-gabble"

PR ="r1"

SRC_URI = "http://projects.collabora.co.uk/~xclaesse/empathy-0.1.tar.gz \
        file://no-gnome.diff;patch=1"

inherit autotools pkgconfig

FILES_${PN} += "/usr/share/mission-control/profiles/*.profile \
        /usr/share/dbus-1/services/*.service \
        /usr/share/telepathy/managers/*.chandler"

SRC_URI[md5sum] = "46ebd3c4bc873add9dedea15b0a69a8f"
SRC_URI[sha256sum] = "d54b101f29b6a3e36a5f905d5b95d1d7515fa888683e891f975de2702b510045"
