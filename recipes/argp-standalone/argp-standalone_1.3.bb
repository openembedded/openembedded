DESCRIPTION = "Argp is an interface for parsing unix-style argument vectors. This is only needed for uclibc"
PRIORITY = "optional"

SRC_URI = "http://www.auto.tuwien.ac.at/~mkoegler/eib/argp-standalone-${PV}.tar.gz"

inherit autotools

do_stage() {
        autotools_stage_all
}
