DESCRIPTION = "The Lemon Parser Generator"
HOMEPAGE = "http://www.hwaci.com/sw/lemon/"
LICENSE = "PD"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PRIORITY = "optional"
SECTION = "devel"

SRC_URI = "http://www.sqlite.org/cvstrac/getfile/sqlite/tool/lemon.c \
	   file://snprintf.patch;patch=1;pnum=0 \
	   http://www.sqlite.org/cvstrac/getfile/sqlite/tool/lempar.c \
	   http://www.hwaci.com/sw/lemon/lemon.html \
	   file://lemon.1"
S = "${WORKDIR}"

do_compile () {
	${CC} ${CFLAGS} lemon.c -c -o lemon.o
	${CCLD} ${LDFLAGS} lemon.o -o lemon
}
