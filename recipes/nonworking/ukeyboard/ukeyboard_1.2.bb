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

SRC_URI[md5sum] = "cf291d487250e3e9c1cc34389ce49297"
SRC_URI[sha256sum] = "1f54d52abc5a53db45bc063948375b947af2c031ee1b810686027f7694deb474"
