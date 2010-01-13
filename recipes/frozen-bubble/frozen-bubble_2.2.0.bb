DESCRIPTION="A Puzzle Bubble clone written in perl (now with network support)"
LICENSE = "GPL"
SECTION = "games"
DEPENDS = "sdlpango libsdl-mixer perl"
RDEPENDS_${PN} = "${PN}-data perl sdl-perl \
		  perl-module-strict perl-module-vars \
		  perl-module-getopt-long perl-module-exporter-heavy \
		  perl-module-data-dumper \
		  perl-module-bytes liblocale-gettext-perl \
		  perl-module-dynaloader perl-module-posix \
		  perl-module-autoloader perl-module-math-trig \
		  perl-module-io-file perl-module-io \
		  perl-module-file-spec-unix perl-module-time-hires \
		  perl-module-io-socket perl-module-io-select \
		  perl-module-file-glob \
		 "

PR = "r1"

inherit cpan-base

PERL_VERSION = ${@get_perl_version(d)}

SRC_URI = "http://www.frozen-bubble.org/data/frozen-bubble-${PV}.tar.bz2 \
	   file://Makefile.PL.patch;patch=1 \
	   file://Makefile.patch;patch=1 \
	   file://Makefile_top.patch;patch=1 \
	   file://localespath-fix.patch;patch=1 \
	  "

#permit the installation of the locales in ${datadir}/locales otherwise they are installed in /usr/local/share/locales

# The Makefile needs to be patched to look in STAGING_LIBDIR/perl/... - It's looking in i686-linux/lib at the moment, regardless of arch
BROKEN = "1"

do_compile() {
        oe_runmake OPTIMIZE="${CFLAGS}" PREFIX="${prefix}" INSTALLSITELIB="${D}/${libdir}/perl/${PERL_VERSION}/" LOCALEDIR="${datadir}/locale"
}

do_install() {
        oe_runmake PREFIX="${prefix}" DESTDIR="${D}" DATADIR="${datadir}" LOCALEDIR="${datadir}/locale" install 
}

PACKAGES += "${PN}-editor ${PN}-data ${PN}-server"


DESCRIPTION_${PN}-editor = "Map Editor for Frozen Bubble"
DESCRIPTION_${PN}-data = "Mandatory data package for Frozen Bubble"
DESCRIPTION_${PN}-server = "Server for Frozen Bubble"

FILES_${PN} = "\
  ${bindir}/frozen-bubble \
  ${libdir}/perl/${PERL_VERSION}/auto/fb_c_stuff/fb_c_stuff.* \
  ${libdir}/perl/${PERL_VERSION}/fb* \
  ${libdir}/perl/${PERL_VERSION}/perllocal.pod \
  ${libdir}/perl/${PERL_VERSION}/FBLE.pm \
"

FILES_${PN}-dbg += " \
 ${libdir}/perl/${PERL_VERSION}/auto/fb_c_stuff/.debug \
 ${libdir}/${PN}/.debug \
"

FILES_${PN}-editor = "\
  ${bindir}/frozen-bubble-editor \
"

FILES_${PN}-data = "\
  ${datadir}/frozen-bubble \
"

FILES_${PN}-server = " \
 ${libdir}/${PN}/fb-server \
"
