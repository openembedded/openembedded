LICENSE = "LGPL"
DESCRIPTION = "GPE program launcher library"
SECTION = "libs"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "gtk+ startup-notification"

inherit autotools pkgconfig

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"

do_stage() {
	autotools_stage_all
}
