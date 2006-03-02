DESCRIPTION = "Startup notification support"
LICENSE = "LGPL"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "libx11"

inherit autotools pkgconfig 

SRC_URI = "http://www.freedesktop.org/software/startup-notification/releases/startup-notification-0.8.tar.gz"

do_stage () {
	autotools_stage_all
}
