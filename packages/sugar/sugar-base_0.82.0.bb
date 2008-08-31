DESCRIPTION = "Sugar base system"
LICENSE = "LGPLv2"

PR = "r7"

DEPENDS = "python-pygtk sugar-toolkit"
RDEPENDS = "librsvg-gtk \
            ohm-plugin-x11 ohm \
	    hippo-canvas \
            python-datetime \
            python-netclient \
	    python-pygtk \
	    sugar-toolkit \
	    python-logging \
	    python-dbus \
	    python-subprocess \
	    telepathy-gabble telepathy-salut telepathy-python \
	    python-crypt \
	    python-numpy \
	    python-compression \
	    python-gst \
	    python-simplejson \
	    python-misc \
	    python-xmlrpc \
	    "

SRC_URI = "http://dev.laptop.org/pub/sugar/sources/sugar-base/${PN}-${PV}.tar.bz2"

inherit autotools distutils-base


FILES_${PN} += "${datadir}/${PN} \
		${datadir}/dbus-1 \
		${sysconfdir} "

FILES_${PN}-dbg += "${libdir}/python*/site-packages/sugar/.debug"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}

