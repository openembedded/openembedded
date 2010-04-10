DESCRIPTION = "Replacement syslog API"
LICENSE = "BSD"
PR = "r1"

SRC_URI = "http://www.balabit.com/downloads/files/eventlog/0.2/${P}.tar.gz"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "a6bdba91f88540cc69b398fd138d86cd"
SRC_URI[sha256sum] = "914319726bcd01a4055b1c5e09671085875af6de2b0d8589841916139574ee11"
