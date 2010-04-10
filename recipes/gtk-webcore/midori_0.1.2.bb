require midori.inc

DEPENDS += "python-native python-docutils-native"

SRC_URI = "http://goodies.xfce.org/releases/midori/midori-${PV}.tar.bz2"


do_configure() {
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




SRC_URI[md5sum] = "5169ead6783f374cedf3f89bf399bd75"
SRC_URI[sha256sum] = "a966641cf1b6e18e4f58aa3585a9a63905ed50252883804c006a3263674a32ec"
