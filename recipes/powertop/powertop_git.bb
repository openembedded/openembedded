# requires kernel 2.6.31+ headers with perf_event_open syscall
DEFAULT_PREFERENCE = "-1"

require recipes/powertop/powertop.inc

SRCREV = "e9e22ba99bfe0e2f42d52acfd00f434b9d905083"
PV = "1.13"
PR = "${INC_PR}.0"
PR_append = "+gitr${SRCPV}"

SRC_URI = "git://gitorious.org/meego-developer-tools/powertop.git;protocol=git"
S = "${WORKDIR}/git"

CFLAGS += "-DVERSION=\\"${PV}\\" -Wall -Wshadow -W -Wformat -Wimplicit-function-declaration -Wimplicit-int"

do_configure() {
    # We do not build ncurses with wide char support
    sed -i -e "s/lncursesw/lncurses/" ${S}/Makefile
}
