DESCRIPTION = "Perl is a popular scripting language."
HOMEPAGE = "http://www.perl.org/"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
DEPENDS = "virtual/db-native gdbm-native"
PR = "r6"
NATIVE_INSTALL_WORKS = "1"

# Not tested enough
DEFAULT_PREFERENCE = "-1"

# 5.10.1 has this module built-in
PROVIDES += "libmodule-build-perl-native"
RPROVIDES_${PN} += "libmodule-build-perl-native"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/perl-${PV}"

SRC_URI = "http://ftp.funet.fi/pub/CPAN/src/perl-${PV}.tar.gz;name=perl-${PV} \
           file://CPAN-Config.pm \
           file://Configure-multilib.patch \
           file://perl-configpm-switch.patch \
           file://native-nopacklist.patch \
           file://native-perlinc.patch \
	   "

SRC_URI[perl-5.10.1.md5sum] = "b9b2fdb957f50ada62d73f43ee75d044"
SRC_URI[perl-5.10.1.sha256sum] = "cb7f26ea4b2b28d6644354d87a269d01cac1b635287dae64e88eeafa24b44f35"

S = "${WORKDIR}/perl-${PV}"

inherit native

do_configure () {
    ./Configure \
        -Dcc="${CC}" \
        -Dcflags="${CFLAGS}" \
        -Dldflags="${LDFLAGS}" \
        -Dcf_by="Open Embedded" \
        -Dprefix=${prefix} \
        -Dvendorprefix=${prefix} \
        -Dvendorprefix=${prefix} \
        -Dsiteprefix=${prefix} \
        \
        -Dprivlib=${STAGING_LIBDIR}/perl/${PV} \
        -Darchlib=${STAGING_LIBDIR}/perl/${PV} \
        -Dvendorlib=${STAGING_LIBDIR}/perl/${PV} \
        -Dvendorarch=${STAGING_LIBDIR}/perl/${PV} \
        -Dsitelib=${STAGING_LIBDIR}/perl/${PV} \
        -Dsitearch=${STAGING_LIBDIR}/perl/${PV} \
        \
        -Duseshrplib \
        -Dusethreads \
        -Duseithreads \
        -Duselargefiles \
	-Dnoextensions=ODBM_File \
        -Ud_dosuid \
        -Ui_db \
        -Ui_ndbm \
        -Ui_gdbm \
        -Di_shadow \
        -Di_syslog \
        -Duseperlio \
        -Dman3ext=3pm \
        -Uafs \
        -Ud_csh \
        -Uusesfio \
        -Uusenm -des
    sed "s!${STAGING_DIR}/bin!${STAGING_BINDIR}!;
         s!${STAGING_DIR}/lib!${STAGING_LIBDIR}!;
	 s!^installbin=.*!installbin=\'${STAGING_BINDIR}\'!;
	 s!^installsitebin=.*!installsitebin=\'${STAGING_BINDIR}\'!" < config.sh > config.sh.new
    mv config.sh.new config.sh
}

do_install() {
	oe_runmake DESTDIR="${D}" install.perl

        # We need a hostperl link for building perl
        ln -sf perl${PV} ${D}${bindir}/hostperl
        # Store native config in non-versioned directory
        install -d ${D}${libdir}/perl/${PV}/CORE \
                   ${D}${datadir}/perl/${PV}/ExtUtils
        install config.sh ${D}${libdir}/perl
	# target configuration
        install lib/Config.pm       ${D}${libdir}/perl/${PV}/
	install lib/ExtUtils/xsubpp ${D}${datadir}/perl/${PV}/ExtUtils/
	install lib/ExtUtils/typemap ${D}${datadir}/perl/${PV}/ExtUtils/
        # perl shared library headers
        for i in av.h embed.h gv.h keywords.h op.h perlio.h pp.h regexp.h \
                 uconfig.h XSUB.h cc_runtime.h embedvar.h handy.h opnames.h \
                 perliol.h pp_proto.h regnodes.h unixish.h config.h EXTERN.h \
                 hv.h malloc_ctl.h pad.h perlsdio.h proto.h scope.h utf8.h \
                 cop.h fakesdio.h INTERN.h mg.h patchlevel.h perlsfio.h \
                 reentr.h sv.h utfebcdic.h cv.h fakethr.h intrpvar.h \
                 nostdio.h overload.h parser.h perlapi.h perlvars.h util.h \
                 dosish.h form.h iperlsys.h opcode.h perl.h perly.h regcomp.h \
                 thread.h warnings.h; do
            install $i ${D}${libdir}/perl/${PV}/CORE
        done
        # Make sure CPAN is configured
        sed -e "s,@SYSROOTBASE@,${base_prefix}," ${WORKDIR}/CPAN-Config.pm > \
                 ${D}${libdir}/perl/${PV}/CPAN/Config.pm

	# Fix Errno.pm for target builds
	sed -i -r "s,^\tdie\ (\"Errno\ architecture.+)$,\twarn\ \1," ${D}${libdir}/perl/${PV}/Errno.pm

	# Make sure we use /usr/bin/env perl
	for PERLSCRIPT in `grep -rIl ${bindir}/perl ${D}${bindir}`; do
		sed -i -e 's|^#!${bindir}/perl|#!/usr/bin/env perl|' $PERLSCRIPT
	done
}

do_install_append_nylon() {
        # get rid of definitions not supported by the gcc version we use for nylon...
        for i in ${D}${libdir}/perl/${PV}/Config_heavy.pl ${D}${libdir}/perl/config.sh; do
                perl -pi -e 's/-Wdeclaration-after-statement //g' ${i}
        done
}

PARALLEL_MAKE = ""
