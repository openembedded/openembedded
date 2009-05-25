PR = "${INC_PR}.1"

SRC_URI = " \
	${GNU_MIRROR}/wget/wget-${PV}.tar.gz \
	file://m4macros.patch;patch=1 \
	file://autotools.patch;patch=1 \
        file://ipv6-fix.patch;patch=1 \
"

S = "${WORKDIR}/wget-${PV}"

do_configure_prepend () {
	if [ ! -e acinclude.m4 ]; then
		mv aclocal.m4 acinclude.m4
	fi
	rm -f libtool.m4
}

require wget.inc
