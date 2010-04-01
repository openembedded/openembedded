DESCRIPTION = "vte is a virtual terminal emulator"
LICENSE = "LGPL"
DEPENDS += "glib-2.0 gtk+ intltool-native ncurses"

inherit gnome

SRC_URI[archive.md5sum] = "c381f6019448a6e84470ec0acfd78c63"
SRC_URI[archive.sha256sum] = "910348da4c7d4ccb25b8d3820f01461324b47040d04f9425e09c39547c253e59"

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

PACKAGES =+ "libvte vte-termcap gnome-pty-helper"
FILES_libvte = "${libdir}/*.so.*"
FILES_gnome-pty-helper = "${libexecdir}/gnome-pty-helper"
RDEPENDS_libvte = "vte-termcap gnome-pty-helper"
FILES_vte-termcap = "${datadir}/vte/termcap"
