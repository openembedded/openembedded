MAINTAINER="David Karlstrom <daka@thg.se>"

include perl.inc

SRC_URI += "file://config.sh-armeb-linux \
	    file://config.sh-i386-linux"

PR = "r13"

do_configure() {
	ln -sf ${HOSTPERL} ${STAGING_BINDIR}/hostperl
	cp ${HOSTPERL} hostperl
	cd Cross
	rm Makefile.SH.patch
	cp ${WORKDIR}/Makefile.SH.patch .
	cp ${WORKDIR}/config.sh-mipsel-linux .
	cp ${WORKDIR}/config.sh-i686-linux .
	cp ${WORKDIR}/config.sh-i386-linux .
	cp ${WORKDIR}/config.sh-armeb-linux .
	for i in config.sh-*-linux; do
		a="`echo $i|sed -e 's,^config.sh-,,; s,-linux$,,'`"
		newfile="`echo $i|sed -e 's,-linux$,-linux-uclibc,g'`"
		cat $i | sed -e "s,${a}-linux,${a}-linux-uclibc,g; \
		s,d_sockatmark='define',d_sockatmark='undef',g;" > $newfile
	done
	sed -i -e 's,./install_me_here,${D},g' config.sh-${TARGET_ARCH}-${TARGET_OS}
	rm -f config
	echo "ARCH = ${TARGET_ARCH}" > config
	echo "OS = ${TARGET_OS}" >> config
	oe_runmake patch
}

do_install_append() {
	ln -s libperl.so.${PV} ${D}/${libdir}/libperl.so.5
	sed -i -e "s,${D},,g" ${D}/${libdir}/perl5/${PV}/${TARGET_ARCH}-${TARGET_OS}/Config_heavy.pl
}

# Create a perl-modules package recommending all the other perl
# packages (actually the non modules packages and not created too)
ALLOW_EMPTY_perl-modules = 1
PACKAGES_append = " perl-modules"
RRECOMMENDS_perl-modules = "${PACKAGES}"
RPROVIDES_perl-lib = "perl-lib"
