DESCRIPTION = "Xdialog is a X11 replacement for the dialog text utility."
LICENSE = "GPL"
DEPENDS = "gtk+-1.2"

PR = "r0"

SRC_URI = "http://xdialog.free.fr/Xdialog-${PV}.tar.bz2 \
	   file://fix-duplicates.patch"

S = "${WORKDIR}/Xdialog-${PV}"

inherit autotools

do_configure() {
	oe_runconf
}

SRC_URI[md5sum] = "0671f8353717513bf1f0ebc80e9710f6"
SRC_URI[sha256sum] = "1d446899697145fc36623d8afdd274066177da9383a6b619c18e8eb1b2ba589a"
