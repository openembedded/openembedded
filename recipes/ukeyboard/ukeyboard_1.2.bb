DESCRIPTION = "Additional keyboard layouts for Nokia N800/N810"
SECTION = "user/other"
DEPENDS = "gtk+ libosso gconf hildon-control-panel"

SRC_URI = "http://upir.cz/maemo/dists/chinook/main/source/ukeyboard_${PV}.tar.gz "

do_install() {
    oe_runmake install DESTDIR=${D}
}

FILES_${PN} += "${datadir}/X11/xkb \
                ${datadir}/scv_layouts \
		${libdir}/hildon-control-panel/libukeyboard-prefs.so"
FILES_${PN}-dbg += "${libdir}/hildon-control-panel/.debug/"
