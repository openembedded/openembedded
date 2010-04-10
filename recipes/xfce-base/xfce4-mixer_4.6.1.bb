# xfce-mixer-plugin OE build file

DESCRIPTION="XFCE panel mixer plugin"
DEPENDS="libwnck xfce4-panel"
RDEPENDS="xfce4-panel"
SECTION = "x11"
PR = "r2"

inherit xfce46

SRC_URI = "http://mocha.xfce.org/archive/src/apps/${PN}/${@'${PV}'[0:3]}/${PN}-${PV}.tar.bz2"

FILES_${PN} += "${datadir}/xfce4/panel-plugins/*.desktop"
FILES_${PN} += "${libdir}/xfce4/modules/libxfce4mixer.so"
FILES_${PN}-dbg += "${libexecdir}/xfce4/panel-plugins/.debug/"

SRC_URI[md5sum] = "a99e2455445480ef5081fe69454a46fc"
SRC_URI[sha256sum] = "cf7b8af6696b0e3795ab65d15a8b5d217123955919713f7bae86008b56abb5dd"
