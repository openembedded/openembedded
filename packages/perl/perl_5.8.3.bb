DESCRIPTION = "Perl is a popular scripting language."
HOMEPAGE = "http://www.perl.org/"
LICENSE = "Artistic|GPL"
SECTION = "devel"
PRIORITY = "optional"
DEPENDS = "db3 perl-native"
PR = "r2"

SRC_URI = "http://ftp.funet.fi/pub/CPAN/src/perl-${PV}.tar.gz \
	file://Makefile.patch;patch=1 \
	file://config.sh-arm-linux.patch;patch=1 \
	file://libperl-5.8.3-create-libperl-soname.patch;patch=1;pnum=0 \
	file://Makefile.SH.patch \
	file://config.sh-mipsel-linux"

HOSTPERL=${STAGING_BINDIR}/perl${PV}

do_configure() {
	ln -sf ${HOSTPERL} ${STAGING_BINDIR}/hostperl 
	cp ${HOSTPERL} hostperl
	cd Cross
	rm Makefile.SH.patch
	cp ${WORKDIR}/Makefile.SH.patch .
	cp ${WORKDIR}/config.sh-mipsel-linux .
	cat config.sh-${TARGET_ARCH}-${TARGET_OS} | sed -e's,./install_me_here,${D},g' > config.sh-${TARGET_ARCH}-${TARGET_OS}.new
	mv config.sh-${TARGET_ARCH}-${TARGET_OS}.new config.sh-${TARGET_ARCH}-${TARGET_OS}
	rm -f config
	echo "ARCH = ${TARGET_ARCH}" > config
	echo "OS = ${TARGET_OS}" >> config
	oe_runmake patch 
}

do_compile() {
	cd Cross
	oe_runmake perl
}

do_install() {
	oe_runmake install
	mv ${D}/${libdir}/perl5/${PV}/${TARGET_ARCH}-${TARGET_OS}/CORE/libperl.so ${D}/${libdir}/libperl.so.${PV}
	( cd ${D}/usr/bin/; rm perl; ln -s perl${PV} perl )
}

do_stage() {
	install -d ${STAGING_DIR}/${HOST_SYS}/perl/
	install config.sh ${STAGING_DIR}/${HOST_SYS}/perl/
}

python populate_packages_prepend () {
	libdir = bb.data.expand('${libdir}/perl5/${PV}', d)
	archlibdir =  bb.data.expand('${libdir}/perl5/${PV}/${TARGET_ARCH}-${TARGET_OS}', d)
	
	do_split_packages(d, archlibdir, 'auto/(.*)/', 'perl-module-%s', 'perl module %s', recursive=True, allow_dirs=False, match_path=True)
	do_split_packages(d, archlibdir, '(.*)\.(pm|pl)', 'perl-module-%s', 'perl module %s', recursive=True, allow_dirs=False, match_path=True)	
	do_split_packages(d, libdir, '(.*)\.(pm|pl)', 'perl-module-%s', 'perl module %s', recursive=True, allow_dirs=False, match_path=True)
}

PACKAGES = "perl perl-misc perl-lib perl-dev perl-pod"
FILES_${PN} = "/usr/bin/perl /usr/bin/perl${PV}"
FILES_${PN}-lib = "/usr/lib/libperl.so*"
FILES_${PN}-dev = "/usr/lib/perl5/${PV}/${TARGET_ARCH}-${TARGET_OS}/CORE/"
FILES_${PN}-pod = "/usr/lib/perl5/${PV}/pod"
FILES_perl-misc = "/usr/bin/"
