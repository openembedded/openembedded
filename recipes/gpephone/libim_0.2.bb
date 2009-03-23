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
