DESCRIPTION = "Provides a unified high level API for communicating with (mobile broadband) modems"
LICENSE = "GPLv2"
DEPENDS = "udev dbus-glib policykit ppp"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/ModemManager/0.4/ModemManager-${PV}.tar.bz2;name=archive \
           file://glibfix.diff \
"
SRC_URI[archive.md5sum] = "d4681f08e76cbb766522256144267ced"
SRC_URI[archive.sha256sum] = "8b5415ae8597726f82e9fd09237c02b5c8af7e9f4fc4cba00f9fe183cc2c6c5f"

S = "${WORKDIR}/ModemManager-${PV}"

inherit autotools

FILES_${PN} += "${libdir}/ModemManager/*.so \
                ${libdir}/pppd/*/*.so \
                /lib/udev \
                ${datadir}/dbus-1/ \
                ${datadir}/icons/ \
                ${datadir}/polkit-1 \
"

FILES_${PN}-dbg += "${libdir}/ModemManager/.debug \
                    ${libdir}/pppd/*/.debug"

FILES_${PN}-dev += "${libdir}/ModemManager/*a \
                    ${libdir}/pppd/*/*a \
"

RRECOMMENDS_${PN} = "ppp"

