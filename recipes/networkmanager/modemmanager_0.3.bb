DESCRIPTION = "Provides a unified high level API for communicating with (mobile broadband) modems"
LICENSE = "GPLv2"
DEPENDS = "udev dbus-glib policykit ppp"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/ModemManager/0.3/ModemManager-${PV}.tar.bz2;name=archive"

SRC_URI[archive.md5sum] = "c617210a9e388841b8aa782cdd9b48a0"
SRC_URI[archive.sha256sum] = "6bcfce70a26ed9c3162ba23fd0591029441c57e146d7ff4b2fd8036eb50945da"

S = "${WORKDIR}/ModemManager-${PV}"

inherit autotools

FILES_${PN} += "${libdir}/ModemManager/*.so \
                ${libdir}/pppd/*/*.so \
                /lib/udev \
                ${datadir}/dbus-1/ \
"

FILES_${PN}-dbg += "${libdir}/ModemManager/.debug \
                    ${libdir}/pppd/*/.debug"

FILES_${PN}-dev += "${libdir}/ModemManager/*a \
                    ${libdir}/pppd/*/*a \
"

RRECOMMENDS_${PN} = "ppp"

