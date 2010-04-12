LICENSE     = "LiPS"
DESCRIPTION = "LiPS event model library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0"
PR          = "r1"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_MIRROR}/${P}/lips_event-${PV}.tar.gz"

S = ${WORKDIR}/lips_event-${PV}

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "1fd0f41f9676ef0c882921bc37628d07"
SRC_URI[sha256sum] = "7182cf3f63e11e7ea6c6a994f9e70ef3bf6e430a5db643f5b29a0fd0996ddfd5"
