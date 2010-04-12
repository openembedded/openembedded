HOMEPAGE = "http://www.packagekit.org/"
DEPENDS = "policykit libgnome"

SRC_URI = "http://hal.freedesktop.org/releases/PolicyKit-gnome-${PV}.tar.bz2 \
          "

EXTRA_OECONF = " --disable-scrollkeeper \
                 --disable-man-pages \
                 --disable-examples \
                 --disable-gtk-doc"

S = "${WORKDIR}/PolicyKit-gnome-${PV}"

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}

FILES_${PN} += " ${datadir}/dbus-1 \
                 ${datadir}/PolicyKit \
               "


SRC_URI[md5sum] = "fc478b168d0c926a9766b0b415ff4bbf"
SRC_URI[sha256sum] = "ecf4ce303a90a4580c54ee7b932ffaf01b7f115f40b17d75634c5bbfba085c8a"
