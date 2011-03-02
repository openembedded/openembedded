HOMEPAGE = "http://www.packagekit.org/"
DEPENDS = "policykit libgnome"
PR = "r0"

inherit autotools pkgconfig gnome

SRC_URI = "http://hal.freedesktop.org/releases/polkit-gnome-${PV}.tar.bz2"
SRC_URI[md5sum] = "0554fe631e923ed560d65b60661cbbe1"
SRC_URI[sha256sum] = "d52bbcf6cdb7b0be499e6b220653dccaf0fed860806bdfd8112ef1fd1c26653d"

EXTRA_OECONF = " --disable-man-pages \
                 --disable-examples \
                 --disable-gtk-doc \
"

S = "${WORKDIR}/polkit-gnome-${PV}"

FILES_${PN} += " ${datadir}/dbus-1 \
                 ${datadir}/PolicyKit \
               "
