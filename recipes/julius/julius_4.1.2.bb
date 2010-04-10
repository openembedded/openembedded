DESCRIPTION = "Julius is a high-performance, two-pass large vocabulary continuous speech recognition (LVCSR) decoder software for speech-related researchers and developers."
LICENSE = "julius"
DEPENDS = "libsndfile1 flex zlib alsa-lib"

PR = "r1"

SRC_URI = "http://iij.dl.sourceforge.jp/julius/37582/julius-${PV}.tar.gz \
           file://patch-julius-4.1.2-command-pipe.patch;patch=1 "

inherit autotools

TARGET_CC_ARCH += "${LDFLAGS}"

EXTRA_OECONF = "--with-mictype=alsa --enable-julian"

do_configure() {
	libtoolize --force
	gnu-configize
	oe_runconf
}

do_install() {
	export prefix=${D}${prefix}
	export libdir=${D}${libdir}
	export bindir=${D}${bindir}
	export includedir=${D}${includedir}
	export mandir=${D}${mandir}
	export exec_prefix=${D}${exec_prefix}
	export datadir=${D}${datadir}

	for i in libsent libjulius julius mkbingram mkbinhmm adinrec adintool mkgshmm mkss jcontrol generate-ngram jclient-perl man ; do
		sed -i -e s:\ /usr/bin:\ \$\{bindir\}:g  -e s:\ /usr/share:\ \$\{datadir\}:g ${S}/$i/Makefile	
		cd ${S}/$i
		oe_runmake -e install
	done

	for i in mkdfa/mkfa-1.44-flex mkdfa dfa_minimize generate accept_check nextword yomi2voca gram2sapixml dfa_determinize ; do
		sed -i -e s:\ /usr/bin:\ \$\{bindir\}:g ${S}/gramtools/$i/Makefile
		cd ${S}/gramtools/$i
		oe_runmake -e install
	done

	for i in ${D}${bindir}/*.pl ; do
		sed -i -e s:${STAGING_BINDIR_NATIVE}:${bindir}:g $i
		echo sed -i -e s:${STAGING_BINDIR_NATIVE}:${bindir}:g $i >> /tmp/k
	done
}

do_stage() {
    export libdir=${STAGING_LIBDIR}
    export bindir=${STAGING_BINDIR}
    export includedir=${STAGING_INCDIR}
    export datadir=${STAGING_DATADIR}

    for i in libsent libjulius julius mkbingram mkbinhmm adinrec adintool mkgshmm mkss jcontrol generate-ngram jclient-perl man ; do
        sed -i -e s:\ /usr/bin:\ \$\{bindir\}:g  -e s:\ /usr/share:\ \$\{datadir\}:g ${S}/$i/Makefile
        cd ${S}/$i
        oe_runmake -e install
    done

    for i in mkdfa/mkfa-1.44-flex mkdfa dfa_minimize generate accept_check nextword yomi2voca gram2sapixml dfa_determinize ; do
        sed -i -e s:\ /usr/bin:\ \$\{bindir\}:g ${S}/gramtools/$i/Makefile
        cd ${S}/gramtools/$i
        oe_runmake -e install
    done
}

SRC_URI[md5sum] = "886a114b391aa1992567019213efc63e"
SRC_URI[sha256sum] = "542c7f1042679c8484dc2f5f5536ed0c79fa79b2b9dd6cf6881278a6fdb37a84"
