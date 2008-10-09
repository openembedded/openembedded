DESCRIPTION = "Framebuffer splash utilities."
SECTION = "media-gfx"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://dev.gentoo.org/~spock/projects/gensplash/archive/splashutils-${PV}.tar.bz2"

DEPENDS = "jpeg klibc"

inherit autotools

PARALLEL_MAKE = ""

# klcc doesn't work with -isystem
export TARGET_CPPFLAGS = "-I${STAGING_DIR_TARGET}/${layout_includedir}"
export BUILD_CPPFLAGS = "-I${STAGING_DIR_NATIVE}${layout_includedir}"

do_configure_prepend() {
	if [ -f "${S}"/src/Makefile.am ] ; then
		sed -i "s#^INCLUDES = \(.*\)#INCLUDES = \1 $CPPFLAGS#" "${S}"/src/Makefile.am
	fi
}

EXTRA_OECONF = "--without-gpm --without-png --without-mng --without-ttf --without-ttf-kernel"

# fbcondecor_helper is also useful outside of the main package.
RDEPENDS_${PN} = "${PN}-helper"

PACKAGES =+ "${PN}-helper"
FILES_${PN}-helper = "${base_sbindir}/fbcondecor_helper ${base_sbindir}/splash_helper"
FILES_${PN} += "/lib"

do_install_append () {
	if [ -f "${S}"/debian/splashutils.dirs ] ; then
		for dir in $(cat debian/splashutils.dirs) ; do
			mkdir -p ${D}/$dir
		done
	fi

	ln -s fbcondecor_helper ${D}${base_sbindir}/splash_helper

}
