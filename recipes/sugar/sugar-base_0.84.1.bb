DESCRIPTION = "Sugar base system"
LICENSE = "LGPLv2"

DEPENDS = "python-pygtk sugar-toolkit"
RDEPENDS = "librsvg-gtk \
            gconf \
            matchbox-wm \
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
            sugar-presence-service \
            python-pycairo \
            python-pygobject \
            python-crypt \
            python-numpy \
            python-compression \
            python-gst \
            python-simplejson \
            python-misc \
            python-xmlrpc \
            python-compiler \
            python-pydoc \
            python-mmap \
            python-doctest \
            openssh-keygen"

SRC_URI = "http://download.sugarlabs.org/sources/sucrose/glucose/sugar-base/${PN}-${PV}.tar.bz2"

inherit autotools distutils-base

SRC_URI += "file://acinclude.m4"

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

FILES_${PN} += "${datadir}/${PN} \
                ${datadir}/dbus-1 \
                ${sysconfdir} "

FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/sugar/.debug"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}

