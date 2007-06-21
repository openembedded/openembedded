DESCRIPTION = "Epsilon is a flexable and powerful image thumbnailing library \
that is complient with the freedesktop.org Thumbnail Managing Standard."
LICENSE = "GPL"
DEPENDS = "imlib2 epeg libpng evas ecore edje perl-native"
PR = "r0"

inherit efl1

#SRC_URI += "file://compile-fix.patch;patch=1 \
#            ${E_CVS};module=e17/libs/epsilon/m4;date=20060101"
#            file://server-is-not-client.patch;patch=1 \

#do_configure_prepend() {
#	install -d "${S}/m4"
#	install "${WORKDIR}/m4/"*.m4 "${S}/m4"
#	aclocal -I m4
#}
