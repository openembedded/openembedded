require midori.inc

PR = "r1"

DEPENDS += "python-native python-docutils-native"

SRC_URI = "http://goodies.xfce.org/releases/midori/midori-${PV}.tar.bz2 \
           file://waf"


do_configure() {
	cp -f ${WORKDIR}/waf ${S}/
	./configure \
            --prefix=${prefix} \
            --bindir=${bindir} \
            --sbindir=${sbindir} \
            --libexecdir=${libexecdir} \
            --datadir=${datadir} \
            --sysconfdir=${sysconfdir} \
            --sharedstatedir=${sharedstatedir} \
            --localstatedir=${localstatedir} \
            --libdir=${libdir} \
            --includedir=${includedir} \
            --infodir=${infodir} \
            --mandir=${mandir} \
            ${EXTRA_OECONF} 
 
	sed -i /LINK_CC/d ./_build_/c4che/default.cache.py 
	echo "LINK_CC = '${CXX}'" >>  ./_build_/c4che/default.cache.py
}




SRC_URI[md5sum] = "dccaddeb49d7def8a19cf497cb7eabf8"
SRC_URI[sha256sum] = "cea3848006631801709588b8ae6808dbc768f62b6da4085073075f276309fd0d"
