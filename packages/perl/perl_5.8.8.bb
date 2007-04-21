DESCRIPTION = "Perl is a popular scripting language."
HOMEPAGE = "http://www.perl.org/"
SECTION = "devel"
LICENSE = "Artistic|GPL"
PRIORITY = "optional"
# We need gnugrep (for -I)
DEPENDS = "virtual/db perl-native grep-native"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "ftp://ftp.funet.fi/pub/CPAN/src/perl-${PV}.tar.gz \
        file://Makefile.patch;patch=1 \
        file://Makefile.SH.patch \
        file://perl-dynloader.patch;patch=1 \
        file://perl-moreconfig.patch;patch=1 \
        file://generate-sh.patch;patch=1 \
        file://config.sh-32 \
        file://config.sh-32-le \
        file://config.sh-32-be \
        file://config.sh-64 \
        file://config.sh-64-le \
        file://config.sh-64-be"

# Where to find the native perl
HOSTPERL = "${STAGING_BINDIR_NATIVE}/perl${PV}"

# Architecture specific libdir (for .so's)
ARCHLIBDIR = "${TARGET_ARCH}-${TARGET_OS}-thread-multi"

# Where to find .so files - use the -native versions not those from the target build
export PERLHOSTLIB = "${STAGING_DIR}/${BUILD_SYS}/lib/perl5/${PV}/${BUILD_ARCH}-${BUILD_OS}-thread-multi/"

do_configure() {
        # Put a hostperl in staging - should probably be part of do_deploy for native
        ln -sf ${HOSTPERL} ${STAGING_BINDIR_NATIVE}/hostperl

        # Make hostperl in build directory be the native perl
        cp -f ${HOSTPERL} hostperl

        # This is silly - should just patch Makefile.SH directly
        cd Cross
        cp -f ${WORKDIR}/Makefile.SH.patch .

        # Generate configuration
        rm -f config.sh-${TARGET_ARCH}-${TARGET_OS}
        touch config.sh-${TARGET_ARCH}-${TARGET_OS}
        cat ${WORKDIR}/config.sh-${@siteinfo_get_bits(d)} \
                >> config.sh-${TARGET_ARCH}-${TARGET_OS}
        cat ${WORKDIR}/config.sh-${@siteinfo_get_bits(d)}-${@siteinfo_get_endianess(d)} \
                >> config.sh-${TARGET_ARCH}-${TARGET_OS}

        # uclibc not checked with this version yet
        # uclicb fixups
        #for i in config.sh-*-linux; do
        #        a="`echo $i|sed -e 's,^config.sh-,,; s,-linux$,,'`"
        #        newfile="`echo $i|sed -e 's,-linux$,-linux-uclibc,g'`"
        #        cat $i | sed -e "s,${a}-linux,${a}-linux-uclibc,g; \
        #        s,d_sockatmark='define',d_sockatmark='undef',g;" > $newfile
        #done

        # Update some paths in the configuration
        sed -i -e 's,@DESTDIR@,${D},g' config.sh-${TARGET_ARCH}-${TARGET_OS}
        sed -i -e 's,@ARCH@,${TARGET_ARCH}-${TARGET_OS},g' config.sh-${TARGET_ARCH}-${TARGET_OS}
        sed -i -e "s%/usr/include/%${STAGING_INCDIR}/%g" config.sh-${TARGET_ARCH}-${TARGET_OS}

        if test "${MACHINE}" != "native"; then
            # These are strewn all over the source tree
            for foo in `grep -I -m1 \/usr\/include\/.*\\.h ${WORKDIR}/* -r | cut -f 1 -d ":"` ; do
                echo Fixing: $foo
                sed -e "s%/usr/include/%${STAGING_INCDIR}/%g" -i $foo
            done
        fi

        rm -f config
        echo "ARCH = ${TARGET_ARCH}" > config
        echo "OS = ${TARGET_OS}" >> config

        oe_runmake patch
}
do_compile() {
        if test "${MACHINE}" != "native"; then
            sed -i -e 's|/usr/include|${STAGING_INCDIR}|g' ext/Errno/Errno_pm.PL
        fi
        cd Cross
        oe_runmake perl LD="${TARGET_SYS}-gcc"
}
do_install() {
        oe_runmake install
        mv -f ${D}/${libdir}/perl5/${PV}/${ARCHLIBDIR}/CORE/libperl.so ${D}/${libdir}/libperl.so.${PV}
        ln -sf perl${PV} ${D}/usr/bin/perl
        ln -sf libperl.so.${PV} ${D}/${libdir}/libperl.so.5
        if test "${MACHINE}" != "native"; then
            sed -i -e "s,${D},,g" ${D}/${libdir}/perl5/${PV}/${ARCHLIBDIR}/Config_heavy.pl
        fi
}
do_stage() {
        install -d ${STAGING_DIR}/${HOST_SYS}/perl/
        install config.sh ${STAGING_DIR}/${HOST_SYS}/perl/
}

PACKAGES = "perl-dbg perl perl-misc perl-lib perl-dev perl-pod"
FILES_${PN} = "/usr/bin/perl /usr/bin/perl${PV}"
FILES_${PN}-lib = "/usr/lib/libperl.so*"
FILES_${PN}-dev = "/usr/lib/perl5/${PV}/${ARCHLIBDIR}/CORE/"
FILES_${PN}-pod = "/usr/lib/perl5/${PV}/pod"
FILES_perl-misc = "/usr/bin/*"
FILES_${PN}-dbg += " ${libdir}/perl5/${PV}/${ARCHLIBDIR}/auto/*/.debug \
                     ${libdir}/perl5/${PV}/${ARCHLIBDIR}/auto/*/*/.debug \
                     ${libdir}/perl5/${PV}/${ARCHLIBDIR}/auto/*/*/*/.debug"

python populate_packages_prepend () {
        libdir = bb.data.expand('${libdir}/perl5/${PV}', d)
        archlibdir =  bb.data.expand('${libdir}/perl5/${PV}/${ARCHLIBDIR}', d)
        do_split_packages(d, archlibdir, 'auto/(.*)(?!\.debug)/', 'perl-module-%s', 'perl module %s', recursive=True, allow_dirs=False, match_path=True)
        do_split_packages(d, archlibdir, '(.*)\.(pm|pl)', 'perl-module-%s', 'perl module %s', recursive=True, allow_dirs=False, match_path=True)
        do_split_packages(d, libdir, '(.*)\.(pm|pl)', 'perl-module-%s', 'perl module %s', recursive=True, allow_dirs=False, match_path=True)
}

# Create a perl-modules package recommending all the other perl
# packages (actually the non modules packages and not created too)
ALLOW_EMPTY_perl-modules = "1"
PACKAGES_append = " perl-modules "
RRECOMMENDS_perl-modules = "${@bb.data.getVar('PACKAGES', d, 1).replace('perl-modules ', '').replace('perl-dbg ', '').replace('perl-misc ', '').replace('perl-dev ', '').replace('perl-pod ', '')}"
RPROVIDES_perl-lib = "perl-lib"

require perl-rdepends_${PV}.inc

# To create/update the perl-rdepends_${PV}.inc use this piece of ugly script (modified for your arch/paths etc):
# daka@DaKa2:/home/slug/slugos/tmp/work/perl-5.8.7-r14/install$ egrep -r "use|require" * | grep ";$" | egrep ".pm:use |.pm:require " | grep -v v5.6.0 | grep -v 5.00 | grep -v \$module | sed -e "s, \+, ,g" | cut -f1,2 -d" " | sed -e "s,;, ,g" | sed -e "s,(), ,g" | sed -e "s,::,-,g" | sort | uniq | tr [:upper:] [:lower:] | sed -e "s,/[^ ]\+ , += \"perl-module-,g" | sed -e "s, \?$, \",g" | sed -e "s,_,-,g" | sed -e "s,^,RDEPENDS_,g" | sed -e "s,armeb-linux,\$\{TARGET_ARCH\}-\$\{TARGET_OS\},g" | egrep -v "perl-module-5|perl-module-tk|perl-module-mac-internetconfig|perl-module-ndbm-file|perl-module-html-treebuilder|perl-module-lwp-simple|perl-module-vms-filespec|perl-module-fcgi|perl-module-vms-stdio|perl-module-mac-buildtools" > /home/slug/openembedded/packages/perl/perl-rdepends_5.8.7.inc

# Some additional dependencies that the above doesn't manage to figure out
DEPENDS_perl-module-math-bigint += "perl-module-math-bigint-calc "
DEPENDS_perl-module-math-bigint-calc += "perl-module-integer "

# Some packages changed names in 5.8.7-r14, RPROVIDE them
RPROVIDES_perl-module-b-asmdata = "perl-module-${TARGET_SYS}-b-asmdata"
RPROVIDES_perl-module-b-assembler = "perl-module-${TARGET_SYS}-b-assembler"
RPROVIDES_perl-module-b-bblock = "perl-module-${TARGET_SYS}-b-bblock"
RPROVIDES_perl-module-b-bytecode = "perl-module-${TARGET_SYS}-b-bytecode"
RPROVIDES_perl-module-b-cc = "perl-module-${TARGET_SYS}-b-cc"
RPROVIDES_perl-module-b-concise = "perl-module-${TARGET_SYS}-b-concise"
RPROVIDES_perl-module-b-debug = "perl-module-${TARGET_SYS}-b-debug"
RPROVIDES_perl-module-b-deparse = "perl-module-${TARGET_SYS}-b-deparse"
RPROVIDES_perl-module-b-disassembler = "perl-module-${TARGET_SYS}-b-disassembler"
RPROVIDES_perl-module-b-lint = "perl-module-${TARGET_SYS}-b-lint"
RPROVIDES_perl-module-b-showlex = "perl-module-${TARGET_SYS}-b-showlex"
RPROVIDES_perl-module-b-stackobj = "perl-module-${TARGET_SYS}-b-stackobj"
RPROVIDES_perl-module-b-stash = "perl-module-${TARGET_SYS}-b-stash"
RPROVIDES_perl-module-b-terse = "perl-module-${TARGET_SYS}-b-terse"
RPROVIDES_perl-module-b-xref = "perl-module-${TARGET_SYS}-b-xref"
RPROVIDES_perl-module-config = "perl-module-${TARGET_SYS}-config"
RPROVIDES_perl-module-config-heavy = "perl-module-${TARGET_SYS}-config-heavy"
RPROVIDES_perl-module-encode-alias = "perl-module-${TARGET_SYS}-encode-alias"
RPROVIDES_perl-module-encode-cjkconstants = "perl-module-${TARGET_SYS}-encode-cjkconstants"
RPROVIDES_perl-module-encode-config = "perl-module-${TARGET_SYS}-encode-config"
RPROVIDES_perl-module-encode-encoder = "perl-module-${TARGET_SYS}-encode-encoder"
RPROVIDES_perl-module-encode-encoding = "perl-module-${TARGET_SYS}-encode-encoding"
RPROVIDES_perl-module-encode-guess = "perl-module-${TARGET_SYS}-encode-guess"
RPROVIDES_perl-module-encoding = "perl-module-${TARGET_SYS}-encoding"
RPROVIDES_perl-module-errno = "perl-module-${TARGET_SYS}-errno"
RPROVIDES_perl-module-io-dir = "perl-module-${TARGET_SYS}-io-dir"
RPROVIDES_perl-module-io-file = "perl-module-${TARGET_SYS}-io-file"
RPROVIDES_perl-module-io-handle = "perl-module-${TARGET_SYS}-io-handle"
RPROVIDES_perl-module-io-pipe = "perl-module-${TARGET_SYS}-io-pipe"
RPROVIDES_perl-module-io-poll = "perl-module-${TARGET_SYS}-io-poll"
RPROVIDES_perl-module-io-seekable = "perl-module-${TARGET_SYS}-io-seekable"
RPROVIDES_perl-module-io-select = "perl-module-${TARGET_SYS}-io-select"
RPROVIDES_perl-module-io-socket = "perl-module-${TARGET_SYS}-io-socket"
RPROVIDES_perl-module-ipc-msg = "perl-module-${TARGET_SYS}-ipc-msg"
RPROVIDES_perl-module-ipc-semaphore = "perl-module-${TARGET_SYS}-ipc-semaphore"
RPROVIDES_perl-module-lib = "perl-module-${TARGET_SYS}-lib"
RPROVIDES_perl-module-mime-quotedprint = "perl-module-${TARGET_SYS}-mime-quotedprint"
RPROVIDES_perl-module-o = "perl-module-${TARGET_SYS}-o"
RPROVIDES_perl-module-ops = "perl-module-${TARGET_SYS}-ops"
RPROVIDES_perl-module-safe = "perl-module-${TARGET_SYS}-safe"
RPROVIDES_perl-module-xsloader = "perl-module-${TARGET_SYS}-xsloader"

PARALLEL_MAKE = ""
