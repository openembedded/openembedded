DESCRIPTION = "X driver"
HOMEPAGE = "http://www.x.org"
SECTION = "x11/drivers"
#MAINTAINER = ""
LICENSE = "MIT-X"

DEPENDS = "randrproto xorg-server xproto"

XORG_PN = "${PN}"
SRC_URI = "${XORG_MIRROR}/${@bb.data.getVar('PV', d, 1)[0:7]}/src/driver/${XORG_PN}-${PV}.tar.gz"

S = "${WORKDIR}/${XORG_PN}-${PV}"

FILES_${PN} += " ${libdir}/xorg/modules"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

# Another sucky behavor from Xorg configure scripts.
# They use AC_CHECK_FILE to check for DRI headers. Yuck!
# Of course this will blow up when cross compiling.

do_configure_prepend() {
	incdir=${STAGING_INCDIR}/xorg
	for f in dri.h sarea.h dristruct.h exa.h; do
		path="$incdir/$f"
		if [ -f "$path" ]; then
			p=`echo "$path" | sed 'y%*+%pp%;s%[^_[:alnum:]]%_%g'`
			eval "export ac_cv_file_$p=yes"
		fi
	done
}

# FIXME: We don't want to include the libtool archives (*.la) from modules
# directory, as they serve no useful purpose. Upstream should fix Makefile.am
do_install_append() {
	find ${D}${libdir}/xorg/modules -regex ".*\.la$" | xargs rm -f --
}

