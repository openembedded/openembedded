LICENSE     = "LGPL"
DESCRIPTION = "LiPS instant messenger library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 libgpg-error libgcrypt gnutls libidn iksemel gloox dbus-glib liblipsevent"
PR          = "r1"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_MIRROR}/${P}/lips_im-${PV}.tar.gz"

EXTRA_OECONF = "--with-session-bus-services-dir=${datadir}/dbus-1/services"

PARALLEL_MAKE = ""

S = ${WORKDIR}/lips_im-${PV}

FILES_${PN} += " ${datadir}/dbus-1"

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "375091bb5df956f0049962defad3cbbc"
SRC_URI[sha256sum] = "381d88261fa307ffa97edab6ba8488533b9fb45cccc5ae6cda5ccb64ef65adc0"
