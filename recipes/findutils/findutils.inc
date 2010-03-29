DESCRIPTION = "find, locate, and xargs binaries."
SECTION = "console/utils"
LICENSE = "GPLv3"

SRC_URI = "${GNU_MIRROR}/${BPN}/${BPN}-${PV}.tar.gz;name=archive"

BBCLASSEXTEND = "native"

inherit autotools gettext

INC_PR = "r3"

# diffutils assumes non-glibc compilation with uclibc and
# this causes it to generate its own implementations of
# standard functionality.  regex.c actually breaks compilation
# because it uses __mempcpy, there are other things (TBD:
# see diffutils.mk in buildroot)
EXTRA_OECONF_linux-uclibc += "--without-included-regex"

EXTRA_OEMAKE += "SORT=${bindir}/sort"

do_install_append() {
	cd ${D}${bindir} && mv find find.findutils
	cd ${D}${bindir} && mv xargs xargs.findutils
}
# When staging native package, postinst/prerm is not called and find.findutils is not so usefull in -native
do_install_virtclass-native () {
	autotools_do_install
}

pkg_postinst_${PN} () {
        for i in find xargs; do update-alternatives --install ${bindir}/$i $i $i.${PN} 100; done
}

pkg_prerm_${PN} () {
        for i in find xargs; do update-alternatives --remove $i $i.${PN}; done
}
