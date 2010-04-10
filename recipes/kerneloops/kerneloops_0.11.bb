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


SRC_URI[md5sum] = "a0daa9437f0638912a91afe66f51545b"
SRC_URI[sha256sum] = "2f23a1a2f1b928b2ad44f13a98c704c3d7abd5e3c7157f6a8915acc74c8dcd71"
