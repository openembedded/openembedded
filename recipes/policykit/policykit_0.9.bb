HOMEPAGE = "http://www.packagekit.org/"
DEPENDS = "libpam expat dbus-glib"

PR = "r3"

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

pkg_postinst_${PN} () {
    # can't do this offline
    if [ "x$D" != "x" ]; then
        exit 1
    fi
    grep "^polkituser:" /etc/group > /dev/null || addgroup polkituser
    grep "^polkituser:" /etc/passwd > /dev/null || adduser --disabled-password --system --home /var/run/polkit polkituser --ingroup polkituser -g polkituser 
    DBUSPID=`pidof dbus-daemon`
    if [ "x$DBUSPID" != "x" ]; then
        /etc/init.d/dbus-1 force-reload
    fi
}

pkg_postrm_${PN} () {
    deluser polkituser || true
    delgroup polkituser || true
}
