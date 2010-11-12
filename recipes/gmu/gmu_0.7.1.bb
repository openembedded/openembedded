DESCRIPTION = "Gmu is a music player for portable handheld consoles."
HOMEPAGE = "http://wejp.k.vu/projects/gmu/"
LICENSE = "GPLv2"
PR = "r0"

DEPENDS = "virtual/libsdl libsdl-image libsdl-gfx tremor flac mpg123"

SRC_URI = "http://wejp.k.vu/files/gmu-${PV}.tar.gz \
	   file://nanonote-lcd-blank.patch \
	   file://set-base-dir.patch \
	   file://gmu.desktop \
	   file://unknown.mk \
	   file://Makefile"

SRC_URI_append_ben-nanonote = " file://nanonote.mk file://nanonote.keymap "

FILES_${PN}-dbg += " /usr/lib/gmu/frontends/.debug/ "
CONFFILES_${PN} = "/etc/gmu/gmu.conf /etc/gmu/gmuinput.conf /etc/gmu/default.keymap"

do_configure() {
	mv ${WORKDIR}/Makefile ${S}/Makefile
	mv ${WORKDIR}/unknown.mk ${S}/unknown.mk
	mv ${S}/gmu.unknown.conf ${S}/gmu.conf
	mv ${S}/gmuinput.unknown.conf ${S}/gmuinput.conf
	sed -i 's/gmuinput.unknown.conf/gmuinput.conf/g' ${S}/gmu.conf
}

do_configure_ben-nanonote() {
	mv ${WORKDIR}/Makefile ${S}/Makefile
	mv ${WORKDIR}/nanonote.mk ${S}/nanonote.mk
	mv ${WORKDIR}/nanonote.keymap ${S}/default.keymap
	mv ${S}/gmu.nanonote.conf ${S}/gmu.conf
	mv ${S}/gmuinput.nanonote.conf ${S}/gmuinput.conf
	sed -i 's/gmuinput.nanonote.conf/gmuinput.conf/g' ${S}/gmu.conf
	sed -i 's/nanonote.keymap/default.keymap/g' ${S}/gmu.conf
}

do_compile_prepend_ben-nanonote() {
	export TARGET=nanonote
}

do_install() {
	oe_runmake install DESTDIR=${D}
	install -d ${D}${datadir}/applications
	install -m 0755 ${WORKDIR}/gmu.desktop ${D}${datadir}/applications
}

SRC_URI[md5sum] = "62653037d2046d992626eaf6d0a365e3"
SRC_URI[sha256sum] = "9b075a191a8d7fb09164d14ffa489af883b1fae51f579bec95c9c8d8d4758545"
