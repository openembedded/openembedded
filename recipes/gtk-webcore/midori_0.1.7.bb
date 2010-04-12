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




SRC_URI[md5sum] = "c6299ecf93417526f37bc0154c18b126"
SRC_URI[sha256sum] = "9b74a776831c3680c10ad5c3d04985a1368c4fdf2f383a0e8efcc3cda925baaf"
