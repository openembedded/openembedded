require abiword-2.5.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI += " file://cdump.pl "

PR = "r0"

RCONFLICTS = "abiword-embedded"

do_compile_prepend () {
	cp ${WORKDIR}/cdump.pl ${S}/src/tools/cdump/xp/
}

