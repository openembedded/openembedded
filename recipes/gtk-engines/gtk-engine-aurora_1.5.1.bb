DESCRIPTION = "GTK aurora engine"
LICENSE = "GPLv2"
SECTION = "x11/base"
DEPENDS = "gtk+ cairo"

inherit gnome

SRC_URI = "http://gnome-look.org/CONTENT/content-files/56438-aurora-1.5.1.tar.bz2;name=archive"

SRC_URI[archive.md5sum] = "5eeea57c5938306ad7ccfc7cd71d009d"
SRC_URI[archive.sha256sum] = "b5853809a83579591644a7bac060bc17ca1fcaa573a530f6cfa312a2073ef9f8"

S = "${WORKDIR}/aurora-1.5"

do_configure_prepend() {
	tar zxvf ${WORKDIR}/aurora-gtk-engine-1.5.tar.gz -C ${WORKDIR}
}

FILES_${PN} += "${datadir}/gtk-engines ${libdir}/gtk-2.0/*/engines/*.so"
