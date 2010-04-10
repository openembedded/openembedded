require midori.inc

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




SRC_URI[md5sum] = "afed64074b2ed195aae171b2178650e1"
SRC_URI[sha256sum] = "e6cc1b6da8a7af99ba9298e0cb4aac790595f04e04497ea8c2bb4b48c44feb5f"
