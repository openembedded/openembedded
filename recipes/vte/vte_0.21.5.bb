DESCRIPTION = "vte is a virtual terminal emulator"
LICENSE = "LGPL"
DEPENDS += "glib-2.0 gtk+ intltool-native ncurses"

inherit gnome

SRC_URI += " \
            file://vte.desktop.in \
           "

EXTRA_OECONF = "--disable-gtk-doc --disable-python"

# Upstream does not provide desktop file for vte considering it only as
# a testing utility.
do_install_append() {
	mkdir -p ${D}${datadir}/applications
	sed s/@VERSION@/${PV}/ <${WORKDIR}/vte.desktop.in >${D}${datadir}/applications/vte.desktop
}

do_configure_prepend() {
	sed -i -e s:docs::g ${S}/Makefile.am
	echo "EXTRA_DIST = version.xml" > gtk-doc.make
}

do_stage() {
	autotools_stage_all
}

PACKAGES =+ "libvte vte-termcap gnome-pty-helper"
FILES_libvte = "${libdir}/*.so.*"
FILES_gnome-pty-helper = "${libexecdir}/gnome-pty-helper"
RDEPENDS_libvte = "vte-termcap gnome-pty-helper"
FILES_vte-termcap = "${datadir}/vte/termcap"
