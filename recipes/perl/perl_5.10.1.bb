DESCRIPTION = "Perl is a popular scripting language."
HOMEPAGE = "http://www.perl.org/"
SECTION = "devel/perl"
LICENSE = "Artistic|GPLv1+"
PRIORITY = "optional"
DEPENDS = "virtual/db perl-native"
PR = "r22"

# 5.10.1 has Module::Build built-in
PROVIDES += "libmodule-build-perl"

# Major part of version
PVM = "5.10"

SRC_URI = "ftp://ftp.funet.fi/pub/CPAN/src/perl-${PV}.tar.gz;name=perl-${PV} \
	file://arm_thread_stress_timeout.diff \
	file://cpan_config_path.diff \
	file://cpan_definstalldirs.diff \
	file://db_file_ver.diff \
	file://doc_info.diff \
	file://enc2xs_inc.diff \
	file://errno_ver.diff \
	file://extutils_hacks.diff \
	file://fakeroot.diff \
	file://instmodsh_doc.diff \
	file://ld_run_path.diff \
	file://libnet_config_path.diff \
	file://m68k_thread_stress.diff \
	file://mod_paths.diff \
	file://module_build_man_extensions.diff \
	file://perl_synopsis.diff \
	file://prune_libs.diff \
	file://use_gdbm.diff \
	file://assorted_docs.diff \
	file://net_smtp_docs.diff \
	file://processPL.diff \
	file://perlivp.diff \
	file://pod2man-index-backslash.diff \
	file://disable-zlib-bundling.diff \
	file://kfreebsd_cppsymbols.diff \
	file://cpanplus_definstalldirs.diff \
	file://cpanplus_config_path.diff \
	file://kfreebsd-filecopy-pipes.diff \
	file://anon-tmpfile-dir.diff \
	file://abstract-sockets.diff \
	file://hurd_cppsymbols.diff \
	file://autodie-flock.diff \
	file://archive-tar-instance-error.diff \
	file://positive-gpos.diff \
	file://devel-ppport-ia64-optim.diff \
	file://trie-logic-match.diff \
	file://hppa-thread-eagain.diff \
	file://crash-on-undefined-destroy.diff \
	file://tainted-errno.diff \
	file://safe-upgrade.diff \
	file://tell-crash.diff \
	file://format-write-crash.diff \
	file://arm-alignment.diff \
	file://fcgi-test.diff \
	file://hurd-ccflags.diff \
	file://perl-time-hires-fix-cross-compilation.patch \
	\
        file://Makefile.patch \
        file://Makefile.SH.patch \
        file://installperl.patch \
        file://perl-dynloader.patch \
        file://perl-moreconfig.patch \
        file://letgcc-find-errno.patch \
        file://generate-sh.patch \
        file://shared-ldflags.patch \
	file://cross-generate_uudmap.patch \
        file://config.sh \
        file://config.sh-32 \
        file://config.sh-32-le \
        file://config.sh-32-be \
        file://config.sh-64 \
        file://config.sh-64-le \
        file://config.sh-64-be \
	file://0001-Find-pthread-libraries.patch \
	"

SRC_URI[perl-5.10.1.md5sum] = "b9b2fdb957f50ada62d73f43ee75d044"
SRC_URI[perl-5.10.1.sha256sum] = "cb7f26ea4b2b28d6644354d87a269d01cac1b635287dae64e88eeafa24b44f35"

inherit siteinfo

# Where to find the native perl
HOSTPERL = "${STAGING_BINDIR_NATIVE}/perl${PV}"

# Where to find .so files - use the -native versions not those from the target build
export PERLHOSTLIB = "${STAGING_LIBDIR_NATIVE}/perl/${PV}/"

# LDFLAGS for shared libraries
export LDDLFLAGS = "${LDFLAGS} -shared"

# We're almost Debian, aren't we?
CFLAGS += "-DDEBIAN"

do_nolargefile() {
	sed -i -e "s,\(uselargefiles=\)'define',\1'undef',g" \
		-e "s,\(d_readdir64_r=\)'define',\1'undef',g" \
		-e "s,\(readdir64_r_proto=\)'\w+',\1'0',g" \
		-e "/ccflags_uselargefiles/d" \
		-e "s/-Duselargefiles//" \
		-e "s/-D_FILE_OFFSET_BITS=64//" \
		-e "s/-D_LARGEFILE_SOURCE//" \
		${S}/Cross/config.sh-${TARGET_ARCH}-${TARGET_OS}
}

do_configure() {
        # Make hostperl in build directory be the native perl
        ln -sf ${HOSTPERL} hostperl

        # Do out work in the cross subdir
        cd Cross

        # Generate configuration
        rm -f config.sh-${TARGET_ARCH}-${TARGET_OS}
        for i in ${WORKDIR}/config.sh \
                 ${WORKDIR}/config.sh-${SITEINFO_BITS} \
                 ${WORKDIR}/config.sh-${SITEINFO_BITS}-${SITEINFO_ENDIANNESS}; do
            cat $i >> config.sh-${TARGET_ARCH}-${TARGET_OS}
        done

        # Fixups for uclibc
        if [ "${TARGET_OS}" = "linux-uclibc" -o "${TARGET_OS}" = "linux-uclibceabi" -o "${TARGET_OS}" = "linux-uclibcspe" ]; then
                sed -i -e "s,\(d_crypt_r=\)'define',\1'undef',g" \
                       -e "s,\(d_futimes=\)'define',\1'undef',g" \
                       -e "s,\(crypt_r_proto=\)'\w+',\1'0',g" \
                       -e "s,\(d_getnetbyname_r=\)'define',\1'undef',g" \
                       -e "s,\(getnetbyname_r_proto=\)'\w+',\1'0',g" \
                       -e "s,\(d_getnetbyaddr_r=\)'define',\1'undef',g" \
                       -e "s,\(getnetbyaddr_r_proto=\)'\w+',\1'0',g" \
                       -e "s,\(d_getnetent_r=\)'define',\1'undef',g" \
                       -e "s,\(getnetent_r_proto=\)'\w+',\1'0',g" \
                       -e "s,\(d_sockatmark=\)'define',\1'undef',g" \
                       -e "s,\(d_sockatmarkproto=\)'\w+',\1'0',g" \
                    config.sh-${TARGET_ARCH}-${TARGET_OS}
        fi

	${@base_contains('DISTRO_FEATURES', 'largefile', '', 'do_nolargefile', d)}

        # Update some paths in the configuration
        sed -i -e 's,@DESTDIR@,${D},g' \
               -e 's,@ARCH@,${TARGET_ARCH}-${TARGET_OS},g' \
               -e "s%/usr/include/%${STAGING_INCDIR}/%g" \
	       -e 's,/usr/,${exec_prefix}/,g' \
            config.sh-${TARGET_ARCH}-${TARGET_OS}

	case "${TARGET_ARCH}" in
		x86_64 | powerpc | s390)
			sed -i -e "s,\(need_va_copy=\)'undef',\1'define',g" \
				config.sh-${TARGET_ARCH}-${TARGET_OS}
			;;
		arm)
			sed -i -e "s,\(d_u32align=\)'undef',\1'define',g" \
				config.sh-${TARGET_ARCH}-${TARGET_OS}
			;;
	esac

        # These are strewn all over the source tree
        for foo in `grep -lrI -m1 \/usr\/include\/.*\\.h ${WORKDIR}/*` ; do
            echo Fixing: $foo
            sed -e "s%/usr/include/%${STAGING_INCDIR}/%g" -i $foo
        done

        rm -f config
        echo "ARCH = ${TARGET_ARCH}" > config
        echo "OS = ${TARGET_OS}" >> config
}
do_compile() {
        sed -i -e 's|/usr/include|${STAGING_INCDIR}|g' ext/Errno/Errno_pm.PL
        cd Cross
        oe_runmake perl LD="${CCLD}"
}
do_install() {
	oe_runmake install
        # Add perl pointing at current version
        ln -sf perl${PV} ${D}${bindir}/perl

        # Fix up versioned directories
        mv ${D}/${libdir}/perl/${PVM} ${D}/${libdir}/perl/${PV}
        mv ${D}/${datadir}/perl/${PVM} ${D}/${datadir}/perl/${PV}
        ln -sf ${PV} ${D}/${libdir}/perl/${PVM}
        ln -sf ${PV} ${D}/${datadir}/perl/${PVM}

        # Remove unwanted file
        rm -f ${D}/${libdir}/perl/${PV}/.packlist

        # Fix up shared library
        mv -f ${D}/${libdir}/perl/${PV}/CORE/libperl.so ${D}/${libdir}/libperl.so.${PV}
        ln -sf libperl.so.${PV} ${D}/${libdir}/libperl.so.5

        # Fix up installed configuration
        sed -i -e "s,${D},,g" \
               -e "s,-isystem${STAGING_INCDIR} ,,g" \
               -e "s,${STAGING_LIBDIR},${libdir},g" \
               -e "s,${STAGING_BINDIR},${bindir},g" \
               -e "s,${STAGING_INCDIR},${includedir},g" \
               -e "s,${TOOLCHAIN_PATH}${base_bindir}/,,g" \
            ${D}${bindir}/h2xs \
            ${D}${bindir}/h2ph \
            ${D}${datadir}/perl/${PV}/pod/*.pod \
            ${D}${datadir}/perl/${PV}/cacheout.pl \
            ${D}${datadir}/perl/${PV}/FileCache.pm \
            ${D}${libdir}/perl/${PV}/Config.pm \
            ${D}${libdir}/perl/${PV}/Config_heavy.pl \
            ${D}${libdir}/perl/${PV}/CORE/perl.h \
            ${D}${libdir}/perl/${PV}/CORE/pp.h
}

do_stage() {
        install -d ${STAGING_LIBDIR_NATIVE}/perl/${PV} \
                   ${STAGING_LIBDIR}/perl/${PV}/CORE \
                   ${STAGING_DATADIR}/perl/${PV}/ExtUtils
        # target config, used by cpan.bbclass to extract version information
        install config.sh ${STAGING_LIBDIR}/perl/
        # target configuration, used by native perl when cross-compiling
        install lib/Config_heavy.pl ${STAGING_LIBDIR_NATIVE}/perl/${PV}/Config_heavy-${TARGET_SYS}.pl
	sed -r -i \
		-e "s,^(archlib=).*$,\1'${STAGING_LIBDIR}/perl/${PV}'," \
		-e "s,^(archlibexp=).*$,\1'${STAGING_LIBDIR}/perl/${PV}'," \
		-e "s,^(privlib=).*$,\1'${STAGING_DATADIR}/perl/${PV}'," \
		-e "s,^(privlibexp=).*$,\1'${STAGING_DATADIR}/perl/${PV}'," \
		${STAGING_LIBDIR_NATIVE}/perl/${PV}/Config_heavy-${TARGET_SYS}.pl \
		${STAGING_LIBDIR}/perl/config.sh
	# target configuration
        install lib/Config.pm       ${STAGING_LIBDIR}/perl/${PV}/
	install lib/ExtUtils/typemap ${STAGING_DATADIR}/perl/${PV}/ExtUtils/
        # perl shared library headers
        for i in av.h embed.h gv.h keywords.h op.h perlio.h pp.h regexp.h \
                 uconfig.h XSUB.h cc_runtime.h embedvar.h handy.h opnames.h \
                 perliol.h pp_proto.h regnodes.h unixish.h config.h EXTERN.h \
                 hv.h malloc_ctl.h pad.h perlsdio.h proto.h scope.h utf8.h \
                 cop.h fakesdio.h INTERN.h mg.h patchlevel.h perlsfio.h \
                 reentr.h sv.h utfebcdic.h cv.h fakethr.h intrpvar.h \
                 nostdio.h overload.h parser.h perlapi.h perlvars.h util.h \
                 dosish.h form.h iperlsys.h opcode.h perl.h perly.h regcomp.h \
                 thread.h warnings.h mydtrace.h git_version.h; do
            install $i ${STAGING_LIBDIR}/perl/${PV}/CORE
        done
}

PACKAGES = "perl-dbg perl perl-misc perl-lib perl-dev perl-pod perl-doc"
FILES_${PN} = "${bindir}/perl ${bindir}/perl${PV}"
FILES_${PN}-lib = "${libdir}/libperl.so* ${libdir}/perl/${PVM} ${datadir}/perl/${PVM} ${datadir}/perl/${PV}/unicore/lib"
FILES_${PN}-dev = "${libdir}/perl/${PV}/CORE"
FILES_${PN}-pod = "${datadir}/perl/${PV}/pod \
		   ${datadir}/perl/${PV}/*.pod \
                   ${datadir}/perl/${PV}/*/*.pod \
                   ${datadir}/perl/${PV}/*/*/*.pod \
                   ${libdir}/perl/${PV}/*.pod"
FILES_perl-misc = "${bindir}/*"
FILES_${PN}-dbg += "${libdir}/perl/${PV}/auto/*/.debug \
                    ${libdir}/perl/${PV}/auto/*/*/.debug \
                    ${libdir}/perl/${PV}/auto/*/*/*/.debug \
                    ${datadir}/perl/${PV}/auto/*/.debug \
                    ${datadir}/perl/${PV}/auto/*/*/.debug \
                    ${datadir}/perl/${PV}/auto/*/*/*/.debug \
                    ${libdir}/perl/${PV}/CORE/.debug"
FILES_${PN}-doc = "${datadir}/perl/${PV}/*/*.txt \
                   ${datadir}/perl/${PV}/*/*/*.txt \
                   ${datadir}/perl/${PV}/B/assemble \
                   ${datadir}/perl/${PV}/B/cc_harness \
                   ${datadir}/perl/${PV}/B/disassemble \
                   ${datadir}/perl/${PV}/B/makeliblinks \
                   ${datadir}/perl/${PV}/CGI/eg \
                   ${datadir}/perl/${PV}/CPAN/PAUSE2003.pub \
                   ${datadir}/perl/${PV}/CPAN/SIGNATURE \
		   ${datadir}/perl/${PV}/CPANPLUS/Shell/Default/Plugins/HOWTO.pod \
                   ${datadir}/perl/${PV}/Encode/encode.h \
                   ${datadir}/perl/${PV}/ExtUtils/MANIFEST.SKIP \
                   ${datadir}/perl/${PV}/ExtUtils/NOTES \
                   ${datadir}/perl/${PV}/ExtUtils/PATCHING \
                   ${datadir}/perl/${PV}/ExtUtils/typemap \
                   ${datadir}/perl/${PV}/ExtUtils/xsubpp \
                   ${datadir}/perl/${PV}/Net/*.eg \
                   ${datadir}/perl/${PV}/unicore/mktables \
                   ${datadir}/perl/${PV}/unicore/mktables.lst \
                   ${datadir}/perl/${PV}/unicore/version \
		   ${datadir}/perl/${PV}/ExtUtils/Changes_EU-Install \
"

RPROVIDES_perl-lib = "perl-lib"

require perl.inc

# Create a perl-modules package recommending all the other perl
# packages (actually the non modules packages and not created too)
ALLOW_EMPTY_perl-modules = "1"
PACKAGES_append = " perl-modules "
RRECOMMENDS_perl-modules = "${@' '.join(all_perl_packages(d))}"

python populate_packages_prepend () {
        libdir = bb.data.expand('${libdir}/perl/${PV}', d)
        do_split_packages(d, libdir, 'auto/(.*)(?!\.debug)/', 'perl-module-%s', 'perl module %s', recursive=True, allow_dirs=False, match_path=True)
        do_split_packages(d, libdir, '(.*)\.(pm|pl|e2x)', 'perl-module-%s', 'perl module %s', recursive=True, allow_dirs=False, match_path=True)
        datadir = bb.data.expand('${datadir}/perl/${PV}', d)
        do_split_packages(d, datadir, 'auto/(.*)(?!\.debug)/', 'perl-module-%s', 'perl module %s', recursive=True, allow_dirs=False, match_path=True)
        do_split_packages(d, datadir, '(.*)\.(pm|pl|e2x)', 'perl-module-%s', 'perl module %s', recursive=True, allow_dirs=False, match_path=True)
}

PACKAGES_DYNAMIC = "perl-module-*"
FILES_perl-module-cpan += "${datadir}/perl/${PV}/CPAN"
FILES_perl-module-cpanplus += "${datadir}/perl/${PV}/CPANPLUS"
FILES_perl-module-unicore-name += "${datadir}/perl/${PV}/unicore"

require perl-rdepends_${PV}.inc
require perl-rprovides.inc
require perl-rprovides_${PV}.inc

PARALLEL_MAKE = ""
