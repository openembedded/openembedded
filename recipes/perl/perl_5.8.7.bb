
# We need gnugrep (for -I)
DEPENDS_append += " grep-native"

require perl.inc

SRC_URI += "file://config.sh-armeb-linux \
	    file://config.sh-arm-linux \
	    file://config.sh-powerpc-linux \
	    file://config.sh-mipsel-linux \
	    file://config.sh-i386-linux \
	    file://config.sh-i486-linux \
	    file://config.sh-i586-linux \
	    file://config.sh-i686-linux \
	    file://config.sh-x86_64-linux \
	    file://config.sh-sh3-linux \
	    file://config.sh-sh4-linux"

# Use gcc to link and use PIC mode for compiling shared libs
GCCLINK_SRC = "file://override-generate-sh.patch;patch=1 \
               file://makefile-usegcc-to-link.patch;patch=1"

SRC_URI_append_sh4 += " ${GCCLINK_SRC}"
SRC_URI_append_sh3 += " ${GCCLINK_SRC}"
SRC_URI_append_powerpc += " ${GCCLINK_SRC}"

PARALLEL_MAKE = ""

PR = "r23"

do_configure() {
	ln -sf ${HOSTPERL} ${STAGING_BINDIR_NATIVE}/hostperl
	cp ${HOSTPERL} hostperl
	cd Cross
	rm -f Makefile.SH.patch
	cp ${WORKDIR}/Makefile.SH.patch .
	cp ${WORKDIR}/config.sh-mipsel-linux .
	cp ${WORKDIR}/config.sh-i386-linux .
	cp ${WORKDIR}/config.sh-i486-linux .
	cp ${WORKDIR}/config.sh-i586-linux .
	cp ${WORKDIR}/config.sh-i686-linux .
	cp ${WORKDIR}/config.sh-x86_64-linux .
	cp ${WORKDIR}/config.sh-armeb-linux .
	cp ${WORKDIR}/config.sh-powerpc-linux .
	cp ${WORKDIR}/config.sh-sh3-linux .
	cp ${WORKDIR}/config.sh-sh4-linux .
	#perl insists on an extra config.sh for arm EABI
	cp config.sh-arm-linux config.sh-arm-linux-gnueabi
	cp config.sh-armeb-linux config.sh-armeb-linux-gnueabi
	# nslu2 LE uclibc builds do not work with the default config.sh
	if test "${MACHINE}" = nslu2
	then
		rm -f ./config.sh-arm-linux
		cp ${WORKDIR}/config.sh-arm-linux .
	fi
	for i in config.sh-*-linux; do
		a="`echo $i|sed -e 's,^config.sh-,,; s,-linux$,,'`"
		newfile="`echo $i|sed -e 's,-linux$,-linux-uclibc,g'`"
		cat $i | sed -e "s,${a}-linux,${a}-linux-uclibc,g; \
		s,d_sockatmark='define',d_sockatmark='undef',g;" > $newfile
	done
	sed -i -e 's,./install_me_here,${D},g' config.sh-${TARGET_ARCH}-${TARGET_OS}
	sed -i -e "s%/usr/include/%${STAGING_INCDIR}/%g" config.sh-${TARGET_ARCH}-${TARGET_OS}

	#These are strewn all over the source tree
	for foo in `grep -I -m1 \/usr\/include\/.*\\.h ${WORKDIR}/* -r | cut -f 1 -d ":"` ; do
		echo Fixing: $foo
		sed -e "s%/usr/include/%${STAGING_INCDIR}/%g" -i $foo
	done
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
ALLOW_EMPTY_perl-modules = "1"
PACKAGES_append = " perl-modules"
RRECOMMENDS_perl-modules = "${PACKAGES}"
RPROVIDES_perl-lib = "perl-lib"


require perl-rdepends_${PV}.inc

# To create/update the perl-rdepends_${PV}.inc use this piece of ugly script (modified for your arch/paths etc):
# daka@DaKa2:/home/slug/slugos/tmp/work/perl-5.8.7-r14/install$ egrep -r "use|require" * | grep ";$" | egrep ".pm:use |.pm:require " | grep -v v5.6.0 | grep -v 5.00 | grep -v \$module | sed -e "s, \+, ,g" | cut -f1,2 -d" " | sed -e "s,;, ,g" | sed -e "s,(), ,g" | sed -e "s,::,-,g" | sort | uniq | tr [:upper:] [:lower:] | sed -e "s,/[^ ]\+ , += \"perl-module-,g" | sed -e "s, \?$, \",g" | sed -e "s,_,-,g" | sed -e "s,^,RDEPENDS_,g" | sed -e "s,armeb-linux,\$\{TARGET_ARCH\}-\$\{TARGET_OS\},g" | egrep -v "perl-module-5|perl-module-tk|perl-module-mac-internetconfig|perl-module-ndbm-file|perl-module-html-treebuilder|perl-module-lwp-simple|perl-module-vms-filespec|perl-module-fcgi|perl-module-vms-stdio|perl-module-mac-buildtools" > /home/slug/openembedded/packages/perl/perl-rdepends_5.8.7.inc

# Some additional dependencies that the above doesn't manage to figure out
DEPENDS_perl-module-math-bigint += "perl-module-math-bigint-calc "
DEPENDS_perl-module-math-bigint-calc += "perl-module-integer "

require perl-rprovides.inc
