require midori.inc

DEPENDS += "python-native python-docutils-native"

SRC_URI = "http://archive.xfce.org/src/apps/midori/0.2/midori-${PV}.tar.bz2 \
           file://waf"

do_configure() {
	cp -f ${WORKDIR}/waf ${S}/
	sed -i -e 's:, shell=False::g' wscript 
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




SRC_URI[md5sum] = "805e2e59a93a0a4b7652d6547b2bd923"
SRC_URI[sha256sum] = "97c79d20807899bad4b241385c7cbf3a4f85d2673b1b6c12059878450e3e971a"
