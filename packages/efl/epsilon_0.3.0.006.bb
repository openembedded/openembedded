DESCRIPTION = "Epsilon is a flexable and powerful image thumbnailing library \
that is complient with the freedesktop.org Thumbnail Managing Standard."
LICENSE = "GPL"
DEPENDS = "virtual/imlib2 epeg libpng virtual/evas virtual/ecore perl-native edje"

inherit efl

SRC_URI += "file://compile-fix.patch;patch=1 \
            ${E_CVS};module=e17/libs/epsilon/m4;date=20060101"

do_configure_prepend() {
	install -d "${S}/m4"
	install "${WORKDIR}/m4/"*.m4 "${S}/m4"
	aclocal -I m4
}
