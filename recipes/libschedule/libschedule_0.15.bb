LICENSE = "LGPL"
PR = "r3"
DESCRIPTION = "RTC alarm handling library for GPE"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "glib-2.0 sqlite"
GPE_TARBALL_SUFFIX = "gz"

inherit autotools pkgconfig gpe


do_stage () {
autotools_stage_all
}


SRC_URI[md5sum] = "58ac7e5b3d9b0a1b8adf0a57fd265c76"
SRC_URI[sha256sum] = "9b3577052db92ac9282f4912eaa487729de34bf058585cfcbc79478831207889"
