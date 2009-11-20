require perl.inc

PR = "r6"

SRC_URI += "file://uclibc.patch;patch=1 \
            file://config.sh-mipsel-linux \
            file://config.sh-i686-linux"

do_configure() {
	ln -sf ${HOSTPERL} ${STAGING_BINDIR_NATIVE}/hostperl 
	cp ${HOSTPERL} hostperl
	cd Cross
	rm -f Makefile.SH.patch
	cp ${WORKDIR}/Makefile.SH.patch .
	cp ${WORKDIR}/config.sh-mipsel-linux .
	cp ${WORKDIR}/config.sh-i686-linux .
	cat config.sh-arm-linux | sed -e "s,arm-linux,armeb-linux,g" > config.sh-armeb-linux
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
