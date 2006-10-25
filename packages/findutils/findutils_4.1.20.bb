SECTION = "console/utils"
LICENSE = "GPL"
DESCRIPTION = "find, locate, and xargs binaries."
PR = "r3"

SRC_URI = "ftp://alpha.gnu.org/gnu/findutils/findutils-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://make.patch;patch=1"

inherit autotools gettext

# diffutils assumes non-glibc compilation with uclibc and
# this causes it to generate its own implementations of
# standard functionality.  regex.c actually breaks compilation
# because it uses __mempcpy, there are other things (TBD:
# see diffutils.mk in buildroot)
EXTRA_OECONF_linux-uclibc = "--without-included-regex"

do_install_append () {
        mv ${D}${bindir}/find ${D}${bindir}/find.${PN}
        mv ${D}${bindir}/xargs ${D}${bindir}/xargs.${PN}
}

pkg_postinst_${PN} () {
	for i in find xargs; do update-alternatives --install ${bindir}/$i $i $i.${PN} 100; done
}

pkg_prerm_${PN} () {
	for i in find xargs; do update-alternatives --remove $i $i.${PN}; done
}
