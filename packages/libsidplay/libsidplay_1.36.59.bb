DESCRIPTION = "A library for replaying C64 SID music"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://www.geocities.com/SiliconValley/Lakes/5147/sidplay/packages/libsidplay-${PV}.tgz"

inherit autotools

do_stage() {
	autotools_stage_all
}
