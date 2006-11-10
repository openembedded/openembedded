SECTION = "x11/utils"
DEPENDS = "gtk+ glib-2.0 gnome-vfs-dbus libgnomeui eds-dbus libiconv"
DESCRIPTION = "TinyMail is an attempt to create an E-mail framework for mobile devices"
LICENSE = "GPL"

PV = "0.0+svn${SRCDATE}"
PR = "r1"

EXTRA_OECONF=" --disable-gnome --with-platform=gpe --with-html-component=none"

SRC_URI = "svn://svn.tinymail.org/svn/tinymail/;module=trunk;proto=https \
           file://gtk-doc.m4 \
           file://gtk-doc.make"

inherit pkgconfig autotools
S = "${WORKDIR}/trunk"

do_configure_prepend() {
        mkdir -p m4
        install ${WORKDIR}/gtk-doc.m4 ./m4/
        install ${WORKDIR}/gtk-doc.make ./
}

PARALLEL_MAKE = ""
LDFLAGS += "-liconv"


