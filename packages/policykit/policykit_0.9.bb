HOMEPAGE = "http://www.packagekit.org/"
DEPENDS = "libpam expat dbus-glib"

SRC_URI = "http://hal.freedesktop.org/releases/PolicyKit-${PV}.tar.gz"

EXTRA_OECONF = "--with-authfw=pam --with-os-type=moblin --disable-man-pages --disable-gtk-doc"

S = "${WORKDIR}/PolicyKit-${PV}"

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}

FILES_${PN} += " ${datadir}/dbus-1 \
                 ${datadir}/PolicyKit \
               "

