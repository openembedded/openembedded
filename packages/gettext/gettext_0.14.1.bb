DESCRIPTION = "The GNU internationalization library."
HOMEPAGE = "http://www.gnu.org/software/gettext/gettext.html"
SECTION = "libs"
LICENSE = "GPL"
PR = "r9"
DEPENDS = "virtual/libiconv"
PROVIDES = "virtual/libintl"

SRC_URI = "${GNU_MIRROR}/gettext/gettext-${PV}.tar.gz \
	   file://gettext-vpath.patch;patch=1;pnum=1 \
	   file://fixchicken.patch;patch=1;pnum=1 \
	   file://linklib_from_0.17.patch;patch=1 \
           file://getline.m4.patch;patch=1 \
           file://disable_java.patch;patch=1"

SRC_URI_append_linux-uclibc = " file://gettext-error_print_progname.patch;patch=1"
SRC_URI_append_linux-uclibcgnueabi = " file://gettext-error_print_progname.patch;patch=1"

PARALLEL_MAKE = ""

inherit autotools

EXTRA_OECONF += "--without-lisp --disable-csharp"
acpaths = '-I ${S}/autoconf-lib-link/m4/ \
	   -I ${S}/gettext-runtime/m4 \
	   -I ${S}/gettext-tools/m4'

do_configure_prepend() {
	rm -f ${S}/config/m4/libtool.m4
	install -m 0644 ${STAGING_DATADIR}/aclocal/libtool.m4 ${S}/config/m4/
}

# these lack the .x behind the .so, but shouldn't be in the -dev package
# Otherwise you get the following results:
# 7.4M    glibc/images/ep93xx/Angstrom-console-image-glibc-ipk-2008.1-test-20080104-ep93xx.rootfs.tar.gz
# 25M     uclibc/images/ep93xx/Angstrom-console-image-uclibc-ipk-2008.1-test-20080104-ep93xx.rootfs.tar.gz
# because gettext depends on gettext-dev, which pulls in more -dev packages:
# 15228   KiB /ep93xx/libstdc++-dev_4.2.2-r2_ep93xx.ipk
# 1300    KiB /ep93xx/uclibc-dev_0.9.29-r8_ep93xx.ipk
# 140     KiB /armv4t/gettext-dev_0.14.1-r6_armv4t.ipk
# 4       KiB /ep93xx/libgcc-s-dev_4.2.2-r2_ep93xx.ipk

PACKAGES =+ "libgettextlib libgettextsrc"
FILES_libgettextlib = "${libdir}/libgettextlib-*.so*"
FILES_libgettextsrc = "${libdir}/libgettextsrc-*.so*"

do_stage () {
	autotools_stage_all
}
