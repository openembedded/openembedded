# xfce46.bbclass

# Global class to help maintain XFCE 4.6.* packages

HOMEPAGE = "http://www.xfce.org"
LICENSE = "LGPLv2"

DEPENDS += "startup-notification"

SECTION ?= "x11/xfce"

XFCE_VERSION = ${PV}

SRC_URI = "http://mocha.xfce.org/archive/src/xfce/${PN}/${@'${PV}'[0:3]}/${PN}-${PV}.tar.bz2"

inherit autotools gtk-icon-cache pkgconfig

EXTRA_OECONF += "--with-pluginsdir=${libdir}/xfce4/panel-plugins/"

# FIXME:  Put icons in their own package too?

FILES_${PN} += "${datadir}/icons/* ${datadir}/applications/* ${libdir}/xfce4/modules/*.so*"
FILES_${PN}-doc += "${datadir}/xfce4/doc"

FILES_${PN}-dev += "${libdir}/xfce4/*/*.la"
FILES_${PN}-dbg += "${libdir}/xfce4/*/.debug"
