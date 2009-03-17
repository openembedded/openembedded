DESCRIPTION = "Kernel oops collection utility"
LICENSE = "GPLv2"
DEPENDS = "libnotify dbus gtk+"

SRC_URI = "http://www.kerneloops.org/download/kerneloops-0.11.tar.gz"

do_compile_prepend() {
	sed -i -e 's:gcc:$(CC):g' ${S}/Makefile
}

inherit update-rc.d
INITSCRIPT_NAME = "kerneloops"

do_install() {
	install -d ${D}/${datadir}/applications
	install -d ${D}/${datadir}/icons
	install -d ${D}/${bindir}
	install -d ${D}/${INIT_D_DIR}

	install -m 0755 kerneloops ${D}/${bindir}
	install -m 0755 kerneloops-applet ${D}/${bindir}
	install -m 0644 kerneloops-applet.desktop ${D}/${datadir}/applications
	install -m 0644 icon.png ${D}/${datadir}/icons
	install -m 0755 kerneloops.init ${D}/${INIT_D_DIR}/kerneloops
}

FILES_${PN} += "${datadir}/icons"

