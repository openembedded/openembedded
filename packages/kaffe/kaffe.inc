DESCRIPTION = "Kaffe is a clean room implementation of the Java Virtual Machine"
HOMEPAGE = "http://www.kaffe.org/"
LICENSE  = "GPL LGPL W3C Classpath BSD"

DEPENDS = "jikes-native fastjar-native"

SRC_URI += "file://disable-automake-checks.patch;patch=1"

inherit autotools gettext

EXTRA_OECONF = "--with-engine=intrp \
	--with-libffi \
	--with-threads=unix-pthreads \
	--disable-alsatest \
	--disable-esdtest \
	--disable-sound \
	--with-jikes"

CFLAGS += "-D_GNU_SOURCE"

# kaffe installs to non-standard locations. apply a similar workaround to 
# the one used in debian. i.e. override prefix
oe_runconf () {
	if [ -x ${S}/configure ] ; then
		cfgcmd="${S}/configure \
		    --build=${BUILD_SYS} \
		    --host=${HOST_SYS} \
		    --target=${TARGET_SYS} \
		    --prefix=${libdir}/${PN} \
		    --datadir=${datadir} \
		    --sysconfdir=${sysconfdir} \
		    --sharedstatedir=${sharedstatedir}/${PN} \
		    --includedir=${includedir} \
		    --oldincludedir=${oldincludedir} \
		    --infodir=${infodir} \
		    --mandir=${mandir} \
			${EXTRA_OECONF} \
		    $@"
		oenote "Running $cfgcmd..."
		$cfgcmd || oefatal "oe_runconf failed" 
	else
		oefatal "no configure script found"
	fi
}

PACKAGES =+ "${PN}-common"
FILES_${PN} += "${libdir}/${PN}"
RDEPENDS_${PN} = "${PN}-common (>= ${PV})"
FILES_${PN}-common = "${libdir}/${PN}/jre/lib/*.jar"

do_install () {
	autotools_do_install

	# move partially duplicate stuff to a single location
	mv -f ${D}${libdir}/${PN}/bin/* ${D}${libdir}/${PN}/jre/bin
	rmdir ${D}${libdir}/${PN}/bin
	cd ${D}${libdir}/${PN} && ln -s jre/bin
}

# use update-alternatives for the various wrapper scripts
alternative_names = "appletviewer \
install-jar \
jar \
java \
javac \
javadoc \
javah \
javap \
kaffe \
kaffeh \
native2ascii \
rmic \
rmiregistry \
serialver"

pkg_postinst() {
	for name in ${alternative_names}; do
		update-alternatives --install ${bindir}/$name $name ${libdir}/${PN}/jre/bin/$name 300
	done
}

pkg_postrm() {
	for name in ${alternative_names}; do
		update-alternatives --remove $name ${libdir}/${PN}/jre/bin/$name
	done
}
