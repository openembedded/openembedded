PR = "${INC_PR}.0"

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

SRC_URI[md5sum] = "e6051f1e1487ec0ebfdbda72bedc70ad"
SRC_URI[sha256sum] = "69044b87c517b986dbc17a5f7e4de430cb56e605330c19c6bb0d384d5c37e638"
