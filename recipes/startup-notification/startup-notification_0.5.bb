DESCRIPTION = "Startup notification support"
LICENSE = "LGPL"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11"

inherit autotools pkgconfig

SRC_URI = "http://www.freedesktop.org/software/startup-notification/releases/startup-notification-${PV}.tar.gz"

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "c7a96f4615b07ed847061b0a9a0be989"
SRC_URI[sha256sum] = "7d2f388f7b50fc5c929ef173c2df900c588329ab07c16184dee3745a26ac54ae"
#CHECKSUMS.INI MISMATCH: I've got this instead:
#SRC_URI[md5sum] = "6ff189db7682999018ed0a9d7de65fc8"
#SRC_URI[sha256sum] = "e27dfb11425c900f3703e611359c6b61c522216a396d7ecaac8232203848312b"
