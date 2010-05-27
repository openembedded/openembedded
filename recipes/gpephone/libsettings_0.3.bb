DESCRIPTION = "G(PE)^2 settings API library"
SECTION = "gpe/libs"
PRIORITY = "required"
LICENSE = "LiPS"
DEPENDS = "glib-2.0 gconf"
PR = "r1"

inherit gpephone pkgconfig autotools

FILES_${PN} += " ${libdir}/*.so.*"
FILES_${PN}-dbg += "${libdir}/.debug/*.so.*"
FILES_${PN}-dev += "${includedir} ${libdir}/*.la ${libdir}/*.so"

do_stage () {
    autotools_stage_all
}

SRC_URI[md5sum] = "9219923ee3f4d465757f23ac0c2be584"
SRC_URI[sha256sum] = "01c4d4bcf893be8f86007280f231985117c16faf15a007bd6ec41624463abf6b"
