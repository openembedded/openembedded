DESCRIPTION = "Argp is an interface for parsing unix-style argument vectors. This is only needed for uclibc"
PRIORITY = "optional"

SRC_URI = "http://www.auto.tuwien.ac.at/~mkoegler/eib/argp-standalone-${PV}.tar.gz"

inherit autotools

do_stage() {
        autotools_stage_all
}

SRC_URI[md5sum] = "8a336796eeb2a765b76f68e3312adaab"
SRC_URI[sha256sum] = "8b9067e77812c67c1e1b96ab9d92ab9af3a97e991d3c385b6e241d97f0e3cd28"
