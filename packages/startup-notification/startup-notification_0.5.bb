DESCRIPTION = "Startup notification support"
LICENSE = "LGPL"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11"

inherit autotools pkgconfig

SRC_URI = "http://freedesktop.org/Software/startup-notification/releases/startup-notification-${PV}.tar.gz"

do_stage () {
	autotools_stage_all
}
