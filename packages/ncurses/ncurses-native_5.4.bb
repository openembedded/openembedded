require ncurses_${PV}.bb

inherit native

DEPENDS = ""

EXTRA_OEMAKE = '"BUILD_CCFLAGS=${BUILD_CCFLAGS}"'

FILESPATH = "${FILE_DIRNAME}/local:${FILE_DIRNAME}/ncurses-${PV}-${PR}:${FILE_DIRNAME}/ncurses-${PV}:${FILE_DIRNAME}/ncurses:${FILE_DIRNAME}"

do_install() {
	:
}

